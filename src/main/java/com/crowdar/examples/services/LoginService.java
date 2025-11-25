package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.LoginConstants;



public class LoginService extends MobileActionManager{

    public static void doLogin(String p_user, String p_pass){
        setInput(LoginConstants.USER_INPUT_LOCATOR, p_user);
        setInput(LoginConstants.PASSWORD_INPUT_LOCATOR, p_pass);
        click(LoginConstants.BUTTON_LOGIN_LOCATOR);
    }

    public static void navPaginaLogin(){
        click(LoginConstants.BUTTON_BURGER_MENU_LOCATOR);
        click(LoginConstants.BUTTON_LOGIN_MENU_LOCATOR);
    }


}
