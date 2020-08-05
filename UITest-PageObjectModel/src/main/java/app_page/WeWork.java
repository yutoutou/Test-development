package app_page;

import org.openqa.selenium.By;

public class WeWork extends AppBasePage {
    public WeWork() {
        super("com.tencent.wework", ".launch.LaunchSplashActivity");
    }

    public schedulePage schedule(){
        click(By.xpath("//*[@text='日程']"));
        return new schedulePage(driver);
    }
}
