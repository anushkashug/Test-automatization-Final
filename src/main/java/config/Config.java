

package com.Ana.framework.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Config {
    private static final Properties props = new Properties();

    static {
        try (InputStream is = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (is == null) throw new RuntimeException("config.properties not found");
            props.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Config() {}

    public static String uiBaseUrl() { return props.getProperty("ui.baseUrl"); }
    public static String apiBaseUrl() { return props.getProperty("api.baseUrl"); }
    public static int timeoutSeconds() { return Integer.parseInt(props.getProperty("timeoutSeconds", "10")); }
    public static boolean headless() { return Boolean.parseBoolean(props.getProperty("headless", "false")); }
}
