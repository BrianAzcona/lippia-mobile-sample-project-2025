@CompraCompleta
Feature: Compra de Producto
  
  Background:
    Given el usuario se loguea con el usuario bod@example y password 10203040 exitosamente
    And el usuario se encuentra en la pagina de Products
  
  @CheckoutInformation
  Scenario Outline: Rellenar datos de compra
    And el usuario hace click en la imagen del producto Sauce Labs Backpack (violet)
    And el usuario visualiza la pagina del producto Sauce Labs Backpack (violet)
    And el usuario hace click en Add to cart
    And el usuario visualiza en el carrito el numero 1
    And el usuario hace click en el carrito
    And el usuario visualiza My Cart al ingresar al carrito
    When el usuario hace click en Proceed To Checkout
    And el usuario rellena los campos Full Name <Full Name>, Address Line 1 <Address Line 1>, Address Line 2 <Address Line 2>, City <City>, State <State>, ZipCode <Zip Code> y Country <Country>
    And el usuario hace click en en To Payment
    Then el usuario visualiza la pasarela de pago
    
    Examples:
      | Full Name      | Address Line 1 | Address Line 2 | City  | State    | Zip Code | Country        |
      | Rebecca Winter | Mandorley 112  | Entrace 1      | Truro | Cornwall | 89750    | Unuted Kingdom |
  
  @CompletarMetodoPago
  Scenario Outline: Completar la información para método de pago
    And el usuario hace click en la imagen del producto Sauce Labs Backpack (violet)
    And el usuario visualiza la pagina del producto Sauce Labs Backpack (violet)
    And el usuario hace click en Add to cart
    And el usuario visualiza en el carrito el numero 1
    And el usuario hace click en el carrito
    And el usuario visualiza My Cart al ingresar al carrito
    And el usuario hace click en Proceed To Checkout
    And el usuario rellena los campos Full Name <Full Name>, Address Line 1 <Address Line 1>, Address Line 2 <Address Line 2>, City <City>, State <State>, ZipCode <Zip Code> y Country <Country>
    And el usuario hace click en en To Payment
    And el usuario visualiza la pasarela de pago
    When el usuario completa los campos Full Name <Full Name>, Card Number <Card Number>, Expiration Date <Expiration Date> y Segurity Code <Segurity Code>
    And el usuario hace clic en Review Order
    Then el usuario visualiza su orden
    
    Examples:
      | Full Name      | Address Line 1 | Address Line 2 | City  | State    | Zip Code | Country        | Card Number      | Expiration Date | Segurity Code |
      | Rebecca Winter | Mandorley 112  | Entrace 1      | Truro | Cornwall | 89750    | Unuted Kingdom | 3258125675687891 | 0325            | 123           |
    
    @CompletarCompra
    Scenario Outline: Finalizar compra
      And el usuario hace click en la imagen del producto Sauce Labs Backpack (violet)
      And el usuario visualiza la pagina del producto Sauce Labs Backpack (violet)
      And el usuario hace click en Add to cart
      And el usuario visualiza en el carrito el numero 1
      And el usuario hace click en el carrito
      And el usuario visualiza My Cart al ingresar al carrito
      And el usuario hace click en Proceed To Checkout
      And el usuario rellena los campos Full Name <Full Name>, Address Line 1 <Address Line 1>, Address Line 2 <Address Line 2>, City <City>, State <State>, ZipCode <Zip Code> y Country <Country>
      And el usuario hace click en en To Payment
      And el usuario visualiza la pasarela de pago
      And el usuario completa los campos Full Name <Full Name>, Card Number <Card Number>, Expiration Date <Expiration Date> y Segurity Code <Segurity Code>
      And el usuario hace clic en Review Order
      And el usuario visualiza su orden
      When el usuario hace click en Place Order
      Then el usuario visualiza el mensaje Checkout Complete
      
      Examples:
        | Full Name      | Address Line 1 | Address Line 2 | City  | State    | Zip Code | Country        | Card Number      | Expiration Date | Segurity Code |
        | Rebecca Winter | Mandorley 112  | Entrace 1      | Truro | Cornwall | 89750    | Unuted Kingdom | 3258125675687891 | 0325            | 123           |
    
    