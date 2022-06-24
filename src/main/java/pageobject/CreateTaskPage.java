package pageobject;

import dto.TaskObject;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import src.core.driver.AndroidDriverAction;

public class CreateTaskPage extends AndroidDriverAction {

    By title = By.id("android:id/message");
    By saveBtn = By.xpath("//android.widget.ImageView[@content-desc=\"Add\"]");
    String projectNameString = "//android.widget.TextView[@text='%s']";

    public CreateTaskPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public void selectProject(String projectTitle){
        String projectName = String.format(projectNameString, projectTitle);
        clickElement(By.xpath(projectName));
    }

    public void inputTitle(String key) {
        sendKey(title, key);
    }


    public void saveTask() {
        clickElement(saveBtn);
    }

    public void backHome() {
        nagativeBack();
    }

    public void createTask(String title, String des) {
        inputTitle(title);
        saveTask();
        backHome();
        wait(2000);
    }
}
