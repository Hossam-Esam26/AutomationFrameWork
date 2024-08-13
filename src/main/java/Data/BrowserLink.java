package Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BrowserLink {

    public static Properties data;

    static {
        try {
            data = LoadProperties("src/test/java/DataForTest/Browser.properties");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Properties LoadProperties(String path) throws IOException {
        Properties pro = new Properties();
        FileInputStream stream = new FileInputStream(path);
        pro.load(stream);

        return pro;
    }
}
