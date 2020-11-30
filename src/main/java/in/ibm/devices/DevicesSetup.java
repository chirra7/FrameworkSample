package in.ibm.devices;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;

public class DevicesSetup {

    private AppiumDriver<WebElement> appiumDriver = null;

    public AppiumDriver<WebElement> androidDeviceSetupWithApplication(LinkedHashMap<String, String> capabilitiyValues) {

        DesiredCapabilities desCapObj = new DesiredCapabilities();
        String pefectoUrlValue = capabilitiyValues.get("PefectoUrl");

        desCapObj.setCapability("appPackage", capabilitiyValues.get("ApplicationPackageName"));
        desCapObj.setCapability("autoInstrument", true);
        desCapObj.setCapability("fullReset", false);

        desCapObj.setCapability("deviceName", capabilitiyValues.get("DeviceName"));
        desCapObj.setCapability("platformName", "ANDROID");
        desCapObj.setCapability("platformVersion", capabilitiyValues.get("OSVersion"));
        desCapObj.setCapability("manufacturer", capabilitiyValues.get("Manufacturer"));
        desCapObj.setCapability("model", capabilitiyValues.get("Model"));
        desCapObj.setCapability("location", capabilitiyValues.get("Location"));
        desCapObj.setCapability("resolution", capabilitiyValues.get("AppPackageName"));
        desCapObj.setCapability("network", capabilitiyValues.get("Network"));
        desCapObj.setCapability("automationName", "APPIUM");
        desCapObj.setCapability("user", capabilitiyValues.get("UserId"));
        desCapObj.setCapability("password", capabilitiyValues.get("Password"));
        desCapObj.setCapability("bundleId", capabilitiyValues.get("BundleId"));
        desCapObj.setCapability("cameraInstrument", true);

        try {
            appiumDriver = new AndroidDriver<WebElement>(new URL(pefectoUrlValue), desCapObj);
            appiumDriver.launchApp();
            return appiumDriver;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public AppiumDriver<WebElement> androidDeviceSetupWithBrowser(LinkedHashMap<String, String> capabilitiyValues, String applicationUrl) {

        DesiredCapabilities desCapObj = new DesiredCapabilities();
        String pefectoUrlValue = capabilitiyValues.get("PefectoUrl");

        desCapObj.setCapability("deviceName", capabilitiyValues.get("DeviceName"));
        desCapObj.setCapability("platformName", "ANDROID");
        desCapObj.setCapability("platformVersion", capabilitiyValues.get("OSVersion"));
        desCapObj.setCapability("manufacturer", capabilitiyValues.get("Manufacturer"));
        desCapObj.setCapability("model", capabilitiyValues.get("Model"));
        desCapObj.setCapability("location", capabilitiyValues.get("Location"));
        desCapObj.setCapability("resolution", capabilitiyValues.get("AppPackageName"));
        desCapObj.setCapability("network", capabilitiyValues.get("Network"));
        desCapObj.setCapability("automationName", "APPIUM");
        desCapObj.setCapability("user", capabilitiyValues.get("UserId"));
        desCapObj.setCapability("password", capabilitiyValues.get("Password"));
        desCapObj.setCapability("bundleId", capabilitiyValues.get("BundleId"));
        desCapObj.setCapability("cameraInstrument", true);

        try {
            appiumDriver = new AndroidDriver<WebElement>(new URL(pefectoUrlValue), desCapObj);
            appiumDriver.get(applicationUrl);

            return appiumDriver;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public AppiumDriver<WebElement> iosDeviceSetupWithApplication(LinkedHashMap<String, String> capabilitiyValues) {
        DesiredCapabilities desCapObj = new DesiredCapabilities();
        String pefectoUrlValue = capabilitiyValues.get("PefectoUrl");

        desCapObj.setCapability("appPackage", capabilitiyValues.get("ApplicationPackageName"));
        desCapObj.setCapability("autoInstrument", true);
        desCapObj.setCapability("fullReset", false);

        desCapObj.setCapability("deviceName", capabilitiyValues.get("DeviceName"));
        desCapObj.setCapability("platformName", "ANDROID");
        desCapObj.setCapability("platformVersion", capabilitiyValues.get("OSVersion"));
        desCapObj.setCapability("manufacturer", capabilitiyValues.get("Manufacturer"));
        desCapObj.setCapability("model", capabilitiyValues.get("Model"));
        desCapObj.setCapability("location", capabilitiyValues.get("Location"));
        desCapObj.setCapability("resolution", capabilitiyValues.get("AppPackageName"));
        desCapObj.setCapability("network", capabilitiyValues.get("Network"));
        desCapObj.setCapability("automationName", "APPIUM");
        desCapObj.setCapability("user", capabilitiyValues.get("UserId"));
        desCapObj.setCapability("password", capabilitiyValues.get("Password"));
        desCapObj.setCapability("bundleId", capabilitiyValues.get("BundleId"));
        desCapObj.setCapability("cameraInstrument", true);

        try {
            appiumDriver = new IOSDriver<WebElement>(new URL(pefectoUrlValue), desCapObj);
            appiumDriver.launchApp();

            return appiumDriver;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public AppiumDriver<WebElement> iosDeviceSetupWithBrowser(LinkedHashMap<String, String> capabilitiyValues, String applicationUrl) {

        DesiredCapabilities desCapObj = new DesiredCapabilities();
        String pefectoUrlValue = capabilitiyValues.get("PefectoUrl");

        desCapObj.setCapability("deviceName", capabilitiyValues.get("DeviceName"));
        desCapObj.setCapability("platformName", "ANDROID");
        desCapObj.setCapability("platformVersion", capabilitiyValues.get("OSVersion"));
        desCapObj.setCapability("manufacturer", capabilitiyValues.get("Manufacturer"));
        desCapObj.setCapability("model", capabilitiyValues.get("Model"));
        desCapObj.setCapability("location", capabilitiyValues.get("Location"));
        desCapObj.setCapability("resolution", capabilitiyValues.get("AppPackageName"));
        desCapObj.setCapability("network", capabilitiyValues.get("Network"));
        desCapObj.setCapability("automationName", "APPIUM");
        desCapObj.setCapability("user", capabilitiyValues.get("UserId"));
        desCapObj.setCapability("password", capabilitiyValues.get("Password"));
        desCapObj.setCapability("bundleId", capabilitiyValues.get("BundleId"));
        desCapObj.setCapability("cameraInstrument", true);

        try {
            appiumDriver = new IOSDriver(new URL(pefectoUrlValue), desCapObj);
            appiumDriver.get(applicationUrl);
            return appiumDriver;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }



}
