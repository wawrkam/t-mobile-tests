t-mobile-tests
E2E tests for t-mobile.pl — Selenide + Cucumber + Java 21.

Requirements
Java 21+

Maven 3.6+

Chrome (driver is managed automatically by Selenide)

Live internet access (tests hit t-mobile.pl directly)

Running tests
bash
# run everything
mvn test

# smoke only
mvn test -Dcucumber.tags=@smoke

# headless (e.g. on CI)
mvn test -Dheadless=true

# combined
mvn test -Dcucumber.tags=@smoke -Dheadless=true
Reports
Generated in target/ after each run:

cucumber-report.html — open in a browser for a readable summary

cucumber.json — use for CI integrations

Structure
text
src/test/
├── java/
│   ├── hooks/          # browser setup + auto-screenshot on failure
│   ├── pages/          # Page Objects (CartPage, HomePage, ProductPage, ShopPage)
│   ├── steps/          # Cucumber step definitions
│   ├── runner/         # CucumberRunner
│   └── utils/          # PriceUtils — handles price strings from t-mobile.pl
└── resources/
    └── features/       # .feature files with BDD scenarios
What's tested
Single scenario (@smoke, @regression) covering the full add-to-cart flow for a phone without a subscription plan:

Open homepage, accept cookies

Navigate to Shop → Phones without subscription

Open a product page (Xiaomi Redmi Note 15 Pro 5G)

Add to cart

Verify the cart price matches the price shown on the product page

Go back to homepage, reopen cart

Verify the device is still there

A few things worth knowing
No manual ChromeDriver setup needed — Selenide handles it

On failure, a screenshot is automatically attached to the HTML report

Tag filtering goes through -Dcucumber.tags, not through changes in the runner

Browser configuration lives in Hooks.java, not scattered across Page Objects
