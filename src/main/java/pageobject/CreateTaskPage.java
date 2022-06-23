package pageobject;

import dto.TaskObject;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import src.core.driver.AndroidDriverAction;

public class CreateTaskPage extends AndroidDriverAction {
    By menuBtn = By.xpath("//android.widget.ImageButton[@content-desc=\"Menu\"]");
    By createTaskBtn = By.id("com.todoist:id/fab");
    By title = By.id("android:id/message");
    By description = By.xpath("//com.todoist:id/description[@text()='Description']");
    By saveBtn = By.xpath("//android.widget.ImageView[@content-desc=\"Add\"]");
    By checkMark = By.xpath("//android.widget.CheckBox[@content-desc=\"Complete\"]");
    String projectNameString = "//android.widget.TextView[@text='%s']";
    public CreateTaskPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }
    public void selectMenu() {
        clickElement(menuBtn);
        wait(5000);
    }
    public void selectProject(String projectTitle){
        String projectName = String.format(projectNameString, projectTitle);
        clickElement(By.xpath(projectName));
    }
    public void addTask() {
        clickElement(createTaskBtn);
    }

    public void inputTitle(String key) {
        sendKey(title, key);
    }

    public void inputDescription(String key) {
        sendKey(description, key);
    }

    public void saveTask() {
        clickElement(saveBtn);
    }

    public void backHome() {
        nagativeBack();
    }

    public void clickCompleteTask() {
        clickElement(checkMark);
        wait(2000);
    }
    public void createTask(String title, String des, String projectTitle) {
        selectMenu();
        selectProject(projectTitle);
        addTask();
        inputTitle(title);
        wait(2000);
        saveTask();
        backHome();
        wait(2000);
    }

    public TaskObject getInputDataUI() {
        TaskObject task = new TaskObject();
        task.content = getText(title);
        return task;
    }

    public String getTitleTask() {
        return getText(title);
    }
}
