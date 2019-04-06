package hw2.setup.enums;

public enum capabilitiesEnums {
    APP("app"),
    PLATFORM("platformName"),
    DEVICE("deviceName"),
    BROWSER("browserName"),
    CHDREXECUTABLE("chromedriverExecutable"),
    APP_TYPE("app_type"),
    SUT("sut"),
    DRIVER("driver");


    public final String value;

    capabilitiesEnums(String value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}
