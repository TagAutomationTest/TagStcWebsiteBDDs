package Pages;

import BaseTest.DriverBase;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class StcLandingPage extends DriverBase {
    ArrayList<String> ar;
    Wait<WebDriver> wait;
    Duration timeout = Duration.ofSeconds(180);
    Duration polling = Duration.ofSeconds(2);
    private static final Logger log = LoggerFactory.getLogger(StcLandingPage.class);
    By StcLogo = By.cssSelector("a[id*='logo-web']");
    By VisibleCountryName = By.cssSelector("span#country-name");
    By CountriesArrowBtn = By.cssSelector("span[id*='arrow']");
    By SignInBtn = By.xpath("//a[@id='signin' and contains (text(),'Sign')]");
    By LanguageBtn = By.id("translation-btn");
    By KsaCountryLabel = By.id("sa-contry-lable");
    By KWCountryLabel = By.id("kw-contry-lable");
    By BaCountryLabel = By.id("bh-contry-lable");
    By CompanySectionTitle = By.cssSelector("strong#country-title");
    By CloseCountryPopupBtn = By.id("country-poppup-close");

    //KSA
    By SACountryLink = By.cssSelector("a#sa");
    By KWCountryLink = By.cssSelector("a#kw");
    By BACountryLink = By.cssSelector("a#bh");
    By Lite_MonthlyPlanValue = By.xpath("//div[contains(@id,'currency-lite')]/b");
    By Lite_MonthlyPlanCurrency = By.xpath("//div[contains(@id,'currency-lite')]/i");
    By classic_MonthlyPlanValue = By.xpath("//div[contains(@id,'currency-classic')]/b");
    By classic_MonthlyPlanCurrency = By.xpath("//div[contains(@id,'currency-classic')]/i");
    By premium_MonthlyPlanValue = By.xpath("//div[contains(@id,'currency-premium')]/b");
    By premium_MonthlyPlanCurrency = By.xpath("//div[contains(@id,'currency-premium')]/i");

    By PlanList = By.cssSelector("strong.plan-title");

    public StcLandingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new FluentWait<WebDriver>(this.driver).withTimeout(timeout).pollingEvery(polling)
                .ignoring(StaleElementReferenceException.class).ignoring(NoSuchElementException.class)
                .ignoring(UnknownError.class);

    }

    public void WaitTillLogoAppeared() throws Exception {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(StcLogo));
            log.info("Landing page loaded correctly and logo appeared");
        } catch (Exception e) {
            throw new Exception("Failure during WaitTillLogoAppeared" + e.getMessage());
        }

    }

    public void ValidateCompaniesList() throws Exception {
        try {
            log.info("Validating companies list ...Started");
            wait.until(ExpectedConditions.visibilityOfElementLocated(CountriesArrowBtn));
            clickOn(CountriesArrowBtn, false);
            wait.until(ExpectedConditions.visibilityOfElementLocated(CompanySectionTitle));
            wait.until(ExpectedConditions.visibilityOfElementLocated(KsaCountryLabel));
            Assert.assertTrue(GetelementText(KsaCountryLabel).contains(readdata("Country1")));
            Assert.assertTrue(GetelementText(KWCountryLabel).contains(readdata("Country2")));
            Assert.assertTrue(GetelementText(BaCountryLabel).contains(readdata("Country3")));
            log.info("Validating companies list ...Done");
            log.info("companies list contains " + readdata("Country1"), readdata("Country2"), readdata("Country3"));
            clickOn(CloseCountryPopupBtn, true);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void ValidateOnPackagesTypes() throws Exception {
        try {
            ArrayList<String> ar;
            log.info("Validating Packages list  ...Started");
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(PlanList));
            int numberOfPackages = Integer.parseInt(readdata("NoOfPackageTypes"));
            Assert.assertTrue(findElements(PlanList).size() == numberOfPackages);
            for (int i = 0; i < findElements(PlanList).size(); i++) {
                String SubscriptionPlanName = findElements(PlanList).get(i).getText();
                ar = new ArrayList<String>();
                ar.add(SubscriptionPlanName);
                log.info("plan" + i + "name is ", SubscriptionPlanName);
            }
            log.info("Validating Packages list  ...Done");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public void ValidateonOackagePriceandCurrency(String CountryName) throws Exception {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CountriesArrowBtn));
            clickOn(CountriesArrowBtn, false);
            switch (CountryName) {

                case "KSA":
                    wait.until(ExpectedConditions.elementToBeClickable(SACountryLink));
                    clickOn(SACountryLink, false);
                    log.info("Check that SA country selected now  ...Started");
                    Assert.assertTrue(findElement(SACountryLink).getAttribute("class").contains("selected"));
                   // clickOn(CloseCountryPopupBtn, true);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(Lite_MonthlyPlanValue));
                    Assert.assertTrue(GetelementText(Lite_MonthlyPlanValue).equalsIgnoreCase(readdata("KSALite")));
                    Assert.assertTrue(GetelementText(Lite_MonthlyPlanCurrency).contains(readdata("Currency1")));
                    Assert.assertTrue(GetelementText(classic_MonthlyPlanValue).equalsIgnoreCase(readdata("KSAClassic")));
                    Assert.assertTrue(GetelementText(classic_MonthlyPlanCurrency).contains(readdata("Currency1")));
                    Assert.assertTrue(GetelementText(premium_MonthlyPlanValue).equalsIgnoreCase(readdata("KSAPerimium")));
                    Assert.assertTrue(GetelementText(premium_MonthlyPlanCurrency).contains(readdata("Currency1")));
                    break;
                case "Bahrain":
                    wait.until(ExpectedConditions.elementToBeClickable(BACountryLink));
                    clickOn(BACountryLink, false);
                    log.info("Check that SA country selected now  ...Started");
                    Assert.assertTrue(findElement(BACountryLink).getAttribute("class").contains("selected"));
                   // clickOn(CloseCountryPopupBtn, true);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(Lite_MonthlyPlanValue));
                    Assert.assertTrue(GetelementText(Lite_MonthlyPlanValue).equalsIgnoreCase(readdata("BahrinLite")));
                    Assert.assertTrue(GetelementText(Lite_MonthlyPlanCurrency).contains(readdata("Currency2")));
                    Assert.assertTrue(GetelementText(classic_MonthlyPlanValue).equalsIgnoreCase(readdata("BahrinClassic")));
                    Assert.assertTrue(GetelementText(classic_MonthlyPlanCurrency).contains(readdata("Currency2")));
                    Assert.assertTrue(GetelementText(premium_MonthlyPlanValue).equalsIgnoreCase(readdata("BahrinPerimium")));
                    Assert.assertTrue(GetelementText(premium_MonthlyPlanCurrency).contains(readdata("Currency2")));
                    break;
                case "Kuwait":
                    wait.until(ExpectedConditions.elementToBeClickable(KWCountryLink));
                    clickOn(KWCountryLink, false);
                    log.info("Check that SA country selected now  ...Started");
                    Assert.assertTrue(findElement(KWCountryLink).getAttribute("class").contains("selected"));
                    //clickOn(CloseCountryPopupBtn, true);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(Lite_MonthlyPlanValue));
                    Assert.assertTrue(GetelementText(Lite_MonthlyPlanValue).equalsIgnoreCase(readdata("KweuitLite")));
                    Assert.assertTrue(GetelementText(Lite_MonthlyPlanCurrency).contains(readdata("Currency3")));
                    Assert.assertTrue(GetelementText(classic_MonthlyPlanValue).equalsIgnoreCase(readdata("KweuitClassic")));
                    Assert.assertTrue(GetelementText(classic_MonthlyPlanCurrency).contains(readdata("Currency3")));
                    Assert.assertTrue(GetelementText(premium_MonthlyPlanValue).equalsIgnoreCase(readdata("KweuitPerimium")));
                    Assert.assertTrue(GetelementText(premium_MonthlyPlanCurrency).contains(readdata("Currency3")));
                    break;
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }

    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public JavascriptExecutor scripts() {
        return (JavascriptExecutor) driver;
    }
    public Object executeScript(String script, Object... args) {
        return scripts().executeScript(script, args);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public void clickOn(By locator, boolean usingJavascript) throws IOException {
        try {
            WebElement element = findElement(locator);
            if (usingJavascript) {
                executeScript("arguments[0].click();", element);
            }
            element.click();

        } catch (Exception e) {

        }
    }

    public String GetelementText(By locator) {
        return findElement(locator).getText();
    }
}
