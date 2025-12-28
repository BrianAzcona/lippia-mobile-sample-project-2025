package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.examples.services.LoginService;
import io.cucumber.java.en.Given;

public class LoginSteps extends PageSteps {

    @Given("^el usuario se loguea con el usuario (.*) y password (.*) exitosamente$")
    public void elUsuarioSeLogueaConElUsuarioYPasswordExitosamente(String p_User, String p_Pass) {
        LoginService.navPaginaLogin();
        LoginService.doLogin(p_User,p_Pass);
    }

}
