package scenarios.setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class NativePropertyReader {

    private static NativePropertyReader _instance;
    public String appPath;
    public String platform;
    public String driver;
    public String deviceName;

    private NativePropertyReader() throws IOException{
        init();
    }

    public static NativePropertyReader instance()  throws IOException {
        if (NativePropertyReader._instance == null) NativePropertyReader._instance = new NativePropertyReader();

        return NativePropertyReader._instance;
    }

    private void init() throws IOException {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/nativetest.properties");
            property.load(fis);

            this.appPath = property.getProperty("appPath");
            this.platform = property.getProperty("platform");
            this.driver = property.getProperty("driver");
            this.deviceName = property.getProperty("deviceName");
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}

