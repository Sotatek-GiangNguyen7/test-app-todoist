package pageobject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import src.core.driver.AndroidDriverAction;

public class CreateProjectPage extends AndroidDriverAction {
    By menuBtn = By.xpath("//android.widget.ImageButton[@content-desc=\"Menu\"]");
    By createBtn = By.xpath("//android.widget.ImageButton[@content-desc=\"Add\"]");
    By projectName = By.id("com.todoist:id/name");
    By submitBtn = By.id("com.todoist:id/menu_form_submit");
    By getText = By.xpath("//android.widget.TextView[@text='Shopping list']");

    public CreateProjectPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public void selectMenu() {
        clickElement(menuBtn);
        wait(5000);
    }

    public void createProjectBtn() {
        clickElement(createBtn);
    }

    public void addProject() {
        clickElement(submitBtn);
    }

    public void inputProjectName(String value) {
        sendKey(projectName, value);
    }

    public void createProject(String value) {
        selectMenu();
        createProjectBtn();
        inputProjectName(value);
        addProject();
    }
}
