import configuration.Constant;
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
    @Test
    public void createProjectAPI() throws InterruptedException {
        //Create project API
        ManageProjectService manageProjectService = new ManageProjectService();
        manageProjectService.createProjectAPI(Constant.TOKEN, DataGenerateUtils.randomString(5));

        //Login into mobile application
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        ManageProjectPage manageProjectPage = new ManageProjectPage(driver);
        manageProjectPage.selectMenu();
        manageProjectPage.clickManageProject();

        //Compare project name just created
        Assert.assertEquals(manageProjectPage.getProjectName(),manageProjectService.getNameNewestName(Constant.TOKEN),"Project name was wrong");
    }
    @Test
    public void createTaskMobile(){
        //Login into mobile application
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        //create task
        String titleTask = DataGenerateUtils.randomString(5);
        String taskDescription = DataGenerateUtils.randomString(10);
        CreateTaskPage createTaskPage = new CreateTaskPage(driver);
        createTaskPage.createTask(titleTask,taskDescription);

        //Compare task name just created with API
        ManageTaskService manageTaskService = new ManageTaskService();
        Assert.assertEquals(titleTask, manageTaskService.getNewestContent(Constant.TOKEN),"task name was wrong");
    }
    @Test
    public void reopenTask(){
        //login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        //get id task just created
        ManageTaskService manageTaskService = new ManageTaskService();
        String id = manageTaskService.getNewestId(Constant.TOKEN);

        //get title task UI before close task
        ManageTaskPage manageTaskPage = new ManageTaskPage(driver);
        String titleUI = manageTaskPage.getTitleTask();

        //complete task
        CreateTaskPage createTaskPage = new CreateTaskPage(driver);
        createTaskPage.ClickCompleteTask();

        //reopen Task via API
        manageTaskService.reOpenTaskAPI(id, Constant.TOKEN);

        //Compare task just created
        Assert.assertEquals(titleUI, manageTaskPage.getTitleTask(),"task name was wrong");
    }
}