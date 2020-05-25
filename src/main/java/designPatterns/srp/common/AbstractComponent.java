package designPatterns.srp.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractComponent {

    protected WebDriverWait wait;

    protected AbstractComponent(final WebDriver driver) {
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isDisplayed();
}
