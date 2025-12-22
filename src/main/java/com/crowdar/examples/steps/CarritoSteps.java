package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.examples.services.CarritoService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CarritoSteps extends PageSteps {

    @When("el usuario hace click en Add to cart")
    public void elUsuarioHaceClickEnAddToCart() {
        CarritoService.agregarProducto();
    }

    @Then("^el usuario visualiza en el carrito el numero (.*)$")
    public void elUsuarioVisualizaEnElCarritoElNumero(String p_cantidad) {
        CarritoService.verificarCantCarrito(p_cantidad);
    }

    @When("el usuario hace click en el carrito")
    public void elUsuarioHaceClickEnElCarrito() {
        CarritoService.clickCarrito();
    }

    @And("^el usuario visualiza (.*) al ingresar al carrito$")
    public void elUsuarioVisualizaAlIngresarAlCarrito(String p_titulo) {
        CarritoService.verificarTituloCarrito(p_titulo);
    }



    @Then("^el usuario visualiza el carrito vacio con el mensaje (.*)$")
    public void elUsuarioVisualizaElCarritoVacioConElMensaje(String p_msj) {
        CarritoService.verificarCarritoVacio(p_msj);
    }

    @And("el usuario elimina el producto del carrito")
    public void elUsuarioEliminaElProductoDelCarrito() {
        CarritoService.eliminarProducto();
    }

    @And("el usuario regresa al inventario")
    public void elUsuarioRegresaAlInventario() {
        CarritoService.regresarCatalogo();
    }


    @When("^el usuario agrega (.*) items del producto haciendo clic en (.*)$")
    public void elUsuarioAgregaItemsDelProductoHaciendoClicEn(int p_cantItem, String p_operacion) {
        CarritoService.modificarCantItem(p_cantItem, p_operacion);
    }

    @Then("^se verifica de que se agregaron (.*) items del producto$")
    public void seVerificaDeQueSeAgregaronItemsDelProducto(int p_cantProductosAgregados) {
        CarritoService.verificarCantItem(p_cantProductosAgregados);
    }
}
