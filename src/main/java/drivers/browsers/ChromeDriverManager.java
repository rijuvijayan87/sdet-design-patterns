package drivers.browsers;

import drivers.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {

    @Override
    protected void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


}
