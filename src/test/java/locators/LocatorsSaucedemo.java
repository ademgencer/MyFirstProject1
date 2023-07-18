package locators;

import org.openqa.selenium.By;

public interface LocatorsSaucedemo {
    //TODO kodlarinizi buraya yaziniz
    //Saucedemo'ya ait locator'lar bu interface'de olmali,

    By lSUserName = By.id("user-name");
    By lSPassword = By.id("password");
    By lSLogin =By.id("login-button");
    By lSJacketValid =By.xpath("//div[text()='Sauce Labs Fleece Jacket']");
    By lSAddCart=By.id("add-to-cart-sauce-labs-fleece-jacket");
    By lSRemove=By.id("remove-sauce-labs-fleece-jacket");
    By lSSepet=By.className("shopping_cart_link");
    By lSCheckout=By.id("checkout");
    By lSFirstName=By.id("first-name");
    By lSLastName =By.id("last-name");
    By lSZipCode =By.id("postal-code");
    By lSContinue = By.id("continue");
    By lSPriceValid= By.className("inventory_item_price");
    By lSFinish=By.id("finish");
    By lSThankYouForOrder=By.className("complete-header");


    By xx = By.id("");
    By yy = By.id("");
}
