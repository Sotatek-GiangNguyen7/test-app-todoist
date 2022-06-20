package pageobject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import src.core.driver.AndroidDriverAction;

public class ManageTaskPage extends AndroidDriverAction {

    public ManageTaskPage(AndroidDriver<MobileElement> driver){
        super(driver);
    }
    String titleString = "//android.widget.TextView[@text='%s']";

    public String getTitle(String key){
        String title = String.format(titleString, key);
        return getText(By.xpath(title));
    }
}
