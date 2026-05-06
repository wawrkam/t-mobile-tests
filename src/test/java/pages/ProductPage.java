package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductPage {

    public void smartphoneListIsVisible() {

        $$("[data-qa^='LST_ProductCard']")
                .shouldHave(CollectionCondition.sizeGreaterThan(1),
                        Duration.ofSeconds(15));
    }

    public void openDeviceBySlug(String slug, String deviceName) {

        $("a[href*='" + slug + "']")
                .shouldBe(visible, Duration.ofSeconds(15))
                .shouldBe(enabled)
                .scrollIntoView(true)
                .click();

        $("h1")
                .shouldBe(visible, Duration.ofSeconds(15))
                .shouldHave(text(deviceName));

    }

    public void theProductPageForDeviceIsDisplayed(String deviceName) {

        $("h1[data-qa='PRD_ProductName']")
                .shouldBe(visible)
                .shouldHave(text(deviceName));

    }

    public int getProductPrice() {

        String priceText =
                $("span.actualText")
                        .shouldBe(visible, Duration.ofSeconds(15))
                        .getText();

        return priceToInt(priceText);
    }

    private int priceToInt(String priceText) {
        return Integer.parseInt(
                priceText
                        .replace("zł", "")
                        .replace(" ", "")
                        .trim()
        );
    }

    public void addToCartBySlug(String slug) {

        SelenideElement option =
                $$("button")
                        .filter(visible)
                        .findBy(attributeMatching("data-qa", "PRD_.*"));

        option.doubleClick();
    }
}