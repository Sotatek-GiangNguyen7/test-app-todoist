import com.jayway.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.CreateProjectPage;
import pageobject.ManageProjectPage;
import pageobject.common.LoginPage;
import services.ManageProjectService;
import src.core.api.*;
import src.core.driver.TestSetUp;

public class APITest extends TestSetUp {
/*    @Test
    public void testPostMethod () {
        //Test Setup
        APIRequest apiRequest = new APIRequest();
        apiRequest
                .setInstances()
                .setToken("abeab110d8c29bbfab9fae46da9f3e21fffbd436")
                .setContentType(ContentType.JSON)
                .setBody("name","ok")
                .post("https://api.todoist.com/rest/v1/projects");
    }*/

    public void createProjectAPI() throws InterruptedException {
        //Create project by API
        ManageProjectService manageProjectService = new ManageProjectService();
        manageProjectService.createProjectAPI();

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

        CreateProjectPage createProjectPage = new CreateProjectPage(driver);
        createProjectPage.createProject("Shopping List");
    }
}