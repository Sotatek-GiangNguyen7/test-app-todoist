package pageobject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import src.core.driver.AndroidDriverAction;

public class ManageProjectPage extends AndroidDriverAction {
    By menuBtn = By.xpath("//android.widget.ImageButton[@content-desc=\"Menu\"]");
    By manageProjectsElm = By.xpath("//android.widget.TextView[@text='Manage projects']");
    By projectName  = By.xpath("(//*[@resource-id='com.todoist:id/name'])[last()]");

    public ManageProjectPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public void selectMenu() {
        clickElement(menuBtn);
        wait(5000);
    }

    public void clickManageProject() {
        clickElement(manageProjectsElm);
    }

    public String getLastestProjectName(){
        return getText(projectName);
    }

}
