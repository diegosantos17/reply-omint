package br.com.omint.utils;

import br.com.omint.utils.enums.SelectorType;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ElementManager {
    private static AndroidDriver<MobileElement> driver;

    public ElementManager(AndroidDriver<MobileElement> driver){
        this.driver = driver;
    }

    public MobileElement getElement(String selectorName, SelectorType selectorType) {

        ClassLoader classLoader = getClass().getClassLoader();
        MobileElement element = null;

        try (InputStream inStream = classLoader.getResourceAsStream("objectsSelector.xml")) {

            String outPropertiesFile = "objects.selector";
            OutputStream outStream = new FileOutputStream(outPropertiesFile);   //Output properties File

            Properties props = new Properties();

            //Load XML file
            props.loadFromXML(inStream);

            //Store to properties file
            props.store(outStream, "Converted from objectsSelector.xml");

            if(selectorType == SelectorType.ID) {
                //Use properties in code
                element = (MobileElement) driver.findElementById(props.get(selectorName).toString());
            }
            else if (selectorType == SelectorType.XPATH){
                element = (MobileElement) driver.findElementByXPath(props.get(selectorName).toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            return element;
        }
    }
}
