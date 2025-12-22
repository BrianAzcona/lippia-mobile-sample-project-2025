package com.crowdar;

import io.cucumber.java.Before;

public class Hooks {

    @Before("@AddProductBefore")
    public void AddProductBefore(){
        System.out.println("FUNCIONA EL HOOK");
    }


}
