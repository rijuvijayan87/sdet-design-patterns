package designPatterns.factory.countries.France;

import designPatterns.factory.Expedia;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExpediaFrance implements Expedia {

    @FindBy(css = "#app > div:nth-child(1) > div > div > header > div.site-header.all-l-padding-four > div > a > img")
    private WebElement logoElement;

    private WebDriver driver;
    private WebDriverWait wait;

    public ExpediaFrance(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void goTo() {
        driver.get("https://www.expedia.fr");
    }

    @Override
    public String getLogoText() {
        wait.until((d -> logoElement.isDisplayed()));
        return logoElement.getAttribute("src");
    }

    @Override
    public boolean isBookingOptionsPresent() {
        return false;
    }

    @Override
    public String getSubmitButtonText() {
        return null;
    }
}
