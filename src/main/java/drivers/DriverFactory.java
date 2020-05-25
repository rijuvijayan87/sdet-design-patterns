package drivers;

import drivers.browsers.Browsers;
import drivers.browsers.ChromeDriverManager;
import drivers.browsers.FireFoxDriverManager;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private DriverManager CHR = new ChromeDriverManager();
    private DriverManager FF = new FireFoxDriverManager();
    private Map<Browsers, DriverManager> browserObjects = new HashMap<>();

    private void addBrowsers() {
        browserObjects.put(Browsers.CHROME, CHR);
        browserObjects.put(Browsers.FIREFOX, FF);
    }

    public DriverManager getDriverManager(Browsers browser) {
        addBrowsers();
        return browserObjects.get(browser);
    }
}
