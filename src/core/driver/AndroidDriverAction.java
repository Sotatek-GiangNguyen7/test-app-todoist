package src.core.driver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class AndroidDriverAction {
    public AndroidDriver<MobileElement> driver;

    public AndroidDriverAction(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }


    public String getText(By locator) {
        String var = findElement(locator).getText();
        return var;
    }

    public MobileElement findElement(By locator) {
        MobileElement e = driver.findElement(locator);
        return e;
    }

    public void sendKey(By locator, String key) {
        findElement(locator).sendKeys(key);
    }

    public void clickElement(By locator) {
        findElement(locator).click();
    }

    public void tapAction(int x, int y) {
        TouchAction action = new TouchAction(driver);
        action.tap(PointOption.point(x, y));
        action.perform();
    }

    public void wait(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void nagativeBack(){
        driver.navigate().back();
    }
}
