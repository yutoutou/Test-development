package web_page;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test_framework.BasePage;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class WebBasePage extends BasePage{

    RemoteWebDriver driver;
    WebDriverWait wait;

    public WebBasePage(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }


    public WebBasePage(RemoteWebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void tearDown(){
        driver.quit();
    }

    public void click(By by){
        //todo: 异常处理
        wait.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    public void sendKeys(By by, String content){
        //todo: 异常处理
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        driver.findElement(by).sendKeys(content);
    }

    public void upload(By by, String path){
        //todo: 异常处理
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        driver.findElement(by).sendKeys(path);
    }

    @Override
    public void click(HashMap<String, Object> map) {
        super.click(map);
        String key = (String) map.keySet().toArray()[0];
        String value = (String) map.values().toArray()[0];

        System.out.println("The key is: " + map.keySet().toArray()[0]);
        System.out.println("The values is: " + map.values().toArray()[0]);

        By by = null;
        if (key.toLowerCase().equals("id")){
            by = By.id(value);
        }

        if (key.toLowerCase().equals("linkText".toLowerCase())){
            by = By.linkText(value);
        }
        if (key.toLowerCase().equals("partialLinkText".toLowerCase())){
            by = By.partialLinkText(value);
        }
        //如果报错可能会抛异常
        click(by);
    }

    @Override
    public void action(HashMap<String, Object> map) {
        super.action(map);
        String action = map.get("action").toString().toLowerCase();
        if (action.equals("get")){
            System.out.println(map.get("url").toString());
            driver.get(map.get("url").toString());
        }

        if (action.equals("mainpage.tosearch")){

        }
    }
}
