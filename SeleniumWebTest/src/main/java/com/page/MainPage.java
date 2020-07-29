package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

public class MainPage extends BasePage{

    public MainPage(){
        super();
        driver.get("https://work.weixin.qq.com/wework_admin/frame");

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
//                System.out.println(cookie);
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
        click(By.cssSelector("#menu_contacts"));
        return new ContactPage(driver);
    }
}
