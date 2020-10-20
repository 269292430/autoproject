package common.seleniumdriver;

import common.logger.LoggerControler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static common.logger.LoggerControler.getLogger;


public class SeleniumDriver {

    public static WebDriver driver;
    final static LoggerControler log= getLogger(SeleniumDriver.class);

    public static WebDriver openBrower(String browser){
        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","D:\\bst\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            log.info("你打开了"+browser+"浏览器");
        }else if(browser.equals("firefox")){
//            System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
//            driver=new FirefoxDriver();

            //不是默认安装且在48以下版本，就需要设置相应的exe安装路径，不需要驱动
//        System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
            DesiredCapabilities d = new DesiredCapabilities();
            d.setCapability("marionette", false);  // to disable marionette.
            driver = new FirefoxDriver(d);
            log.info("你打开了"+browser+"浏览器");
        }else {
            log.severe("你输入的"+browser+"浏览器不支持打开");
        }

        return  driver;
    }

    public static void closeCurrentBrower(){
        driver.close();
    }

    public static void closeAllBrower(){
        driver.quit();
    }


}
