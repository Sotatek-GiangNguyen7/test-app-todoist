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
    By manageProjects   = By.id("com.todoist:id/section");
    By getText   = By.xpath("//android.widget.TextView[@text='Shopping list']");


    public void selectMenu(){
        clickElement(menuBtn);
        wait(5000);
    }

    public void manageProject(){
        tapAction(256,1276);
    }

    public String getProjectName(){
        return getText(getText);
    }

}
