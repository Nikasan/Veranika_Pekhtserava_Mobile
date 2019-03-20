package scenarios.setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class WebPropertyReader {

    private static WebPropertyReader _instance;
    public String sut;
    public String platform;
    public String driver;
    public String deviceName;
    public String browser;

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
            fis = new FileInputStream("src/main/resources/webtest.properties");
            property.load(fis);

            this.sut = property.getProperty("sut");
            this.platform = property.getProperty("platform");
            this.driver = property.getProperty("driver");
            this.deviceName = property.getProperty("deviceName");
            this.browser = property.getProperty("browser");

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}


