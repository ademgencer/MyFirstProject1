package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private static WebDriver driver;

    /**
     * bu method overload methodu kullanarak default chrome driver return etmeli
     *
     * @return webdriver return etmeli
     */
    public WebDriver getDriver() {// ideal olan üstteki overload metottan alttaki parametreli overload metodu çağırmaktır.
        //TODO yapıldı.
        return getDriver("chrome");
    }

    /**
     * browser parametresi ile gelen driver'i create etmeli
     *
     * @param browser chrome, firefox, edge, ... olmali
     * @return webdriver return etmeli
     */
    public WebDriver getDriver(String browser) {
        //TODO yapıldı.

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
        return driver;
    }

    /**
     * driver'i quit eden method
     */
    public void quitDriver() {
        //TODO yapıldı.
        driver.quit();
    }
}
