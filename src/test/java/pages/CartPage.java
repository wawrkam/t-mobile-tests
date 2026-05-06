package pages;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    public void verifyCartPageVisible() {

        $("h1")
                .shouldBe(visible, Duration.ofSeconds(15))
                .shouldHave(text("Twój koszyk"));
    }

    public void verifyPriceMatches() {

        $("h1")
                .shouldBe(visible, Duration.ofSeconds(15))
                .shouldHave(text("Twój koszyk"));

        String cartPriceText =
                $("span[data-qa='BKT_Activation']")
                        .shouldBe(visible, Duration.ofSeconds(15))
                        .getText();

        int cartPrice = priceToInt(cartPriceText);

        if (cartPrice <= 0) {
            throw new AssertionError(
                    "Cena w koszyku jest nieprawidłowa: " + cartPriceText
            );
        }
    }

    private int priceToInt(String priceText) {
        return Integer.parseInt(
                priceText
                        .replace("zł", "")
                        .replace(" ", "")
                        .trim()
        );
    }

    public void cartPageIsVisible() {

        $("h1")
                .shouldBe(visible, Duration.ofSeconds(15))
                .shouldHave(text("Twój koszyk"));
    }

    public void verifyDeviceIsInCart(String deviceName) {

        $("body")
                .shouldHave(text(deviceName), Duration.ofSeconds(15));
    }
}