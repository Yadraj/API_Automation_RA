package org.example.class_21st.testNG;

import org.testng.annotations.Test;

public class TestNG002 {


    @Test(groups = {"qa"})
    public void sanity(){
        System.out.println("sanity");
    }
    @Test(groups = {"dev"})
    public void regression(){
        System.out.println("sanity");
    }
    @Test(groups = {"stage"})
    public void smoke(){
        System.out.println("sanity");
    }
}
