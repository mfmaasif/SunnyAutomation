package com.wiley.ranku.steps;

import com.thoughtworks.gauge.Step;
import com.wiley.ranku.TestBase;
import com.wiley.ranku.datamodel.Degree;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class HomePageStepImpl extends TestBase {

//    protected static HashMap<String, String> dataset;

    @Step("Verify Home Page Header")
    public void verifyPageHeader() {
        WebElement headerTitle = driver.findElement(By.xpath(siteData.getAppPages().getHome().getXpath("title")));
        checkElementVisible(headerTitle);
    }

    @Step("Select degree type as <certificate>")
    public void selectDegreeLevel(String degreeLevel) {
        Select dropdown = new Select(driver.findElement(By.xpath(siteData.getAppPages().getHome().getXpath("degreeLevelFilter"))));
        dropdown.selectByValue(degreeLevel);
    }

    @Step("Enter Search text <Business>")
    public void enterSearchText(String text) {
        driver.findElement(By.xpath(siteData.getAppPages().getHome().getXpath("whatyouliketostudy"))).sendKeys(text);
    }

    @Step("Click Search button")
    public void clickSearch() {
        driver.findElement(By.xpath(siteData.getAppPages().getHome().getXpath("search"))).click();
    }

    @Step("Verify the font property in <World Class Education>")
    public void verifyfont(String text) {
        String expectedfontsize = siteData.getAppPages().getHome().getfontsize(text);
        String actualfontsize = driver.findElement(By.xpath(siteData.getAppPages().getHome().getXpath(text))).getCssValue("font-size");
        Assert.assertEquals(expectedfontsize, actualfontsize);
        System.out.println(expectedfontsize + " " + actualfontsize);

        String expectedfontfamily = siteData.getAppPages().getHome().getfontfamily(text);
        String actualfontfamily = driver.findElement(By.xpath(siteData.getAppPages().getHome().getXpath(text))).getCssValue("font-family");
        Assert.assertEquals(expectedfontfamily, actualfontfamily);
        System.out.println(expectedfontfamily + " " + actualfontfamily);

    }

    @Step("Verify the values in degree level drop down list")
    public void verifyDegreeLevels() {
        ArrayList<Degree> elements = siteData.getConfigurations().getDegrees();

        WebElement dgreelevel = driver.findElement(By.xpath(siteData.getAppPages().getHome().getXpath("degreeLevelFilter")));
        Select select = new Select(dgreelevel);

        List<WebElement> options = select.getOptions();

        for (WebElement we : options) {
            for (int i = 0; i < elements.size(); i++) {
                System.out.println(we.getText() + "  " + elements.get(i));
               // Assert.assertEquals(we.getText(), elements.get(i));
            }
        }

    }

    @Step("Get Datatable Value <tableName>")
    public void getDataTableValues(String tableName){
        getData(tableName);
    }

    @Step("Navigate to Degree page and verify")
    public void navigateToHomePage(){
        WebElement onlineDegrees = driver.findElement(By.xpath(siteData.getAppPages().getHome().getXpath("degreelink")));
        clickElement(onlineDegrees);
        assertTrue(driver.getTitle().contains(dataset.get("DegreePageTitle")));
    }
}
