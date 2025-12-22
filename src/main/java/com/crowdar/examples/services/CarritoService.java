package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.driver.DriverManager;
import com.crowdar.examples.constants.CarritoConstants;
import io.cucumber.java.bs.A;
import junit.framework.Assert;

public class CarritoService extends MobileActionManager {

    public static void agregarProducto(){
        GenericService.scrollAndroid("accessibility", CarritoConstants.BUTTON_ADD_TO_CART_ACCESSIBILITY_ID);

        waitPresence(CarritoConstants.BUTTON_ADD_TO_CART_ACCESSIBILITY_ID).isDisplayed();
        click(CarritoConstants.BUTTON_ADD_TO_CART_ACCESSIBILITY_ID);



    }
    public static void verificarCantCarrito(String p_cantidad){
        waitPresence(CarritoConstants.CART_BADGE_ID).isDisplayed();
        Assert.assertEquals("La cantidad no es la esperada", p_cantidad, getElement(CarritoConstants.CART_BADGE_ID).getText());
    }

    public static void clickCarrito(){
        waitPresence(CarritoConstants.BUTTON_CART_ACCESSIBILITY_ID).isDisplayed();
        click(CarritoConstants.BUTTON_CART_ACCESSIBILITY_ID);
    }
    public static void verificarTituloCarrito(String p_titulo){
        waitPresence(CarritoConstants.TITLE_MY_CART_ID).isDisplayed();
        Assert.assertEquals("El titulo que se visualiza no es el esperado", p_titulo, getElement(CarritoConstants.TITLE_MY_CART_ID).getText());
    }
    public static void eliminarProducto(){
        waitPresence(CarritoConstants.BUTTON_REMOVE_ITEM_ACCESSIBILITY_ID).isDisplayed();
        click(CarritoConstants.BUTTON_REMOVE_ITEM_ACCESSIBILITY_ID);
    }
    public static void verificarCarritoVacio(String p_msj){
        waitPresence(CarritoConstants.TITLE_CART_EMPTY_ID).isDisplayed();
        Assert.assertEquals("El carrito no esta vacio", p_msj, getElement(CarritoConstants.TITLE_CART_EMPTY_ID).getText());
    }

    public static void regresionPag(){
        DriverManager.getDriverInstance().navigate().back();
    }

    public static void modificarCantItem(int p_cantItem,String p_operacion){
        switch (p_operacion){
            case "+":
                for (int i = 1; i <= p_cantItem; i++) {
                    click(CarritoConstants.BUTTON_INCREASE_ITEM_ACCESSIBILITY_ID);
                }

                break;
            case "-":
                for (int i = 1; i <= p_cantItem; i++) {
                    click(CarritoConstants.BUTTON_DECREASE_ITEM_ACCESSIBILITY_ID);
                }
                break;
            default:
                throw new IllegalArgumentException(
                        "Operacion no valida: " + p_operacion
                );
        }

    }

    public static void verificarCantItem(int p_cantProductosAgregados){
        int cantEsperada = p_cantProductosAgregados + 1;
        Assert.assertEquals("La cantidad no es la esperada",cantEsperada,Integer.parseInt(getElement(CarritoConstants.COUNTER_ITEM_ID).getText()));
    }


}
