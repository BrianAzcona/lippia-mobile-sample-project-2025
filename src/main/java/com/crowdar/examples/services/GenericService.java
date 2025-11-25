package com.crowdar.examples.services;


import com.crowdar.driver.DriverManager;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;

public class GenericService {
    public static WebElement scrollAndroid(String locatorType, String locatorValue) {

        String uiSelector = "";

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
                throw new IllegalArgumentException(
                        "UiScrollable no soporta XPath. Usá text(), textContains(), id() o accessibility()."
                );

            default:
                throw new IllegalArgumentException("Tipo de locator no soportado: " + locatorType);
        }
        String uiScrollable =
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(" + uiSelector + ");";

        return DriverManager.getDriverInstance()
                .findElement(MobileBy.AndroidUIAutomator(uiScrollable));
    }


}
