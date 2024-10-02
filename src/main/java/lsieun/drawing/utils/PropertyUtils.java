package lsieun.drawing.utils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class PropertyUtils {

    public static Properties readProperties(Path path) {
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(path);
             BufferedInputStream bis = new BufferedInputStream(in)) {
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
