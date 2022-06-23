package pageobject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import src.core.driver.AndroidDriverAction;

public class ManageTaskPage extends AndroidDriverAction {

    public ManageTaskPage(AndroidDriver<MobileElement> driver){
        super(driver);
    }

    By title   = By.id("android:id/message");

    public String getTitleTask(){
        return getText(title);
    }
}
