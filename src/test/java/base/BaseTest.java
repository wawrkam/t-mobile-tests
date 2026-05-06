package base;

import com.codeborne.selenide.Configuration;
import org.junit.Before;

public class BaseTest {

    @Before
    public void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
    }
}