package designPatterns.factory.countries.Netherlands;

import designPatterns.factory.Expedia;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ExpediaNetherlands implements Expedia {

    @FindBy(css = "#header-logo > img")
    private WebElement logoElement;
    @FindBy(css = "#wizard-tabs > div.tabs-wrapper.wizard-tabs-slider > ul li")
    private List<WebElement> bookingOptions;
    @FindBy(css = "#gcw-hotel-form-hp-hotel > div.cols-nested.ab25184-submit > label > button")
    private WebElement submitButton;

    private WebDriver driver;
    private WebDriverWait wait;

    public ExpediaNetherlands(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void goTo() {
        driver.get("https://www.expedia.nl/");
    }

    @Override
    public String getLogoText() {
        wait.until((d -> logoElement.isDisplayed()));
        return logoElement.getAttribute("alt");
    }

    @Override
    public boolean isBookingOptionsPresent() {
        wait.until(driver1 -> bookingOptions.get(0).isDisplayed());
        return bookingOptions.get(0).isDisplayed();
    }

    @Override
    public String getSubmitButtonText() {
        wait.until(d -> submitButton.isDisplayed());
        return submitButton.getText();
    }

}
