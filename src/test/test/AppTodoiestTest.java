import configuration.Constant;
import dto.ProjectObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.CreateTaskPage;
import pageobject.ManageProjectPage;
import pageobject.ManageTaskPage;
import pageobject.common.LoginPage;
import services.ManageProjectService;
import services.ManageTaskService;
import src.core.driver.TestSetUp;
import src.core.resource.utils.DataGenerateUtils;

public class AppTodoiestTest extends TestSetUp {
    private String projectName;
    @Test(priority = 0)
    public void createProjectAPI() throws InterruptedException {
        //Create project API
        ManageProjectService manageProjectService = new ManageProjectService();
        projectName = "Project " + DataGenerateUtils.randomString(5);
        manageProjectService.createProjectAPI(Constant.TOKEN, projectName);

        //Login into mobile application
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        //Goto manage project
        ManageProjectPage manageProjectPage = new ManageProjectPage(driver);
        manageProjectPage.selectMenu();
        manageProjectPage.clickManageProject();

        //Compare project name just created
        Assert.assertEquals(manageProjectPage.getProjectName(projectName),manageProjectService.getNameNewestName(Constant.TOKEN),"Project name was wrong");
    }
    @Test(priority = 1)
    public void createTaskMobile() {
        //Login into mobile application
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        //create task in project just created
        String titleTask = "Task " + DataGenerateUtils.randomString(5);
        String taskDescription = "Description " + DataGenerateUtils.randomString(10);
        CreateTaskPage createTaskPage = new CreateTaskPage(driver);
        createTaskPage.createTask(titleTask, taskDescription, projectName);

        //Compare task name just created with API
        ManageTaskService manageTaskService = new ManageTaskService();
        Assert.assertEquals(titleTask, manageTaskService.getNewestContent(Constant.TOKEN), "task name was wrong");
    }
    @Test(priority = 2)
    public void reopenTask() {
        //login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        //get id task just created
        ManageTaskService manageTaskService = new ManageTaskService();
        String id = manageTaskService.getNewestId(Constant.TOKEN);

        //get title task UI before close task
        ManageTaskPage manageTaskPage = new ManageTaskPage(driver);
        manageTaskPage.openProject(projectName);
        String titleTaskUI = manageTaskPage.getTitleTask();

        //complete task
        CreateTaskPage createTaskPage = new CreateTaskPage(driver);
        createTaskPage.clickCompleteTask();

        //reopen Task via API
        manageTaskService.reOpenTaskAPI(id, Constant.TOKEN);

        //Compare task just created
        Assert.assertEquals(titleTaskUI, manageTaskPage.getTitleTask(), "task name was wrong");
    }

}