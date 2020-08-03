package test_framework;

import app_page.AppBasePage;
import web_page.WebBasePage;

public class UIAutoFactory {
    public static BasePage create(String driverName){
        if (driverName.equals("web") || driverName.equals("selenium")){
            return new WebBasePage();
        }

        if (driverName.equals("app") || driverName.equals("appium")){
            return new AppBasePage();
        }

        if (driverName.equals("uiautomator")){
            //
        }

        if (driverName.equals("atx")){
            //
        }

        if (driverName.equals("macaca")){
            //
        }

        return null;
    }
}
