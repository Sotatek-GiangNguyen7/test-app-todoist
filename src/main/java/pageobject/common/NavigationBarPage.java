package pageobject.common;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import src.core.driver.AndroidDriverAction;

public class NavigationBarPage extends AndroidDriverAction {

    public NavigationBarPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    By menuBtn = By.xpath("//android.widget.ImageButton[@content-desc=\"Menu\"]");
    By createTaskBtn = By.id("com.todoist:id/fab");


    public void clickMenu(){
        clickElement(menuBtn);
    }

    public void addTask() {
        clickElement(createTaskBtn);
    }
}
