package common.tools;

import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ExcelUtilTest {
    static  String   filePath = System.getProperties().getProperty("user.dir")+"/data";

    @Test
    public void  readExcl(){
        ArrayList<ArrayList<Row>>   arrayLists = ExcelUtil.readExcels(filePath+"/test.xls");
        for(int i=0;i<arrayLists.size();i++) {
            for (int j = 0; j < arrayLists.get(i).size(); j++) {
                System.out.println(arrayLists.get(i).get(j));
            }
        }
    }





}
