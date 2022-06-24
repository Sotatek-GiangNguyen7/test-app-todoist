package pageobject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import src.core.driver.AndroidDriverAction;

public class MenuPage extends AndroidDriverAction {
    public MenuPage(AndroidDriver<MobileElement> driver){super(driver);}

    By projectName = By.xpath("(//*[@resource-id='com.todoist:id/name'])[last()]");
    By manageProjectsElm = By.xpath("//android.widget.TextView[@text='Manage projects']");

    public void selectProject(){
        clickElement(projectName);
    }
    public void clickManageProject() {
        clickElement(manageProjectsElm);
    }

}
