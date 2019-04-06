package hw3.setup.enums;

public enum capabilitiesEnums {
    UDID("udid"),
    API_KEY ("key"),
    APPIUM_HUB ("hub"),
    PLATFORM("platformName"),
    BROWSER ("browserName"),
    SUT("sut"),
    APP_PACKAGE("appPackage"),
    APP_TYPE("app_type"),
    APP_ACTIVITY("appActivity");

    public final String value;

    capabilitiesEnums(String value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return value;
    }
}
