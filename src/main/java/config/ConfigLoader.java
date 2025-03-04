package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private static Properties prop;

    static {
        prop = new Properties();
        try (InputStream input = new FileInputStream("src/test/resources/config/config.properties")) {
            prop.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("exception, Raar");
        }
    }

    public String getProperty(String key) {
        return prop.getProperty(key);
    }
}
