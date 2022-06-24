package pageobject.common;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import src.core.driver.AndroidDriverAction;

public class LoginPage extends AndroidDriverAction {

    By btnSignIn = By.id("com.todoist:id/btn_google");
    By signInMail = By.id("com.google.android.gms:id/container");

    public LoginPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public void signInWithGoogle() {
        clickElement(btnSignIn);
    }

    public void chooseAccount() {
        clickElement(signInMail);
        wait(5000);
    }

    public void login() {
        signInWithGoogle();
        chooseAccount();
    }
}
