package scenarios.pageobject.web.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum HomePageData {
    INTRO("The global coordination of the DNS Root, IP addressing,\n" +
            "and other Internet protocol resources is performed as the\n" +
            "Internet Assigned Numbers Authority (IANA) functions.\n" +
            "Learn more.");

    private String value;

    @Override
    public String toString() {
        return value.replaceAll("\n", " ").trim();
    }
}
