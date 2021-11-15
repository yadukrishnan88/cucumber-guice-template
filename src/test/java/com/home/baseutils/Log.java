package com.home.baseutils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {
    private static Logger Log = Logger.getLogger(Log.class.getName());
    private static String log4jPath = "src/test/resources/log4j2.properties";

    public static void info(String message) {
        PropertyConfigurator.configure(log4jPath);
        Log.info(message);
    }

    public static void error(String message) {
        PropertyConfigurator.configure(log4jPath);
        Log.error(message);
    }

    public static void debug(String message) {
        PropertyConfigurator.configure(log4jPath);
        Log.debug(message);
    }
}
