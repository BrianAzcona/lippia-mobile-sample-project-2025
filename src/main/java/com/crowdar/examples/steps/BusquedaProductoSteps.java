package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;

import com.crowdar.examples.services.BusquedaProductoService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BusquedaProductoSteps extends PageSteps {

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
