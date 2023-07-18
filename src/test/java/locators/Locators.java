package locators;

public interface Locators extends LocatorsSaucedemo, LocatorsOpencart, LocatorsDemoqa {

    /*
        Locator interface'i
        LocatorsSaucedemo, LocatorsOpencart ve LocatorsDemoqa interface'lerini
        extend eder ki her ücünde tanimlanmis degiskenleri
        kendi bünyesine alabilsin diye

        Scenarios class'i icinde importlar kisminda
        import static locators.Locators.*;
        ile import edilmeli.

        Bu interface'de herhangi bir degisiklige gerek yoktur.
     */
}
