package hw2.scenarios.setup.driver;

import hw2.scenarios.setup.WebPropertyReader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class WebUtils {
    public static URL createUrl() throws IOException {
        URL url = null;
        try {
            url = new URL(WebPropertyReader.instance().driver);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
