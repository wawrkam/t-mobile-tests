package utils;

public class PriceUtils {

    public static int priceToInt(String priceText) {
        return Integer.parseInt(
                priceText
                        .replace("\u00A0", "")
                        .replace("zł", "")
                        .replace(" ", "")
                        .trim()
        );
    }
}