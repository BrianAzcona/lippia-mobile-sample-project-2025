package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;

import com.crowdar.core.PropertyManager;
import com.crowdar.examples.services.CompraService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CompraSteps extends PageSteps {


    @When("el usuario hace click en Proceed To Checkout")
    public void elUsuarioHaceClickEnProceedToCheckout() {
        CompraService.clickPasarPorCaja();
    }

    @And("^el usuario rellena los campos Full Name (.*), Address Line 1 (.*), Address Line 2 (.*), City (.*), State (.*), ZipCode (.*) y Country (.*)$")
    public void elUsuarioRellenaLosCamposFullNameY(String p_nombre, String p_direccion1, String p_direccion2, String p_ciudad, String p_estado, String p_codigoPostal, String p_pais) {
        CompraService.completarCampoNombre(p_nombre);
        CompraService.completarCampoDireccion1(p_direccion1);
        CompraService.completarCampoDireccion2(p_direccion2);
        CompraService.completarCampoCiudad(p_ciudad);
        CompraService.completarCampoEstado(p_estado);
        CompraService.completarCampoCodPostal(p_codigoPostal);
        CompraService.completarCampoPais(p_pais);
    }

    @And("el usuario hace click en en To Payment")
    public void elUsuarioHaceClickEnEnToPayment() {
        CompraService.clickBotonToPayment();
    }

    @Then("el usuario visualiza la pasarela de pago")
    public void elUsuarioVisualizaLaPasarelaDePago() {
        CompraService.verificarPagMetodoPago();
    }

    @When("^el usuario completa los campos Full Name, Card Number, Expiration Date y Segurity Code$")
    public void elUsuarioCompletaLosCamposFullNameFullNameCardNumberCardNumberExpirationDateExpirationDateYSegurityCodeSegurityCode() {
        CompraService.completarCampoNombreTarjeta(PropertyManager.getProperty("card.name"));
        CompraService.completarCampoNumTarjeta(PropertyManager.getProperty("card.number"));
        CompraService.completarCampoFechaVencimiento(PropertyManager.getProperty("card.expiration"));
        CompraService.completarCampoCodSeguridad(PropertyManager.getProperty("card.security.code"));
    }

    @And("el usuario hace clic en Review Order")
    public void elUsuarioHaceClicEnReviewOrder() {
        CompraService.clickRevisarOrden();
    }

    @Then("el usuario visualiza su orden")
    public void elUsuarioVisualizaSuOrden() {
        CompraService.verificarTituloRevisarOrden();
    }

    @When("el usuario hace click en Place Order")
    public void elUsuarioHaceClickEnPlaceOrder() {
        CompraService.clickRealizarPedido();
    }

    @Then("^el usuario visualiza el mensaje (.*)$")
    public void elUsuarioVisualizaElMensaje(String p_msj) {
        CompraService.verificarCompraCompletada(p_msj);
    }
}
