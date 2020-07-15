package com.testcase;

import org.testng.annotations.Test;

public class demo_enable {
    @Test
    public void putInA() throws Exception{
        System.out.println("装入坚果A\n");
    }

    @Test
    public void putInB() throws Exception{
        System.out.println("装入坚果B\n");
    }

    @Test(enabled=false)
    public void putInC() throws Exception{
        System.out.println("装入坚果C\n");
    }
}
