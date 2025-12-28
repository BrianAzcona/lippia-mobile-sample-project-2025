package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.CompraConstants;
import junit.framework.Assert;

public class CompraService extends MobileActionManager {
    public static void clickPasarPorCaja(){
        waitPresence(CompraConstants.BUTTON_PROCEED_TO_CHECKOUT_ACCESSIBILITY_ID).isDisplayed();
        click(CompraConstants.BUTTON_PROCEED_TO_CHECKOUT_ACCESSIBILITY_ID);
    }
    public static void completarCampoNombre(String p_nombre){
        setInput(CompraConstants.INPUT_FULL_NAME_ID, p_nombre);
    }
    public static void completarCampoDireccion1(String p_direccion1){
        setInput(CompraConstants.INPUT_ADDRESS_LINE_1_ID, p_direccion1);
    }
    public static void completarCampoDireccion2(String p_direccion2){
        setInput(CompraConstants.INPUT_ADDRESS_LINE_2_ID, p_direccion2);
    }
    public static void completarCampoCiudad(String p_ciudad){
        setInput(CompraConstants.INPUT_CITY_ID,p_ciudad);
    }
    public static void completarCampoEstado(String p_estado){
        setInput(CompraConstants.INPUT_STATE_ID,p_estado);
    }
    public static void completarCampoCodPostal(String p_codigoPostal){
        setInput(CompraConstants.INPUT_ZIP_CODE_ID,p_codigoPostal);
    }
    public static void completarCampoPais(String p_pais){
        setInput(CompraConstants.INPUT_COUNTRY_ID, p_pais);
    }
    public static void clickBotonToPayment(){
        GenericService.scrollAndroid("accessibility", CompraConstants.BUTTON_TO_PAYMENT_ACCESSIBILITY_ID);
        waitPresence(CompraConstants.BUTTON_TO_PAYMENT_ACCESSIBILITY_ID).isDisplayed();
        click(CompraConstants.BUTTON_TO_PAYMENT_ACCESSIBILITY_ID);
    }
    public static void verificarPagMetodoPago(){
        Assert.assertTrue("El usuario no visualiza los metodos de pago", waitPresence(CompraConstants.TITLE_METHOD_PAYMENT_ID).isDisplayed());
    }

    public static void completarCampoNombreTarjeta(String p_nombre){

        setInput(CompraConstants.INPUT_FULL_NAME_CARD_ID, p_nombre);
    }

    public static void completarCampoNumTarjeta(String p_Num_Tarjeta){
        setInput(CompraConstants.INPUT_CARD_NUMBER_ID, p_Num_Tarjeta);
    }
    public static void completarCampoFechaVencimiento(String p_Fecha_Vencimiento){
        setInput(CompraConstants.INPUT_EXPIRATION_DATE_ID, p_Fecha_Vencimiento);
    }
    public static void completarCampoCodSeguridad(String p_Cod_Seguridad){
        setInput(CompraConstants.INPUT_SEGURITY_CODE_ID, p_Cod_Seguridad);
    }

    public static void clickRevisarOrden(){
        waitPresence(CompraConstants.BUTTON_REVIEW_ORDER_ACCESSIBILITY_ID).isDisplayed();
        click(CompraConstants.BUTTON_REVIEW_ORDER_ACCESSIBILITY_ID);
    }

    public static void verificarTituloRevisarOrden(){
        Assert.assertTrue("No se visualiza la orden", waitPresence(CompraConstants.TITLE_REVIEW_ORDER_ID).isDisplayed());
    }

    public static void clickRealizarPedido(){
        waitPresence(CompraConstants.BUTTON_PLACE_ORDER_ACCESSIBILITY_ID).isDisplayed();
        click(CompraConstants.BUTTON_PLACE_ORDER_ACCESSIBILITY_ID);
    }

    public static void verificarCompraCompletada(String p_msj){
        waitVisibility(CompraConstants.TITLE_CHECKOUT_COMPLETE_ID);
        Assert.assertEquals("No se completo la compra", p_msj, getElement(CompraConstants.TITLE_CHECKOUT_COMPLETE_ID).getText());
    }
    public static void clickContinuarCalificacion(){
        click(CompraConstants.BUTTON_CONTINUE_DIALOG_ACCESSIBILITY_ID);
    }
    public static void verificarMensajeCalificacion(String p_msj){
        waitVisibility(CompraConstants.MESSAGE_DIALOG_ID);
        Assert.assertEquals("El mensaje despues de la calificacion no es el esperado", p_msj, getElement(CompraConstants.MESSAGE_DIALOG_ID).getText());
    }

    public static void calificarProducto(String p_cantEstrellas){
        String cantEstrellasLocator = String.format(CompraConstants.STAR_RATING_ID, p_cantEstrellas);
        click(cantEstrellasLocator);

    }

}
