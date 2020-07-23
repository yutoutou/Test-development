package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class ContactPage {
    By addMember = By.linkText("添加成员");
    By username = By.name("username");
    By delete = By.cssSelector(".js_del_member");

    public ContactPage addMember(String username, String acctid, String mobile){
        //todo:
//        new WebDriverWait(MainPage.driver, 10).until(ExpectedConditions.visibilityOfElementLocated(addMember));
//        new WebDriverWait(MainPage.driver, 10).until(ExpectedConditions.elementToBeClickable(addMember));

        while (MainPage.driver.findElements(this.username).size()==0){
            MainPage.driver.findElement(addMember).click();
        }

        MainPage.driver.findElement(By.name("username")).sendKeys(username);
        MainPage.driver.findElement(By.name("acctid")).sendKeys(acctid);
        MainPage.driver.findElement(By.name("mobile")).sendKeys(mobile);
        MainPage.driver.findElement(By.cssSelector(".js_btn_save")).click();
        return this;
    }

    public ContactPage search(String keyword){
        MainPage.driver.findElement(By.id("memberSearchInput")).sendKeys(keyword);
        return this;
    }

    public ContactPage delete(){
        By confirm = By.xpath("//a[contains(text(),'确认')]");

        //显示等待元素出现
        new WebDriverWait(MainPage.driver, Duration.ofSeconds(10).getSeconds()).until(ExpectedConditions.elementToBeClickable(delete));
        MainPage.driver.findElement(delete).click();


        //也可以使用该方法，判断删除的确认按钮是否存在。如果不存在，则一直点击"删除"按钮
//        while (MainPage.driver.findElements(confirm).size() == 0){
//            MainPage.driver.findElement(delete).click();
//        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        MainPage.driver.findElement(confirm).click();
        MainPage.driver.findElement(By.id("clearMemberSearchInput")).click();
        return this;
    }
}
