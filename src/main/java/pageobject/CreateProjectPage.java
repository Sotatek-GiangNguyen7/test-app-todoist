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

    public CreateProjectPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public void addProject() {
        clickElement(submitBtn);
    }

    public void inputProjectName(String value) {
        sendKey(projectName, value);
    }

    public void createProject(String value) {
        inputProjectName(value);
        addProject();
    }
}
