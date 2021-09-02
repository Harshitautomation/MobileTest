package org.example;

import static org.junit.Assert.assertTrue;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class MobileCalcEnter
{
    AndroidDriver driver;
    AppiumDriverLocalService appiumService;
    String appiumServiceUrl;

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws MalformedURLException, InstantiationException, IllegalAccessException {

    appiumService = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingPort(5037).withIPAddress("192.168.0.104").
                    usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe")).
            withAppiumJS(new File("C:\\Users\\HARSHIT\\Downloads\\Appium-windows-1.21.0\\resources\\app\\node_modules\\appium\\build\\lib\\main.js")));
    appiumService.start();
    appiumServiceUrl=appiumService.getUrl().toString();
        System.out.println("appium url is : " + appiumServiceUrl);
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("appPackage", "com.miui.calculator");
        cap.setCapability("appActivity", ".cal.CalculatorActivity");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,":5037");
        cap.setCapability("unlockType", "pattern");
        cap.setCapability("unlockKey", "742583");
        cap.setCapability("autoDismissAlerts", true);
        cap.setCapability("autoAcceptAlerts", true);
        cap.setCapability("autoGrantPermissions", "true");
        cap.setCapability("noReset", "true");

        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10");

        driver = new AndroidDriver<>(new URL(appiumServiceUrl),cap);
        System.out.println(driver.getBatteryInfo().getState().toString() + ": batteru usage");
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        driver.findElement(By.id("btn_3_s")).click();
        driver.findElement(By.id("btn_1_s")).click();
        driver.findElement(By.id("btn_3_s")).click();
        driver.findElement(MobileBy.AccessibilityId("plus"));
        driver.findElement(By.id("btn_3_s")).click();
        driver.findElement(MobileBy.AccessibilityId("equals"));


    }
}
