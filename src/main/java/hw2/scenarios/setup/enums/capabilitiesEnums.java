package hw2.scenarios.setup.enums;

public enum capabilitiesEnums {
    APP("app"),
    PLATFORM("platformName"),
    DEVICE("deviceName"),
    BROWSER("browserName"),
    CHDREXECUTABLE("chromedriverExecutable");

    public final String value;

    capabilitiesEnums(String value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}
