package common.elementaction;

import common.findelements.FindElements;
import common.logger.LoggerControler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static common.logger.LoggerControler.getLogger;

public class ElementAction {
    final static LoggerControler log= getLogger(ElementAction.class);

    public static void click(By by){
        FindElements.findElement(by).click();
        log.info("点击"+by);
    }

    public static void sendkey(By by,String text){
        FindElements.findElement(by).clear();
        FindElements.findElement(by).sendKeys(text);
        log.info("在"+by+"输入"+text);
    }

    public static String getText(By by){
       String  text = FindElements.findElement(by).getText();
        log.info(text);
       return text;
    }

    public static ArrayList getTexts(By by){
        ArrayList arrayList = new ArrayList();
        List<WebElement>  webElement = FindElements.findElements(by);
        for (int i = 0; i < webElement.size(); i++) {
            String text = webElement.get(i).getText().trim();
            log.info(text);
            arrayList.add(text);
        }
        return arrayList;
    }

}
