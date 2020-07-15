package com.testcase;

import org.testng.annotations.Test;

public class demo_Groups {
    @Test(groups = {"group01"})
    public void putInA(){
        System.out.println("装入坚果A\n");
    }

    @Test(groups = {"group02"})
    public void putInB(){
        System.out.println("装入坚果B\n");
    }

    @Test(groups = {"group01", "group02"})
    public void putInC(){
        System.out.println("装入坚果C\n");
    }

    @Test(groups = {"group02"})
    public void putInD(){
        System.out.println("装入坚果D\n");
    }

    @Test(groups = {"group02"})
    public void putInE(){
        System.out.println("装入坚果E\n");
    }
}
