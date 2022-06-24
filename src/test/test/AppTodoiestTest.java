import configuration.Constant;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobject.CreateTaskPage;
import pageobject.ManageProjectPage;
import pageobject.ManageTaskPage;
import pageobject.MenuPage;
import pageobject.common.LoginPage;
import pageobject.common.NavigationBarPage;
import services.ManageProjectService;
import services.ManageTaskService;
import src.core.driver.TestSetUp;
import src.core.resource.utils.DataGenerateUtils;
import utils.listeners.TestListener;

@Listeners({TestListener.class})
public class AppTodoiestTest extends TestSetUp {
    private String projectName;

    @Test(priority = 0)
    public void createProjectAPI() throws InterruptedException {
        //Create project AP I
        ManageProjectService manageProjectService = new ManageProjectService();
        projectName = "Project " + DataGenerateUtils.randomString(5);
        manageProjectService.createProjectAPI(Constant.TOKEN, projectName);

        //Login into mobile application
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithEmail(Constant.USERNAME,Constant.PASSWORD);

        //Goto manage project
        NavigationBarPage navigationBarPage = new NavigationBarPage(driver);
        navigationBarPage.clickMenu();

        //project list
        MenuPage menuPage = new MenuPage(driver);
        menuPage.clickManageProject();

        ManageProjectPage manageProjectPage = new ManageProjectPage(driver);

        //Compare project name just created
        Assert.assertEquals(manageProjectPage.getLastestProjectName(), projectName,"Project name was wrong");
    }

    @Test(priority = 1)
    public void createTaskMobile() {
        //Login into mobile application
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithEmail(Constant.USERNAME,Constant.PASSWORD);

        //create new task in project just created
        String titleTask = "Task " + DataGenerateUtils.randomString(5);
        String taskDescription = "Description " + DataGenerateUtils.randomString(10);

        NavigationBarPage navigationBarPage = new NavigationBarPage(driver);
        navigationBarPage.clickMenu();

        MenuPage menuPage = new MenuPage(driver);
        menuPage.selectProject();
        navigationBarPage.clickAddTaskBtn();

        CreateTaskPage createTaskPage = new CreateTaskPage(driver);
        createTaskPage.createTask(titleTask, taskDescription);

        //Compare task name just created via API
        ManageTaskService manageTaskService = new ManageTaskService();
        Assert.assertEquals(titleTask, manageTaskService.getNewestContent(Constant.TOKEN), "task name was wrong");
    }

    @Test(priority = 2)
    public void reopenTask() {
        //login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithEmail(Constant.USERNAME,Constant.PASSWORD);

        //get id task just created API
        ManageTaskService manageTaskService = new ManageTaskService();
        String id = manageTaskService.getNewestId(Constant.TOKEN);

        //get title task UI before close task
        NavigationBarPage navigationBarPage = new NavigationBarPage(driver);
        navigationBarPage.clickMenu();

        MenuPage menuPage = new MenuPage(driver);
        menuPage.selectProject();

        ManageTaskPage manageTaskPage = new ManageTaskPage(driver);
        String titleTaskUI = manageTaskPage.getTitleTask();

        //complete task
        manageTaskPage.clickCompleteTask();

        //reopen Task via API
        manageTaskService.reOpenTaskAPI(id, Constant.TOKEN);

        //Compare task just reopened
        Assert.assertEquals(titleTaskUI, manageTaskPage.getTitleTask(), "task name was wrong");
    }

}