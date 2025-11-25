@Carrito
  Feature: Agregar y eliminar productos del carrito
    Background:
      Given el usuario se loguea con el usuario bod@example y password 10203040 exitosamente
      And el usuario se encuentra en la pagina de Products
      
    @AgregarProducto
    Scenario: Agregar un producto al carrito
      And el usuario hace click en la imagen del producto Sauce Labs Backpack (violet)
      And el usuario visualiza la pagina del producto Sauce Labs Backpack (violet)
      When el usuario hace click en Add to cart
      Then el usuario visualiza en el carrito el numero 1
      
    @EliminarProducto
    Scenario: Eliminar un producto del carrito
      And el usuario hace click en la imagen del producto Sauce Labs Backpack (violet)
      And el usuario visualiza la pagina del producto Sauce Labs Backpack (violet)
      And el usuario hace click en Add to cart
      And el usuario visualiza en el carrito el numero 1
      When el usuario hace click en el carrito
      And el usuario visualiza My Cart al ingresar al carrito
      And el usuario elimina el producto del carrito
      Then el usuario visualiza el carrito vacio con el mensaje No Items