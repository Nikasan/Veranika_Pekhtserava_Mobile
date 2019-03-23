package hw3.setup.enums;

public enum capabilitiesEnums {
    UDID("udid"),
    API_KEY ("key"),
    APPIUM_HUB ("hub"),
    PLATFORM_NAME("platformName"),
    BROWSER_NAME ("browserName"),
    SUT("https://www.iana.org/"),
    APP_PACKAGE("appPackage"),
    APP_ACTIVITY("appActivity"),
    APP_LAUNCH("autoLaunch"),
    APP("app");
//autoLaunch
    public final String value;

    capabilitiesEnums(String value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}
