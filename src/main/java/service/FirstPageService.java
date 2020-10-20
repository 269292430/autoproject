package service;

import common.elementaction.ElementAction;
import page.bst.FirstPage;

public class FirstPageService {

    public static void  login(String user, String pwd) {
        ElementAction.click(FirstPage.loginLink);
        ElementAction.sendkey(FirstPage.userInput,user);
        ElementAction.sendkey(FirstPage.pwdInput,pwd);
        ElementAction.click(FirstPage.loginSubmit);
    }


}
