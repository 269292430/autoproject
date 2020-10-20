package common.findelements;

import common.seleniumdriver.SeleniumDriver;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FindElements extends SeleniumDriver {

    public static WebElement findElement(final By by){
        WebElement webElement=null;

        try{
            webElement = new WebDriverWait(driver,30).until(new ExpectedCondition<WebElement>() {
                @NullableDecl
                @Override
                public WebElement apply(@NullableDecl WebDriver webDriver) {
                    return driver.findElement(by);
                }
            });

        }catch (Exception e){
            System.out.println("元素"+by+"没有找到");
            e.printStackTrace();
        }

        return webElement;
    }


    public static List<WebElement> findElements(final By by){
        List<WebElement>  webElements =null;

        try{
            webElements = new WebDriverWait(driver,10).until(new ExpectedCondition<List<WebElement>>() {
                @NullableDecl
                @Override
                public List<WebElement> apply(@NullableDecl WebDriver webDriver) {
                    return driver.findElements(by);
                }
            });

        }catch (Exception e){
            System.out.println("元素"+by+"定位超时");
            e.printStackTrace();
        }
        return webElements;
    }






}
