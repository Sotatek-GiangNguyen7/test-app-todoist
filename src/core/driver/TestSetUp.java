package src.core.driver;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestSetUp {
    public AndroidDriver<MobileElement> driver;
    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "emulator_5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("appPackage", "com.todoist");
        caps.setCapability("appActivity", "com.todoist.activity.HomeActivity");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void closeTabs() throws AWTException {
        driver.quit();
    }
}
