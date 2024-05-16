package SmokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDependencies {

    @Test(priority=2, dependsOnMethods = "doUserReg")
    public void doLogin() {
        System.out.println("Executing Login test");
    }

    @Test(priority=1)
    public void doUserReg(){
        System.out.println("Executing User Reg test");
        Assert.fail("User registration failed");
    }

    @Test(priority = 3)
    public void thirdTest() {
        System.out.println("Executing third test");
    }

    @Test(priority = 4)
    public void fourthTest() {
        System.out.println("Executing fourth test");
    }


}
