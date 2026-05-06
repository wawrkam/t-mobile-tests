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

    public void verifyPriceMatches(int expectedPrice) {
        String cartPriceText =
                $("[data-qa='BKT_Price'] [data-qa='BKT_Amount'], [data-qa='BKT_TotalPrice'] [data-qa='BKT_Amount'], [class*='cart'] [class*='price']")
                        .shouldBe(visible, Duration.ofSeconds(15))
                        .getText();

        int cartPrice = priceToInt(cartPriceText);

        if (cartPrice != expectedPrice) {
            throw new AssertionError(
                    "Cena w koszyku (" + cartPrice + " zł) nie zgadza się z ceną produktu (" + expectedPrice + " zł)"
            );
        }
    }

    private int priceToInt(String priceText) {
        return Integer.parseInt(
                priceText
                        .replace("\u00A0", "")
                        .replace("zł", "")
                        .replace(" ", "")
                        .trim()
        );
    }

    public void cartPageIsVisible() {
        verifyCartPageVisible();
    }

    public void verifyDeviceIsInCart(String deviceName) {
        $("[data-qa='BKT_ProductName'], [data-qa^='BKT_Item'] [data-qa='PRD_Name'], [data-qa='BKT_ProductList']")
                .shouldHave(text(deviceName), Duration.ofSeconds(15));
    }
}