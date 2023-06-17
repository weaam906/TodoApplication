package com.weaamk.todo.utils;

import org.checkerframework.checker.units.qual.C;

import java.util.Properties;

public class ConfigUtils {
    private static ConfigUtils configUtils;
    private Properties properties;
    private ConfigUtils() {
        String env = System.getProperty("env","production"); //Here when we run from teh terminal
        switch (env) {
            case "production" -> properties = PropertiesUtils.loadProperties("src/test/java/com/weaamk/todo/config/production.properties");
            case "local" -> properties = PropertiesUtils.loadProperties("src/test/java/com/weaamk/todo/config/local.properties");
            default -> throw new RuntimeException("The environment isn't supported");
        }
    }
    public static ConfigUtils getInstance(){
        if(configUtils!=null) return configUtils;
        return new ConfigUtils();
    }

    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if(prop != null) return prop;
        throw new RuntimeException("Couldn't find baseUrl in the util file");
    }

    public String getEmail(){
        String prop = properties.getProperty("email");
        if(prop != null) return prop;
        throw new RuntimeException("Couldn't find email in the util file");
    }

    public String getPassword(){
        String prop = properties.getProperty("password");
        if(prop != null) return prop;
        throw new RuntimeException("Couldn't find password in the util file");
    }
}
