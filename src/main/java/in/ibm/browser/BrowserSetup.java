package in.ibm.browser;

import in.ibm.constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserSetup {


    private WebDriver driver = null;

    public void chromeBrowserSetup(String applicationURL, String... isHeadLess) {

        String chromeDriverPath = Constants.driversEXEFilesFolderPath + "\\" + "chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        ChromeOptions options = new ChromeOptions();
        if(isHeadLess.length >= 1){
            String value = isHeadLess[0];
            if(value.equalsIgnoreCase("True") || value.equalsIgnoreCase("Yes"))
                options.addArguments("headless");
        }

        options.addArguments("window-size=1366x3500");
        options.addArguments("disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to(applicationURL);
    }

    public void ieBrowserSetup(String applicationURL, String... isHeadLess) {

        String ieDriverPath = Constants.driversEXEFilesFolderPath + "\\" + "IEDriverServer.exe";
        System.setProperty("webdriver.ie.driver", ieDriverPath);

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        cap.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
        cap.setCapability("nativeEvents", false);
        cap.setCapability("unexpectedAlertBehaviour", "accept");
        cap.setCapability("ignoreProtectedModeSettings", true);
        cap.setCapability("disable-popup-blocking", true);
        cap.setCapability("enablePersistentHover", true);
        cap.setCapability("ignoreZoomSetting", true);
        cap.setJavascriptEnabled(true);

      /*  if(isHeadLess.length >= 1){
            String value = isHeadLess[0];
            if(value.equalsIgnoreCase("True") || value.equalsIgnoreCase("Yes"))
                options.addArguments("headless");
        }*/

        driver = new InternetExplorerDriver(cap);
        driver.navigate().to(applicationURL);
    }

}
