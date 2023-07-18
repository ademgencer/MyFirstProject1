package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BaseTest {
    /*
        driver ve wait field'lari.
        BaseTest class'ini extent eden child class'lar icinde de kullanilacak
     */
    protected WebDriver driver;
    protected WebDriverWait wait;


    /**
     * bu method aldigi url ile alttaki overload methodu kullanir
     * title icin "" gönderin
     *
     * @param url gidilecek url
     */
    protected void open(String url) {
        open(url, "");

    }


    /**
     * bu method aldigi url'e driver.get methodu ile gider
     * title'in uzunlugu >0 ise title'i contain ettigini assert eder
     *
     * @param url   gidilecek url
     * @param title sayfanin assert edilecek beklenen title'i
     */
    protected void open(String url, String title) {
        //TODO yapıldı
        driver.get(url);
        if (driver.getTitle().length() > 0) {
            Assert.assertTrue(url.contains(title));
        }
    }


    /**
     * aldigi locator'i elemente cevirip click icin alttaki overload methoda gönderir
     *
     * @param locator element locatori
     */
    protected void click(By locator) {
        //TODO yapıldı
        WebElement element = driver.findElement(locator);
        click(element);
    }


    /**
     * aldigi elemente click eder
     *
     * @param element element
     */
    protected void click(WebElement element) {
        //TODO yapıldı.
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }


    /**
     * aldigi locator'i elemente cevirip sendkey icin alttaki overload methoda gönderir
     *
     * @param locator locator
     * @param text    send edilecek text
     */
    protected void sendkeys(By locator, String text) {
        //TODO bitti.
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        sendkeys(element, text);
    }


    /**
     * aldigi element'e text'i send eder. .clear() da yapmali
     *
     * @param element WebElement
     * @param text    send edilecek text
     */
    protected void sendkeys(WebElement element, String text) {
        //TODO bitti.
        WebElement element1 = wait.until(ExpectedConditions.visibilityOf(element));
        element1.clear();
        element1.sendKeys(text);
    }


    /**
     * @param locator locator
     */
    protected void scrollIntoView(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        scrollIntoView(element);
        //TODO bitti.
    }


    /**
     * aldigi elemente kadar scrollIntoView ile scroll eder
     *
     * @param element element
     */
    protected void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
        //TODO yapıldı.
    }


    /**
     * aldigi y pixel kadar asagi scroll yapar
     *
     * @param y pixel kadar asagi kaydirilir
     */
    protected void scrollBy(int y) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("(window.scrollBy(0," + y + "));");
        //TODO bitti.
    }

    public void bekle() {
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
