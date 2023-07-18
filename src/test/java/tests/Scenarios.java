package tests;

import base.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static locators.Locators.*;

public class Scenarios extends BaseTest {
    //TODO kodlarinizi buraya yaziniz

    /*
        BaseTest classini extend etmeli, +
        BaseTest icindeki fields (variables) ve attribute'lar (methodlar) kullanilmali
        constructorunda driver ve wait tanimlanmali +
        scenariolar asagidaki methodlar icine yazilmali
     */
    public Scenarios() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }


    @Test
    public void Scenario1Saucedemo() {
        //Sceanrio-1
        //1.  https://www.saucedemo.com/  sayfasina gidin
        open("https://www.saucedemo.com/");

        //2.  standard_user ile login olun
        click(lSUserName);
        sendkeys(lSUserName, "standard_user");
        click(lSPassword);
        sendkeys(lSPassword, "secret_sauce");
        click(lSLogin);

        //3.  listelenen ürünlerden random olarak bir tanesini secin  ---> Random seçme işlemi nasıl olacak ?
        WebElement sauceJacketElement = driver.findElement(lSJacketValid);

        //4.  secilen ürünün adini ve fiyatini iki degiskene store edin  ---> isim ve fiyat almayı metotla mı yapıyoruz?
        String sauceExpJacketAd = "Sauce Labs Fleece Jacket";
        String sauceExpJacketFiyat = "49.99";

        //5.  ürün linkine (resim ya da isim) tiklayin
        click(sauceJacketElement);

        //6.  tiklanilan ürünün acildigini ismi ile assert edin.
        wait.until(ExpectedConditions.textToBe(lSJacketValid, sauceExpJacketAd));

        //7.  "ADD TO CART"'a tiklayin ve o locatorin textinin da "REMOVE" oldugunu assert edin
        click(lSAddCart);
        wait.until(ExpectedConditions.textToBe(lSRemove, "REMOVE"));

        //8.  sag üstte bulunan cart (sepet) linkine tiklayin ve cart acilsin
        click(lSSepet);

        //9.  ürünün sepette oldugunu ve fiyatinin dogru oldu oldugunu assert edin  ---> fiyat assert edilecek!!!!
        wait.until(ExpectedConditions.textToBe(lSJacketValid, sauceExpJacketAd));
        Assert.assertTrue(driver.findElement(lSPriceValid).getText().contains(sauceExpJacketFiyat));// başka yolu var mı ?

        //10. "CHECKOUT" a tiklayin
        click(lSCheckout);

        //11. formda istenilen bilgileri girin ve "CONTINUE" tiklayin
        sendkeys(lSFirstName, "adem");
        sendkeys(lSLastName, "yasar");
        sendkeys(lSZipCode, "35000");
        click(lSContinue);


        //12. Burada da isim ve fiyat kontrolü yapin ve "FINISH" e tiklayin
        wait.until(ExpectedConditions.textToBe(lSJacketValid, sauceExpJacketAd));
        Assert.assertTrue(driver.findElement(lSPriceValid).getText().contains(sauceExpJacketFiyat));// başka yolu var mı ?
        click(lSFinish);

        //13. "THANK YOU FOR YOUR ORDER" yazisinin göründügünü assert edin
        wait.until(ExpectedConditions.visibilityOfElementLocated(lSThankYouForOrder));

        driver.quit();


    }

    @Test
    public void Scenario2Opencart() {

        // NOT: click metodu zaten wait ile yazıldığı için, tekrardan wait ile yazıp click etmeye gerek yok
        // Aşağıda yazdıklarını yorum satırına alarak deneyebilirsin.
        // Aşağıdaki locatorlar opencart interface inde tanımlanacak, bunları düzenle.

        //Scenario-2

        //1.  http://opencart.abstracta.us/ sayfasina gidin
        open("http://opencart.abstracta.us/");
        //driver.get("http://opencart.abstracta.us/");

        //2.  Menüde MyAccount'a tiklayin
        //wait.until(ExpectedConditions.elementToBeClickable(lMyAccount));
        click(lOMyAccount);

        //3.  Popup'in acilmasini bekleyin ve Register'a tiklayin
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Register")));
        click(lORegister);

        //4.  Register formun tüm alanlari doldurun ve "Continue" butonuna tiklayin
        //    Bilgiler Fake olabilir.
        Actions actions = new Actions(driver);
        WebElement firstNameElement = driver.findElement(lOInputFirstName);
        actions.click(firstNameElement)
                .sendKeys("adem")
                .sendKeys(Keys.TAB)
                .sendKeys("yaşar")
                .sendKeys(Keys.TAB)
                .sendKeys("qwert@adem.com")// Her seferinde değiştir
                .sendKeys(Keys.TAB)
                .sendKeys("05889632147")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .perform();// action ile click yapamadığım için clicki normal şekilde yaptım.
        click(lOInputClickLocator);
        actions
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        //5.  Account'un create edildigini dogrulayin.
        wait.until(ExpectedConditions.visibilityOfElementLocated(lOAccountValid));

        // Logout yapalım:
        click(lOMyAccount);
        click(lOLogOut);


        //6.  MyAccount linkinden Login'e tiklayin
        click(lOMyAccount);
        click(lOLogIn);


        //7.  Login bilgilerini girin ve login olun
        click(lOInputEmail);
        actions.sendKeys("qwer@adem.com")// her seferinde değiştir
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();


        //8.  login oldugunuzu dogrulayin
        wait.until(ExpectedConditions.visibilityOfElementLocated(lOLoginValid));


        //9.  MyAccount linkinden logout olun
        click(lOMyAccount);
        click(lOLogOut);

        //10. Logout oldugunuzu onaylayin
        wait.until(ExpectedConditions.visibilityOfElementLocated(lOLogOutValid));

        driver.quit();

    }


    @Test
    public void Scenario3Demoqa() {
        //Scenario-3

        //1.  https://demoqa.com/webtables sayfasina gidin
        String url = "https://demoqa.com/webtables";
        open(url);


        //2.  "Add" butonuna tiklayin
        click(lDAdd);


        //3.  "Registration Form" dialogundaki bilgileri doldurun
        //4.  "Submit" edin
        WebElement eFirstName = driver.findElement(lDFirstName);

        wait.until(ExpectedConditions.elementToBeClickable(lDFirstName));

        Actions action = new Actions(driver);
        action.click(eFirstName)
                .sendKeys("adem")
                .sendKeys(Keys.TAB)
                .sendKeys("yasar")
                .sendKeys(Keys.TAB)
                .sendKeys("adem@adem.com")
                .sendKeys(Keys.TAB)
                .sendKeys("42")
                .sendKeys(Keys.TAB)
                .sendKeys("30000")
                .sendKeys(Keys.TAB)
                .sendKeys("QA")
                .sendKeys(Keys.ENTER)
                .perform();

        //5.  Kaydinizin tabloda listelendigini assert edin
        //System.out.println(driver.findElement(lSubmitAssert).getText());
        Assert.assertEquals(driver.findElement(lDSubmitAssert).getText(),"adem@adem.com");


        //6.  Kaydinizi edit edin
        click(lDEdit);


        //7.  Last name'i degistirin
        sendkeys(lDLastName,"gencer");


        //8.  Submit edin
        click(lDSubmit);


        //10. Degisen lastname'in tabloda oldugunu dogrulayin
        WebElement eLastNameAssert= driver.findElement(lDLastNameAssert);
        wait.until(ExpectedConditions.textToBe(lDLastNameAssert,"gencer"));// Doğru metot mu?
        wait.until(ExpectedConditions.textToBePresentInElement(eLastNameAssert,"gencer"));// Doğru metot mu?


        //11. Girdiginiz kaydi silin
        WebElement eDeleteAssert= driver.findElement(lDDelete);
        click(lDDelete);


        //12. silindigini dogrulayin
        // nasıl ?


        driver.quit();

    }




}
