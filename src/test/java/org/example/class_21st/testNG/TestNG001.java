package org.example.class_21st.testNG;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG001 {

    @Description("verify true equal to true")
    @Test
    public  void test_case_001(){

        Assert.assertEquals(true,true);

    }

    @Description("verify true equal to false")
    @Test
    public  void test_case_002(){

        Assert.assertEquals(true,false);

    }
}
