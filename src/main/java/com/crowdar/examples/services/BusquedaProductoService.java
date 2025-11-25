package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.BusquedaProductoConstants;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;

public class BusquedaProductoService extends MobileActionManager {

    public static void verificarPagInventario(){
        Assert.assertTrue("No se visualiza el titulo de la pagina de productos", waitPresence(BusquedaProductoConstants.TITLE_INVENTORY_ID).isDisplayed());
    }

    public static void clickProducto(String p_Producto){
        GenericService.scrollAndroid("text", p_Producto);
        String imagen = String.format(BusquedaProductoConstants.IMG_PRODUCT_XPATH, p_Producto);
        click(imagen);

    }

    public static void verificarTituloProducto(String p_producto){
        String xpath = String.format(BusquedaProductoConstants.TITLE_PRODUCT_XPATH, p_producto);
        Assert.assertTrue("No se visualiza la pagina del producto", waitPresence(xpath).isDisplayed());

    }

}
