package pageobject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import src.core.driver.AndroidDriverAction;

public class CreateTaskPage extends AndroidDriverAction {
    public CreateTaskPage(AndroidDriver<MobileElement> driver){
        super(driver);
    }

    By createTaskBtn   = By.id("com.todoist:id/fab");
    By title   = By.id("android:id/message");
    By description   = By.xpath("//com.todoist:id/description[@text()='Description']");
    By saveBtn   = By.xpath("//android.widget.ImageView[@content-desc=\"Add\"]");
    By checkMark = By.xpath("(//android.widget.CheckBox[@content-desc=\"Complete\"])[3]");

    public void addTask(){
        clickElement(createTaskBtn);
    }
    public void inputTitle(String key){
        sendKey(title,key);
    }
    public void inputDescription(String key){
        sendKey(description, key);
    }
    public void saveTask(){
        clickElement(saveBtn);
    }
    public void backHome(){
        tapAction(542,232);
    }
    public void checkMark(){
        clickElement(checkMark);
        wait(2000);
    }

    public void createTask(String title, String des){
        addTask();
        inputTitle(title);
        wait(2000);
        saveTask();
        backHome();
        wait(2000);
    }
}
