package com.crowdar.examples.services;


import com.crowdar.driver.DriverManager;
import com.crowdar.examples.constants.CarritoConstants;
import io.appium.java_client.MobileBy;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;


public class GenericService {
    public static WebElement scrollAndroid(String locatorType, String locatorValue) {

        String uiSelector = "";

        // -----------------------------
        // INTERPRETAR PREFIJOS LIPPIA
        // -----------------------------
        if (locatorValue.startsWith("ID:")) {
            locatorType = "id";
            locatorValue = locatorValue.replace("ID:", "");
        } else if (locatorValue.startsWith("ACCESSIBILITY_ID:")) {
            locatorType = "accessibility";
            locatorValue = locatorValue.replace("ACCESSIBILITY_ID:", "");
        } else if (locatorValue.startsWith("XPATH:")) {
            locatorType = "xpath";
            locatorValue = locatorValue.replace("XPATH:", "");
        } else if (locatorValue.startsWith("CLASS_NAME:")) {
            locatorType = "class";
            locatorValue = locatorValue.replace("CLASS_NAME:", "");
        }

        // -----------------------------
        // MAPEAR A UiSelector
        // -----------------------------
        switch (locatorType.toLowerCase()) {
            case "text":
                uiSelector = String.format("new UiSelector().text(\"%s\")", locatorValue);
                break;

            case "textcontains":
                uiSelector = String.format("new UiSelector().textContains(\"%s\")", locatorValue);
                break;

            case "id":
                uiSelector = String.format("new UiSelector().resourceId(\"%s\")", locatorValue);
                break;

            case "accessibility":
                uiSelector = String.format("new UiSelector().description(\"%s\")", locatorValue);
                break;

            case "class":
                uiSelector = String.format("new UiSelector().className(\"%s\")", locatorValue);
                break;

            case "xpath":
                // UiAutomator NO soporta xpath → indicamos el error
                throw new IllegalArgumentException(
                        "UiScrollable no soporta XPath. Usá text(), textContains(), id() o accessibility()."
                );

            default:
                throw new IllegalArgumentException("Tipo de locator no soportado: " + locatorType);
        }

        // -----------------------------
        // ARMAR UI SCROLLABLE
        // -----------------------------
        String uiScrollable =
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(" + uiSelector + ");";

        return DriverManager.getDriverInstance()
                .findElement(MobileBy.AndroidUIAutomator(uiScrollable));
    }












}
