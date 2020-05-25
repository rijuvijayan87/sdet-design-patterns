package designPatterns.srp.main;

import designPatterns.srp.common.SearchSuggestion;
import designPatterns.srp.common.SearchWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage {

    private WebDriver driver;
    private SearchWidget searchWidget;
    private SearchSuggestion searchSuggestion;

    public GoogleMainPage(final WebDriver driver) {
        this.driver = driver;
        this.searchSuggestion = PageFactory.initElements(this.driver, SearchSuggestion.class);
        this.searchWidget = PageFactory.initElements(this.driver, SearchWidget.class);
    }

    public void goTo() {
        this.driver.get("https://www.google.com");
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }
}
