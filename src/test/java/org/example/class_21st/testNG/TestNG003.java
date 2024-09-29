package org.example.class_21st.testNG;

import org.testng.annotations.Test;

public class TestNG003 {

    @Test
    public void test1(){
        System.out.println("test1");
    }
    @Test(dependsOnMethods = "test1")
    public void test2(){
        System.out.println("test2");
    }
}
