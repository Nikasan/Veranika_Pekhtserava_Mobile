package hw3.setup.driver;

import hw3.setup.WebPropertyReader;

import java.io.IOException;

import static java.lang.String.format;

public class WebUtils  {
    public static String createUrl() throws IOException {
        String url = format("http://%s:%s@%s/wd/hub", "EPM-TSTF", WebPropertyReader.instance().key, WebPropertyReader.instance().hub);
        return url;
    }
}
