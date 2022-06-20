import configuration.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.CreateProjectPage;
import pageobject.CreateTaskPage;
import pageobject.ManageProjectPage;
import pageobject.ManageTaskPage;
import pageobject.common.LoginPage;
import services.ManageProjectService;
import services.ManageTaskService;
import src.core.driver.TestSetUp;

public class AppTodoiestTest extends TestSetUp {

    @Test
    public void createProjectAPI() throws InterruptedException {
        //Create project by API
        ManageProjectService manageProjectService = new ManageProjectService();
        manageProjectService.createProjectAPI(Constant.TOKEN,"Shopping list");

        //Login into mobile application
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        ManageProjectPage manageProjectPage = new ManageProjectPage(driver);
        manageProjectPage.selectMenu();
        manageProjectPage.manageProject();

        //Compare project name just created
        Assert.assertEquals(manageProjectPage.getProjectName(),"Shopping list","Project name is wrong");
    }

    @Test
    public void createProjectMobile(){
        //Login into mobile application
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        //Create project
        CreateProjectPage createProjectPage = new CreateProjectPage(driver);
        createProjectPage.createProject("Shopping list");

        //Compare project nam just created
        ManageProjectService manageProjectService = new ManageProjectService();
        Assert.assertEquals("Shopping list", manageProjectService.getNameNewestData(Constant.TOKEN),"Project name is wrong");
    }

    @Test
    public void reopenTask(){
        //login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();

        //create task
        CreateTaskPage createTaskPage = new CreateTaskPage(driver);
        createTaskPage.createTask("Play football","with my friend");

        //get id task just created
        ManageTaskService manageTaskService = new ManageTaskService();
        String id = manageTaskService.getNewestId(Constant.TOKEN);

        //check mark
        createTaskPage.checkMark();
        manageTaskService.reOpenTaskAPI(id, Constant.TOKEN);

        //relogin
        loginPage.login();
        ManageTaskPage manageTaskPage = new ManageTaskPage(driver);

        //Compare task just created
        Assert.assertEquals("Play football", manageTaskPage.getTitle("Play football"),"task name is wrong");
    }
}