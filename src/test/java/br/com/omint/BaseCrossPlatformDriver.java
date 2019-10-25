package br.com.omint;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class BaseCrossPlatformDriver {
    public AppiumDriver<MobileElement> driver;
    private static AppiumDriverLocalService service;

    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();

        if (service == null || !service.isRunning()) {
            throw new AppiumServerHasNotBeenStartedLocallyException(
                    "An appium server node is not started!");
        }
        if (System.getProperty("platform").equalsIgnoreCase("ios")) {
            iOSCaps();
        } else if (System.getProperty("platform").equalsIgnoreCase("android")) {
            androidCaps();
        }
    }

    private void androidCaps() throws IOException {
        /*File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "../../../apps/");
        File app = new File(appDir.getCanonicalPath(), "VodQA.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver<MobileElement>(service.getUrl(), capabilities);*/

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "RQ8M608PEDN");
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", "br.com.omint.apps.minhaomint");
        dc.setCapability("appActivity", "br.com.omint.apps.minhaomint.MainActivity");
        dc.setCapability("newCommandTimeout", 20000);

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);

    }

    private void iOSCaps() throws Exception {
        // set up appium
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "../../../apps/");
        File app = new File(appDir, "VodQAReactNative.zip");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformVersion", "10.2");
        capabilities.setCapability("deviceName", "iPhone 5s");
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new IOSDriver<MobileElement>(service.getUrl(), capabilities);
    }

    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
        if (service != null) {
            service.stop();
        }
    }

    public void login() throws Exception {

        setUp();

        /*new WebDriverWait(driver, 30).until(ExpectedConditions.
                elementToBeClickable(MobileBy.AccessibilityId("login"))).click();*/

        MobileElement el1 = (MobileElement) driver.findElementById("com.android.packageinstaller:id/permission_allow_button");

        new WebDriverWait(driver, 10).until(ExpectedConditions.
                elementToBeClickable(el1)).click();

        // Permitindo acesso a Localidade do aparelho
/*        MobileElement el1 = (MobileElement) driver.findElementById("com.android.packageinstaller:id/permission_allow_button");
        el1.click();*/
    }

    public void verticalSwipe(String locator) throws InterruptedException {
        Thread.sleep(3000);
        MobileElement slider = driver.findElementByAccessibilityId(locator);
        Dimension size = slider.getSize();

        //TouchAction swipe = new TouchAction(driver).press(slider, size.width / 2, size.height - 20)
        //        .waitAction(2000).moveTo(slider,size.width / 2, size.height / 2 + 50).release();
        //swipe.perform();
    }
}
