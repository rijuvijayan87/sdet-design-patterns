package designPatterns.test.factory;

import designPatterns.factory.Expedia;
import designPatterns.factory.ExpediaFactory;
import designPatterns.factory.countries.Countries;
import designPatterns.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExpediaTest extends BaseTest {
    private Expedia expedia;
    private ExpediaFactory expediaFactory;

    @BeforeTest
    public void setUpCountries() {
        this.expediaFactory = new ExpediaFactory(driver);
    }

    @Test(dataProvider = "getData")
    public void DutchTest(Countries country) {
        this.expedia = expediaFactory.getCountry(country);
        expedia.goTo();
        Assert.assertTrue(expedia.getLogoText().equalsIgnoreCase("www.expedia.nl"), "Logo text is invalid");
        Assert.assertTrue(expedia.isBookingOptionsPresent());
        Assert.assertEquals(expedia.getSubmitButtonText(), "Zoeken");
    }

    @DataProvider
    public Object[] getData() {
        return new Object[]{
                Countries.NETHERLANDS,
                Countries.FRANCE
        };
    }
}
