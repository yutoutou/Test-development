package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BasePage {
//    AndroidDriver<MobileElement> driver;
    //如果做游戏测试
    AppiumDriver<MobileElement> driver;
    //做安卓测试，也可以用
    //AndroidDriver<AndroidElement> driver;
    WebDriverWait wait;

    public BasePage(AppiumDriver<MobileElement> driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public BasePage(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("appPackage", "com.xueqiu.android");
        caps.setCapability("appActivity", ".view.WelcomeActivityAlias");
        //设置是否弹框
        caps.setCapability("noReset", "true");

        try {
            driver = new AppiumDriver(new URL("http://localhost:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    public void quit(){
        driver.quit();
    }

    public void click(By by){
        //todo:异常处理
        find(by).click();
    }

    public void sendKeys(By by, String content){
        find(by).sendKeys(content);
    }

    public MobileElement find(By by){
        return driver.findElement(by);
    }

    //todo:
    public void waitElement(){

    }
}
