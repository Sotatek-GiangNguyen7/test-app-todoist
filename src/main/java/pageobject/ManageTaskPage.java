package pageobject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import src.core.driver.AndroidDriverAction;

public class ManageTaskPage extends AndroidDriverAction {

    By title = By.id("com.todoist:id/text");
    By projectName = By.xpath("(//*[@resource-id='com.todoist:id/name'])[last()]");
    By checkMark = By.xpath("(//android.widget.CheckBox[@content-desc=\"Complete\"])[last()]");
    public ManageTaskPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public void selectProject(){
        clickElement(projectName);
    }

    public void clickCompleteTask() {
        clickElement(checkMark);
        wait(2000);
    }

    public String getTitleTask() {
        String titleName = getText(title);
        return titleName;
    }
}
