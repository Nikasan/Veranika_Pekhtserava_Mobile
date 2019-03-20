package scenarios.setup.driver;

import scenarios.setup.NativePropertyReader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class NativeUtils {
    public static URL createUrl() throws IOException {
        URL url = null;
        try {
            url = new URL(NativePropertyReader.instance().driver);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
