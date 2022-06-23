package pageobject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import src.core.driver.AndroidDriverAction;

public class ManageProjectPage extends AndroidDriverAction {
    public ManageProjectPage(AndroidDriver<MobileElement> driver){
        super(driver);
    }

    By menuBtn   = By.xpath("//android.widget.ImageButton[@content-desc=\"Menu\"]");
    By manageProjectsElm   = By.xpath("//android.widget.TextView[@text='Manage projects']");
    By getText   = By.xpath("//android.widget.TextView[@text='Shopping list']");


    public void selectMenu(){
        clickElement(menuBtn);
        wait(5000);
    }

    public void clickManageProject(){
        clickElement(manageProjectsElm);
    }

    public String getProjectName(){
        return getText(getText);
    }

}
