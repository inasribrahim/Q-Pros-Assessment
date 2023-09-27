package com.demoblaze.q_pros.utils.read_properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ReadProperties {
   private ReadProperties(){}

   private static final String ROOT_PATH = System.getProperty("user.dir") +"/src/test/java/resources/";
   private static final String DEMOBLAZE_CONFIG_PATH=ROOT_PATH.concat("demoblaze_config.properties");
    public static Properties setDemoBlazeConfig() throws IOException {
        Properties configProperties = new Properties();
        FileInputStream inputStream = new FileInputStream(DEMOBLAZE_CONFIG_PATH);
        configProperties.load(inputStream);
        return configProperties;
    }
}
