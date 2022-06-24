package pageobject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import src.core.driver.AndroidDriverAction;

public class MenuPage extends AndroidDriverAction {
    public MenuPage(AndroidDriver<MobileElement> driver){super(driver);}

    String projectNameString = "//android.widget.TextView[@text='%s']";

    public void selectProject(String projectTitle){
        String projectName = String.format(projectNameString, projectTitle);
        clickElement(By.xpath(projectName));
    }
}
