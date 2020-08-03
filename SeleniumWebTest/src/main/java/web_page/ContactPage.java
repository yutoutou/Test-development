package web_page;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.net.URLDecoder;


public class ContactPage extends WebBasePage {
    By addMember = By.linkText("添加成员");
    By username = By.name("username");
    By delete = By.cssSelector(".js_del_member");

    public ContactPage(RemoteWebDriver driver) {
        super(driver);
    }

    public ContactPage addMember(String username, String acctid, String mobile){
        //todo:
        driver.navigate().refresh();
        click(By.linkText("组织架构"));
        while (driver.findElements(this.username).size()==0){
            click(addMember);
        }

        sendKeys(By.name("username"), username);
        sendKeys(By.name("acctid"), acctid);
        sendKeys(By.name("mobile"), mobile);

        click(By.cssSelector(".js_btn_save"));
        return this;
    }

    public ContactPage search(String keyword){
        sendKeys(By.xpath("//div[@class='member_colLeft_cntWrap']/div/span/input"), keyword);
        return this;
    }

    public String getUserName(){
        return driver.findElement(By.cssSelector(".member_display_cover_detail_name")).getText();
    }

    public ContactPage delete(){
        By confirm = By.xpath("//a[contains(text(),'确认')]");

        click(delete);
        click(confirm);
        //关闭/清除搜索内容
        click(By.xpath("//div[@class='member_colLeft_cntWrap']/div/span/span[2]"));

        return this;
    }

    public ContactPage importFromFile(URL path){
        //todo

        String path_utf = "";

        try{
            path_utf = URLDecoder.decode(path.getPath(), "UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(path_utf);

        click(By.xpath("//div[@class='ww_operationBar']/div[2]/a/div[1]"));
        click(By.linkText("文件导入"));
        upload(By.name("file"), path_utf);
        click(By.id("submit_csv"));
        click(By.id("reloadContact"));
        return this;
    }

    public ContactPage addDepartment(String department){
        //点击+号
        click(By.cssSelector(".member_colLeft_top_addBtn"));
        //点击添加部门
        click(By.cssSelector(".js_create_party"));
        sendKeys(By.name("name"), department);
        //点击所属部门选择框
        click(By.xpath("//span[contains(text(), '选择所属部门')]"));
        //选中部门
        click(By.xpath("(//a[contains(text(),'玉彤科技有限公司')])[2]"));
        click(By.linkText("确定"));
        return this;
    }

    public String getDepartmentName(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElement(By.xpath("//*[contains(@class, 'jstree-clicked')]")).getText();
    }

    public ContactPage deleteDepartment(String department){
        //先选中部门
        click(By.linkText(department));
        //点击选中部门的右边标签栏
        click(By.xpath("//*[contains(@class, 'clicked')]/span"));
        click(By.xpath("(//a[contains(text(),'删除')])[3]"));
        click(By.linkText("确定"));

        return this;
    }

    public ContactPage addTag(String tagName){
        driver.navigate().refresh();
        //先判断是否有标签栏
        if (driver.findElements(By.xpath("//*[@class='ww_btnGroup']/li[2]")).size() > 0){
            //有标签栏，则点击标签栏，再点击+号添加标签
            click(By.xpath("//*[@class='ww_btnGroup']/li[2]"));
            while (driver.findElements(By.name("name")).size() == 0){
                click(By.cssSelector(".member_colLeft_top_addBtn"));
            }
            sendKeys(By.name("name"), tagName);
            click(By.cssSelector(".js_share_range_name"));
            click(By.linkText("所有管理员"));
            click(By.linkText("确定"));
        }else{
            //没有标签栏，则点击+号，再点击添加标签
            click(By.cssSelector(".member_colLeft_top_addBtn"));
            click(By.cssSelector(".js_create_tag"));
            sendKeys(By.name("name"), tagName);
            click(By.cssSelector(".js_share_range_name"));
            click(By.linkText("所有管理员"));
            click(By.linkText("确定"));
        }
        return this;
    }

    public String getTagName(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElement(By.xpath("//li[contains(@class, 'member_tag_list_item_Active')]")).getText();
    }

    public ContactPage deleteTag(String tagName){
        click(By.xpath("//*[@class='ww_btnGroup']/li[2]"));
        click(By.xpath(String.format("//*[contains(text(), '%s')]",tagName)));
        click(By.xpath("//*[contains(@class, 'member_tag_list_item_Active')]/a"));
        click(By.xpath("//a[contains(text(), '删除')]"));
        click(By.linkText("确定"));
        return this;
    }

}
