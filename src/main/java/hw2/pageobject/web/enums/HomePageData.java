package hw2.pageobject.web.enums;

import lombok.Getter;
@Getter

public enum HomePageData {
    INTRO("The global coordination of the DNS Root, IP addressing,\n" +
            "and other Internet protocol resources is performed as the\n" +
            "Internet Assigned Numbers Authority (IANA) functions.\n" +
            "Learn more.");

    private String value;

    HomePageData(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return value.replaceAll("\n", " ").trim();
    }
}
