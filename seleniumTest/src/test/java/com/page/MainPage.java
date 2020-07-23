package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public class MainPage {
    public static WebDriver driver;

    public MainPage(){
        driver = new ChromeDriver();
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        try {
            FileReader fileReader = new FileReader("cookie.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line=bufferedReader.readLine()) != null){
                StringTokenizer tokenizer = new StringTokenizer(line, ";");
                String name = tokenizer.nextToken();
                String domain = tokenizer.nextToken();

                Date expiry = null;
                String dt = tokenizer.nextToken();
                if (!dt.equals("null")){
                    //把String转换成date
                    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                    sdf.parse(dt);
                }
                String path = tokenizer.nextToken();
                String value = tokenizer.nextToken();
                //把String 转换成boolean
                boolean isSecure = Boolean.parseBoolean(tokenizer.nextToken());

                Cookie cookie = new Cookie(name, value, domain, path, expiry, isSecure);
                driver.manage().addCookie(cookie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //把cookie传给url
        driver.get("https://work.weixin.qq.com/wework_admin/frame");

    }


    public ContactPage toContact(){
        //todo:
        driver.findElement(By.cssSelector("#menu_contacts")).click();
        return new ContactPage();
    }

    public void tearDown(){
        driver.quit();
    }
}
