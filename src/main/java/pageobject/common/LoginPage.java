package pageobject.common;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import src.core.driver.AndroidDriverAction;

public class LoginPage extends AndroidDriverAction {

    By btnSignInWithGoogle = By.id("com.todoist:id/btn_google");
    By signInMail = By.id("com.google.android.gms:id/container");
    By btnSignInWithEmail = By.id("com.todoist:id/btn_welcome_email");
    By btnNoneOfTheAbove = By.id("com.google.android.gms:id/cancel");
    By emailField = By.id("com.todoist:id/email_exists_input");
    By btnSubmitEmail = By.id("com.todoist:id/btn_continue_with_email");
    By passWordField = By.id("com.todoist:id/log_in_password");
    By btnLogin = By.id("com.todoist:id/btn_log_in");

    public LoginPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public void signInWithGoogle() {
        clickElement(btnSignInWithGoogle);
    }

    public void chooseAccount() {
        clickElement(signInMail);
        wait(5000);
    }

    public void loginWithGoogle() {
        signInWithGoogle();
        chooseAccount();
    }

    public void clickSigInWithEmail(){
        clickElement(btnSignInWithEmail);
    }

    public void clickNoneOfTheAbove(){
        clickElement(btnNoneOfTheAbove);
    }

    public void inputEmail(String emailAddress){
        sendKey(emailField, emailAddress);
    }

    public void clickContinueWithEmail(){
        clickElement(btnSubmitEmail);
    }

    public void inputPassword(String password){
        sendKey(passWordField, password);
    }

    public void clickLoginBtn(){
        clickElement(btnLogin);
    }
    public void loginWithEmail(String emailAddress, String password){
        clickSigInWithEmail();
        clickNoneOfTheAbove();
        inputEmail(emailAddress);
        clickContinueWithEmail();
        inputPassword(password);
        clickLoginBtn();
        //Back to homepage
        nagativeBack();
        wait(2000);
        nagativeBack();
    }
}
