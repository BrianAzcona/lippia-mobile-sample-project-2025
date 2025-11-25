package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;

import com.crowdar.examples.services.BusquedaProductoService;
import com.crowdar.examples.services.LoginService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BusquedaProductoSteps extends PageSteps {


    @Given("^el usuario se loguea con el usuario (.*) y password (.*) exitosamente$")
    public void elUsuarioSeLogueaConElUsuarioYPasswordExitosamente(String p_User, String p_Pass) {
        LoginService.navPaginaLogin();
        LoginService.doLogin(p_User,p_Pass);
    }

    @When("^el usuario hace click en la imagen del producto (.*)$")
    public void elUsuarioHaceClickEnLaImagenDelProducto(String p_producto) {
        BusquedaProductoService.clickProducto(p_producto);
    }

    @Then("^el usuario visualiza la pagina del producto (.*)$")
    public void elUsuarioVisualizaLaPaginaDelProducto(String p_producto) {
        BusquedaProductoService.verificarTituloProducto(p_producto);

    }

    @And("el usuario se encuentra en la pagina de Products")
    public void elUsuarioSeEncuentraEnLaPaginaDeProducts() {
        BusquedaProductoService.verificarPagInventario();

    }
}
