package hw3.setup.driver;

import hw3.setup.NativePropertyReader;
import hw3.setup.WebPropertyReader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;

public class NativeUtils {
    public static URL createUrl() throws IOException {
        URL url = null;
        try {
            url = new URL(format("http://%s:%s@%s/wd/hub", "EPM-TSTF", WebPropertyReader.instance().key, WebPropertyReader.instance().hub));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
