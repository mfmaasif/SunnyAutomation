package com.wiley.ranku.steps;

import com.thoughtworks.gauge.Step;
import com.wiley.ranku.TestBase;
import com.wiley.ranku.datamodel.Element;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SignUpStepImpl extends TestBase {

    @Step("Click on Sign-Up button")
    public void clcikOnSignUp() {
        driver.findElement(By.xpath(siteData.getAppPages().getHome().getXpath("signup"))).click();
    }

    @Step("Validate all label names in Sign-Up form are correctly displayed")
    public void ValidateSignUpFields() throws InterruptedException {
        ArrayList<Element> elements = siteData.getAppPages().getSignUp().getElements();

        freeze(5);

        for (Element e : elements) {
            String label = e.getLabel();
            if (label != null) {
                String legend = driver.findElement(By.xpath(e.getXpath())).findElement(By.xpath(siteData.getAppPages().getSignUp().getXpath("fieldLabel"))).getText();
                Assert.assertEquals(label, legend);
            }
        }
    }

    @Step("Validate Privacy link")
    public void validatePrivacyLink() throws InterruptedException {
        driver.findElement(By.xpath(siteData.getAppPages().getSignUp().getXpath("privacylink"))).click();

        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        String titlePrivacyPolicy = driver.switchTo().window(browserTabs.get(1)).getTitle();

        Assert.assertEquals("NIU Privacy Policy", titlePrivacyPolicy);


        driver.switchTo().window(browserTabs.get(0));
        freeze(5);
    }

    @Step("Validate Terms link")
    public void implementation1() {
        driver.findElement(By.xpath(siteData.getAppPages().getSignUp().getXpath("termsconditions"))).click();

        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        String titleTerms = driver.switchTo().window(browserTabs.get(2)).getTitle();

        Assert.assertEquals("Text Messaging (SMS) Terms and Conditions", titleTerms);
    }

    @Step("Fill the Sign Up form")
    public void FillSignUpForm() throws InterruptedException {
        ArrayList<Element> elements = siteData.getAppPages().getSignUp().getElements();

        for (Element e : elements) {
            String label = e.getLabel();

            if (label != null) {
                driver.findElement(By.xpath(e.getXpath())).sendKeys(e.getData());
            }
        }
        freeze(5);

        driver.findElement(By.xpath(siteData.getAppPages().getSignUp().getXpath("createAccount"))).click();

        freeze(5);

    }

    @Step("Validate Logged In header is correctly displayed")
    public void validateLoggedInHeader() {
        String header = driver.findElement(By.xpath(siteData.getAppPages().getHome().getXpath("headergreeting"))).getText();
        freeze(5);
        Assert.assertEquals("WELCOME BACK, ", header);
    }
    @Step("Logout")
    public void logout() {
        driver.findElement(By.xpath(siteData.getAppPages().getHome().getXpath("headerusername"))).click();

        driver.findElement(By.xpath(siteData.getAppPages().getHome().getXpath("logout"))).click();
    }

    @Step("Validate the error message")
    public void validateError() throws InterruptedException {
        String error = driver.findElement(By.xpath(siteData.getAppPages().getSignUp().getXpath("email"))).findElement(By.xpath(siteData.getAppPages().getSignUp().getXpath("validationerror"))).getText();
        //freeze(5);
        Assert.assertEquals("Account exists. Please login or choose another address.", error);
    }

}
