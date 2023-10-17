package Steps;

import BaseTest.DriverBase;
import Pages.StcLandingPage;
import Pojos.DataBinder;
import Pojos.WebsiteData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.File;

public class StcWebsiteSteps extends DriverBase {
    StcLandingPage stcLandingPage;

    @Given("Initializing environment and open website on {string}browser")
    public void OpenWebsite(String browsername) throws Exception {

        try {
            stcLandingPage = new StcLandingPage(DriverBase.getdriverPerBrowser(browsername));
            String Url = readdata("WebsiteUrl");
            DriverBase.OpenWebsite(browsername, Url);

        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }
    @Given("Initializing environment1 and open website on {string}browser")
    public void OpenWebsite1(String browsername) throws Exception {

        try {
            //stcLandingPage = new StcLandingPage(DriverBase.getdriverPerBrowser(browsername));


           // stcLandingPage = new StcLandingPage(DriverBase.getdriverPerBrowser(browsername));
           // DriverBase.OpenWebsite(browsername, obj.getUrl());
            DataBinder data=new DataBinder();
            data.DesrialzeMapper();
            WebsiteData obj=new WebsiteData();
            obj.getCountry1();
            obj.getUrl();
            obj.getNoOfPackageTypes();
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }
    @When("StcTv website is loaded correctly")
    public void StcTvwebsite_loadedcorrectly() throws Exception {
        try {
            stcLandingPage.WaitTillLogoAppeared();
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    @Given("validate that StcTv will show 3 countries names in countries section")
    public void ValidateOnExistiningCompaniesList() throws Exception {
        try {
            stcLandingPage.ValidateCompaniesList();
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    @Then("validate that StcTv will show 3 packages types for for all countries")
    public void ValidateOnExistiningPackagesTypes() throws Exception {
        try {
            stcLandingPage.ValidateOnPackagesTypes();
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }

    @Given("validate the subscription packages plan prices and currency per country {string}")
    public void ValidateSubscriptionPackagePerCountryName(String CountryName) throws Exception {
        try {
            stcLandingPage.ValidateonOackagePriceandCurrency(CountryName);
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }

    }

    @Then("the chrome driver is closed")
    public void Closedriver() {
        driver.close();
    }
}
