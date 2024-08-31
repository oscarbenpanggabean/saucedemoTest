package driverFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

    private Properties prop;
    private String PROPERTIES_FILE;
    public String URL;
    public String browser;
    public Boolean isHeadless;
    public Boolean enableScreenshot;

    public Configuration() {
        initProp();
        loadData();
    }

    public void initProp() {
        this.prop = new Properties();
        PROPERTIES_FILE = "src\\test\\java\\driverFactory\\configuration.properties";
        try {
            FileInputStream fileStream = new FileInputStream(PROPERTIES_FILE);
            prop.load(fileStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadData() {
        URL = getData("URL");
        browser = getData("browser");
        isHeadless = getBooleanData("isHeadless");
        enableScreenshot = getBooleanData("enableScreenshot");
    }

    private String getData(String key) {
        return prop.getProperty(key);
    }

    private Boolean getBooleanData(String key) {
        return Boolean.parseBoolean(prop.getProperty(key));
    }
}
