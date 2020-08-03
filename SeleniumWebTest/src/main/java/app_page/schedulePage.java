package app_page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class schedulePage extends AppBasePage {
    private final By taskName = By.id("b7f");
    private final By addName = By.id("hi2");
    private final By saveName = byText("保存");
    private final By taskList = By.id("gzy");

    public schedulePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public schedulePage add(String name, String time){
        waitElement(addName);
        click(addName);
        sendKeys(taskName, name);
        click(saveName);
        return this;
    }

    public List<String> getSchedule(String day){
        if (day!=null){
            //todo:选择日期
        }
        return driver.findElements(taskList).stream().map(x->x.getText()).collect(Collectors.toList());
    }
}
