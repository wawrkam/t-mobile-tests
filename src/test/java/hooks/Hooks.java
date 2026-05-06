package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static com.codeborne.selenide.Screenshots.takeScreenShotAsBytes;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class Hooks {

    @Before
    public void setUp() {
        open("about:blank");
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                scenario.attach(
                        takeScreenShotAsBytes(),
                        "image/png",
                        "Failure screenshot"
                );
            }
        } finally {
            closeWebDriver();
        }
    }
}