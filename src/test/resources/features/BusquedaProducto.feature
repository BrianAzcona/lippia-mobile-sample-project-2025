@BusquedaProducto
  Feature: Búsqueda de producto
    Background:
      Given el usuario se loguea con el usuario bod@example y password 10203040 exitosamente
      And el usuario se encuentra en la pagina de Products
      
      
    @BusquedaProductoExitoso
    Scenario: Búsqueda de un producto de forma exitosa
      When el usuario hace click en la imagen del producto Sauce Labs Backpack (violet)
      Then el usuario visualiza la pagina del producto Sauce Labs Backpack (violet)
    
    