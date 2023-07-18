package locators;

import org.openqa.selenium.By;

public interface LocatorsDemoqa {
    //TODO kodlarinizi buraya yaziniz
    //Demoqa'e ait locator'lar bu interface'de olmali,

    By lDAdd = By.id("addNewRecordButton");
    By lDFirstName = By.xpath("//div/input[@id='firstName']");
    By lDSubmitAssert =By.xpath("//div[text()='adem@adem.com']");
    By lDEdit = By.cssSelector(".action-buttons #edit-record-4");
    By lDLastName =By.cssSelector("#lastName");
    By lDSubmit =By.id("submit");
    By lDLastNameAssert =By.xpath("//div[text()='gencer']");
    By lDDelete =By.cssSelector(".action-buttons #delete-record-4");



    By xx = By.id("");
    By yy = By.id("");
}
