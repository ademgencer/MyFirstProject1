package locators;

import org.openqa.selenium.By;

public interface LocatorsOpencart {
    //TODO kodlarinizi buraya yaziniz
    //OpenCart'a ait locator'lar bu interface'de olmali,

    By lOMyAccount = By.xpath("//span[text()='My Account']");
    By lORegister = By.linkText("Register");
    By lOInputFirstName = By.id("input-firstname");
    By lOInputClickLocator = By.xpath("//input[@name='agree']");
    By lOAccountValid =By.xpath("//div/h1[text()='Account']");
    By lOLogOut =By.xpath("//li//a[text()='Logout']");
    By lOLogIn =By.xpath("(//li//a[text()='Login'])[1]");
    By lOInputEmail =By.id("input-email");
    By lOLoginValid =By.xpath("//div//a[text()='Account']");
    By lOLogOutValid =By.xpath("//li//a[text()='Logout']");




    By xx = By.id("");
    /*
        locator'lar bu class'da olmali,
        class ya da interface olarak belirleyebilirsiniz. Tercih sizin
        By degiskenleri public static final olmali
        locatorlar Scenaryo class'larinda
            "import static locators.Locators.*;"
            ile import edilmeli
     */
}
