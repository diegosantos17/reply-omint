package br.com.omint.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public  class ConfigurationManager {

    public String getConfiguration(String configName) {

        ClassLoader classLoader = getClass().getClassLoader();
        String configValue = null;

        try (InputStream inStream = classLoader.getResourceAsStream("config.xml")) {

            String outPropertiesFile = "config.selector";
            OutputStream outStream = new FileOutputStream(outPropertiesFile);   //Output properties File

            Properties props = new Properties();

            //Load XML file
            props.loadFromXML(inStream);

            //Store to properties file
            props.store(outStream, "Converted from config.xml");

            configValue = props.get(configName).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            return configValue;
        }
    }
}

