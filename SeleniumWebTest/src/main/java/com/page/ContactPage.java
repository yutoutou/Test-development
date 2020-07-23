package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class ContactPage extends BasePage{
    By addMember = By.linkText("添加成员");
    By username = By.name("username");
    By delete = By.cssSelector(".js_del_member");

    public ContactPage(RemoteWebDriver driver) {
        super(driver);
    }

    public ContactPage addMember(String username, String acctid, String mobile){
        //todo:
        while (driver.findElements(this.username).size()==0){
            click(addMember);
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        sendKeys(By.name("username"), username);
        sendKeys(By.name("acctid"), acctid);
        sendKeys(By.name("mobile"), mobile);

        click(By.cssSelector(".js_btn_save"));
        return this;
    }

    public ContactPage search(String keyword){
        sendKeys(By.id("memberSearchInput"), keyword);
        return this;
    }

    public ContactPage delete(){
        By confirm = By.xpath("//a[contains(text(),'确认')]");

        click(delete);

        click(confirm);
        click(By.id("clearMemberSearchInput"));
        return this;
    }
}
