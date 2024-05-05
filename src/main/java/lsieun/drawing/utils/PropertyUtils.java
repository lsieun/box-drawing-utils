package lsieun.drawing.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtils {
    public static Properties loadPropertiesFromClasspath(String filename) {
        Properties props = new Properties();
        try {
            props.load(PropertyUtils.class.getClassLoader().getResourceAsStream(filename));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return props;
    }

    public static Properties loadPropertiesFromFilePath(String filepath) {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(filepath);
             BufferedInputStream bis = new BufferedInputStream(fis)) {
            props.load(bis);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return props;
    }

    public static String getProperty(Properties props, String key) {
        return props.getProperty(key);
    }

    public static String getProperty(Properties props, String key, String defaultValue) {
        return props.getProperty(key, defaultValue);
    }
}
