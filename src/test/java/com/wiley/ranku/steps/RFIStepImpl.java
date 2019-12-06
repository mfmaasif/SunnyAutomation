package com.wiley.ranku.steps;

import com.thoughtworks.gauge.Step;
import com.wiley.ranku.TestBase;
import com.wiley.ranku.datamodel.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class RFIStepImpl extends TestBase {

//    public static HashMap<String, String> dataset;

    @Step("Click on RFI button")
    public void clickonRequestInformationButton() {
        WebElement rfi = driver.findElement(By.xpath(siteData.getAppPages().getHome().getXpath("requestInfo")));
        clickElement(rfi);
    }

    @Step("Fill the RFI form")
    public void fillRFIForm() throws InterruptedException {

//        dataset = testData.getDataSetById(testcaseID);

        ArrayList<Element> elements = siteData.getAppPages().getRfi().getElements();

        getUniqueEmailAddress(dataset.get("emailAddress"));

        for (Element e : elements) {
            String fieldname = e.getName();
            String testdata = dataset.get(fieldname);

            if (isElementPresent(By.xpath(e.getXpath())) && e.getType() != null) {
                WebElement element = driver.findElement(By.xpath(e.getXpath()));
                String type = e.getType();

                switch (type) {
                    case "dropdown":
                        if (testdata != null) {
                            selectDropDownList(element, testdata);
                            Thread.sleep(1000);
                        }
                        break;
                    case "textbox":
                        if (testdata != null) {
                            setTextAs(element, testdata);
                            Thread.sleep(1000);
                        }
                        break;
                    case "checkbox":
                        if (Boolean.parseBoolean(testdata) != false) {
                            selectCheckBox(element);
                            Thread.sleep(1000);
                        }
                        break;
                }
            }
        }
        //driver.findElement(By.xpath((siteData.getAppPages().getRfi().getXpath("submitRequest")))).click();
        clickElement(driver.findElement(By.xpath((siteData.getAppPages().getRfi().getXpath("submitRequest")))));
        Thread.sleep(2000);
    }

    @Step("Verify Request Information Submitted")
    public void verifyRequestInformationSubmited() {
        WebElement thankYou = driver.findElement(By.xpath(siteData.getAppPages().getRfi().getXpath("thankYou")));
        checkElementVisible(thankYou);
        WebElement closeRFIThankYou = driver.findElement(By.xpath(siteData.getAppPages().getRfi().getXpath("closeThankYou")));
        clickElement(closeRFIThankYou);
    }

    @Step("Select Additional programs")
    public void selectPrograms() {
        switch (System.getenv("site")){
            case "sunny" :
                break;
            default:
                String additionlProgramPath = siteData.getAppPages().getRfi().getXpath("additionalProgram");
                String additionlProgramCount[] = dataset.get("additionalProgram").split(",");
                for (int i=0; i < additionlProgramCount.length; i++){
                    String additionlProgram = additionlProgramPath.replace("onClickSubmitProgram",additionlProgramCount[i]);
                    WebElement additionlProgramList = driver.findElement(By.xpath(additionlProgram));
                    selectCheckBox(additionlProgramList);
                    clickElement(driver.findElement(By.xpath(siteData.getAppPages().getRfi().getXpath("sendInformation"))));
                }
        }
    }

    @Step("No Additional Programs Selected")
    public void NoAdditionalProgram() {
        try {
            clickElement(driver.findElement(By.xpath(siteData.getAppPages().getRfi().getXpath("additionalprogramthankyou"))));
        }catch (NoSuchElementException e){
            System.out.println(e);
        }
    }

    public void getUniqueEmailAddress (String initialEmail){
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmss");
        String datetime = ft.format(dNow);
        String fullName = initialEmail + datetime+"@test.com";
        dataset.put("emailAddress",fullName);
    }


}
