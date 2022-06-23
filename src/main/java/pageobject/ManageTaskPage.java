package pageobject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import src.core.driver.AndroidDriverAction;

public class ManageTaskPage extends AndroidDriverAction {

    By title = By.id("com.todoist:id/text");
    By menuBtn = By.xpath("//android.widget.ImageButton[@content-desc=\"Menu\"]");
    String projectNameString = "//android.widget.TextView[@text='%s']";
    public ManageTaskPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }
    public void selectMenu() {
        clickElement(menuBtn);
        wait(5000);
    }
    public void selectProject(String projectTitle){
        String projectName = String.format(projectNameString, projectTitle);
        clickElement(By.xpath(projectName));
    }
    public void openProject(String projectTitle){
        selectMenu();
        selectProject(projectTitle);
    }
    public String getTitleTask() {
        String titleName = getText(title);
        return titleName;
    }
}
