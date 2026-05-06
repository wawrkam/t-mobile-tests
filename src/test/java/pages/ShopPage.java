package pages;

import java.time.Duration;

import static com.codeborne.selenide.Condition.partialText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShopPage {

    public void selectNoSubscriptionPhones() {

        $$(".ODSGlobalHeaderMegaMenu-Container a")
                .findBy(partialText("bez abonamentu"))
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
    }
}

