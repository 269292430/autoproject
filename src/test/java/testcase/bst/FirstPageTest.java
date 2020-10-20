package testcase.bst;

import common.seleniumdriver.SeleniumDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.FirstPageService;

public class FirstPageTest {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
//      driver = SeleniumDriver.openBrower("chrome");
        driver = SeleniumDriver.openBrower("firefox");
    }

    @AfterMethod
    public void closeBrowser(){
        SeleniumDriver.closeAllBrower();
    }


    @DataProvider(name="loginUser")
    public Object[][] loginUserPwd(){
        return new Object[][]{{"18589063868","123456"},{"18938631171","123456"}};
    }

    @Test(dataProvider = "loginUser")
    public void loginTest(String user,String pwd) {
        driver.get("http://test.biaoshitong.com:8001/index");
        FirstPageService.login(user,pwd);
    }


}
