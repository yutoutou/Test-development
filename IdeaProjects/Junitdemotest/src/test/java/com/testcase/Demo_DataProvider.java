package com.testcase;

//import org.junit.Test;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class Demo_DataProvider {

    @DataProvider(name = "putInList")
    public Object[][] putInList(){
        Object[][] object;
        return object = new Object[][]{
                {"包裹1", 1, 0, 1, 1, 1,},
                {"包裹2", 0, 1, 1, 1, 0,},
                {"包裹3", 1, 1, 1, 1, 1,},
        };
    }

    @Test(dataProvider = "putInList")
    public void putInA(String pakageName, int aNum, int bNum, int cNum, int dNum, int eNum) throws Exception{
        System.out.println("忧伤哥 操作" + pakageName + " 装入坚果A " + aNum + " 个！\n");
        Thread.sleep(1000);
        System.out.println("炫酷哥 操作" + pakageName + " 装入坚果B " + bNum + " 个！\n");
        Thread.sleep(1000);
        System.out.println("羞涩哥 操作" + pakageName + " 装入坚果B " + cNum + " 个！\n");
        Thread.sleep(1000);
        System.out.println("暴怒哥 操作" + pakageName + " 装入坚果B " + dNum + " 个！\n");
        Thread.sleep(1000);
        System.out.println("傻笑哥 操作" + pakageName + " 装入坚果B " + eNum + " 个！\n");
        Thread.sleep(1000);
    }
}
