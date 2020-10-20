package common.seleniumdriver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SeleniumDriverTest {

    @Test
    public void openBrowerTest(){
       WebDriver driver =  SeleniumDriver.openBrower("chrome");
       driver.get("http://www.baidu.com");
       System.out.println("222");
    }

    @AfterMethod
    public void  closeAllBrower(){
        SeleniumDriver.closeAllBrower();
    }
}
