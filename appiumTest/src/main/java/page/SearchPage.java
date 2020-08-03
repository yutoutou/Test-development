package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchPage extends BasePage{
    private By nameLocator = By.id("name");

    public SearchPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public SearchPage search(String keyword){
        sendKeys(By.id("com.xueqiu.android:id/search_input_text"), keyword);
        return this;
    }

    public List<String> getSearchList(){
        List<String> nameList = new ArrayList<>();
//        System.out.println(driver.findElements(nameLocator));
//        for (Object element: driver.findElements(nameLocator)){
//            nameList.add(((WebElement) element).getText());
//        }
        //todo: stream lamda优化
        driver.findElements(nameLocator).forEach(mobileElement -> nameList.add(mobileElement.getText()));
        return nameList;
    }

    public Double getPrice(){
        //todo:独立一个独立的po方法
        click(nameLocator);
        Double price = Double.valueOf(find(By.id("current_price")).getText());
        return price;
    }
}
//如果有自选股票，先全部删除
//搜索添加阿里巴巴股票，然后添加，再判断
//首页 行情 删除所有股票
//添加三只股票
//以PO模式实现