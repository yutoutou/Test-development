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

public class MainPage extends BasePage{

//    public MainPage(AndroidDriver<MobileElement> driver) {
//        super(driver);
//    }

    //搜索
    public SearchPage toSearch(){
        click(By.id("com.xueqiu.android:id/home_search"));
        return new SearchPage(driver);
    }

    //行情
    public void toStock(){

    }
}
