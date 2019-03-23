package hw3.setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class NativePropertyReader {

    private static NativePropertyReader _instance;
    public String key;
    public String hub;
    public String udid;
    public String platformName;
    public String appPackage;
    public String appActivity;
    public String aut;
    public String autoLaunch;
    public String app;


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
            fis = new FileInputStream("src/main/resources/nativefarm.properties");
            property.load(fis);

            this.key = property.getProperty("key");
            this.hub = property.getProperty("hub");
            this.udid = property.getProperty("udid");
            this.platformName = property.getProperty("platformName");
            this.appPackage = property.getProperty("appPackage");
            this.appActivity = property.getProperty("appActivity");
            this.aut = property.getProperty("aut");
            this.aut = property.getProperty("autoLaunch");
            this.app = property.getProperty("app");

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}


