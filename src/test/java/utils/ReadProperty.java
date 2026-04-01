package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {

    public static Properties readProperties() {
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        Properties properties = new Properties();
        File packageFile = new File(path + "configs");
        File[] files = packageFile.listFiles();
        try {
            for(File file: files) {
                String name = file.getName();
                if (name.endsWith(".xml")) {
                    properties.loadFromXML(new FileInputStream(file));
                }
                if (name.endsWith(".properties")) {
                    properties.load(new FileInputStream(file));
                }
            }
        } catch (IOException e) {}
        return properties;
    }
}
