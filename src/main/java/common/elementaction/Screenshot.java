package common.elementaction;

import common.findelements.FindElements;
import common.logger.LoggerControler;
import common.tools.MyFile;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.io.IOException;

public class Screenshot   extends FindElements {
    static final LoggerControler log = LoggerControler.getLogger(Screenshot.class);
    static String path = System.getProperties().getProperty("user.dir")+"/data/screenshot/";

    public static void  screenshots(){
        WebDriver augmentDriver= new Augmenter().augment(driver);
        File file = ((TakesScreenshot)augmentDriver).getScreenshotAs(OutputType.FILE);
        String myPath = path + String.valueOf(System.currentTimeMillis());
        System.out.println(myPath);
        MyFile.createFile(myPath);

        try{
            String times = String.valueOf(System.currentTimeMillis());
            FileUtils.copyFile(file,new File(myPath+"/"+times+".jpg"));
        }catch (IOException e){
            log.severe("截图失败");
            e.printStackTrace();
        }

    }


    /**
     * 判断文件夹，没有就新建
     */
//    public static void fileExists() {
//        String fileName = DateUtil.format(DateUtil.CHECK_LOG_FORMAT);
//        File file = new File(path + fileName);
//        if (!file.exists()) {
//            file.mkdirs();
//        }
//    }

}
