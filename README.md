# T-Mobile E2E Tests

End-to-end tests for t-mobile.pl written in Java with Selenide and Cucumber.

Covers the add-to-cart flow for phones without a subscription plan — navigation, product page, cart price verification.

## Tech stack

- **Java 21**
- **Selenide 7.2.3** — browser automation, handles ChromeDriver automatically
- **Cucumber 7.16.1** — BDD framework
- **JUnit 4** — test runner
- **Maven** — build tool

## Structure

```
src/test/
├── java/
│   ├── hooks/Hooks.java          # browser setup and teardown
│   ├── pages/                    # Page Objects (HomePage, ProductPage, CartPage, ShopPage)
│   ├── runner/CucumberRunner.java
│   ├── steps/TmobileSteps.java   # step definitions
│   └── utils/PriceUtils.java
└── resources/features/
    └── tmobile_cart.feature
```

## Running tests

```bash
# all tests
mvn test

# filter by tag
mvn test -Dcucumber.tags=@smoke

# headless (no browser UI)
mvn test -Dheadless=true

# combined
mvn test -Dcucumber.tags=@smoke -Dheadless=true
```

## Reports

After a run:
- HTML: `target/cucumber-report.html`
- JSON: `target/cucumber.json`

## Page Objects

All selectors live in classes under `pages/`. Step definitions just call methods — no `$()` or `$$()` in steps.
