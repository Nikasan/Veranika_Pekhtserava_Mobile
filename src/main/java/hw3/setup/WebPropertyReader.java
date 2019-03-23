package hw3.setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class WebPropertyReader {

    private static WebPropertyReader _instance;
    public  String key;
    public  String hub;
    public  String platform;
    public  String browser_name;
    public  String sut;
    public  String udid;

    private WebPropertyReader() throws IOException {
        init();
    }

    public static WebPropertyReader instance() throws IOException {
        if (WebPropertyReader._instance == null) WebPropertyReader._instance = new WebPropertyReader();
        return WebPropertyReader._instance;
    }

    private void init() throws IOException {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/webfarm.properties");
            property.load(fis);

            this.key = property.getProperty("key");
            this.hub = property.getProperty("hub");
            this.platform = property.getProperty("platformName");
            this.browser_name = property.getProperty("browserName");
            this.sut = property.getProperty("sut");
            this.udid = property.getProperty("udid");

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}


