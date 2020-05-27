package designPatterns.factory;

import designPatterns.factory.countries.Countries;
import designPatterns.factory.countries.France.ExpediaFrance;
import designPatterns.factory.countries.Netherlands.ExpediaNetherlands;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class ExpediaFactory {

    private Expedia netherlands;
    private Expedia france;
    private Map<Countries, Expedia> countryMap = new HashMap<>();

    public ExpediaFactory(final WebDriver driver) {
        this.netherlands = new ExpediaNetherlands(driver);
        this.france = new ExpediaFrance(driver);
    }

    private void addCountries() {
        countryMap.put(Countries.NETHERLANDS, netherlands);
        countryMap.put(Countries.FRANCE, france);
    }

    public Expedia getCountry(Countries country) {
        addCountries();
        return countryMap.get(country);
    }

}
