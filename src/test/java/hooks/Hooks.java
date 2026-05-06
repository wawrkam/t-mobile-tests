package hooks;

import com.codeborne.selenide.Screenshots;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class Hooks {

    @Before
    public void setUp() {
        open("about:blank"); // inicjalizacja przeglądarki
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            scenario.attach(
                    String.valueOf(Screenshots.takeScreenShotAsFile()),
                    "image/png",
                    "Failure screenshot"
            );
        }

        closeWebDriver();
    }
}