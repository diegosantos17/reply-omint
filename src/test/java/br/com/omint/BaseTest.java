package br.com.omint;

import br.com.omint.utils.ConfigurationManager;
import br.com.omint.utils.ElementManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public static AndroidDriver<MobileElement> driver;
    public static ConfigurationManager configManager;
    public static ElementManager elementManager;

    public void initAppiumSync() throws MalformedURLException {

        configManager = new ConfigurationManager();

        System.out.println("Inicializando Appium");

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, configManager.getConfiguration("deviceName"));
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", configManager.getConfiguration("appPackage"));
        dc.setCapability("appActivity", configManager.getConfiguration("appActivity"));
        dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 600);

        driver = new AndroidDriver<MobileElement>(new URL(configManager.getConfiguration("urlAppiumServer")), dc);

        elementManager = new ElementManager(driver);

        System.out.println("Inicializando Minha Omint");
    }
}
