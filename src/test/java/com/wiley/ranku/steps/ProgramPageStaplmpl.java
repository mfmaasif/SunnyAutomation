package com.wiley.ranku.steps;

import com.thoughtworks.gauge.Step;
import com.wiley.ranku.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProgramPageStaplmpl extends TestBase {
    @Step("Click on RFI button on program page")
    public void clickOnRFIOnProgramPage(){
        WebElement ProgramRFIButton = driver.findElement(By.xpath(siteData.getAppPages().getProgramPage().getXpath("requestInfor")));
        clickElement(ProgramRFIButton);
        freeze(5);
    }
}
