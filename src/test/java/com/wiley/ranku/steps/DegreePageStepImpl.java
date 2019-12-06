package com.wiley.ranku.steps;

import com.thoughtworks.gauge.Step;
import com.wiley.ranku.TestBase;
import com.wiley.ranku.datamodel.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertTrue;

public class DegreePageStepImpl extends TestBase {

    @Step("Validate number of degree programs")
    public void verifyNumberOfProgram() {
    }

    @Step("Click on Degree page RFI button")
    public void clickDegreePageRFIButton(){
        WebElement degreePageRFI = driver.findElement(By.xpath(siteData.getAppPages().getDegreePage().getXpath("requestInfor")));
        clickElement(degreePageRFI);
    }

    @Step("Select degree program and verify program page")
    public void navigateToProgramPage(){
        String programList = siteData.getAppPages().getDegreePage().getXpath("degreepageprogramlist");
        String specificProgramList = programList.replace("ProgramName",dataset.get("ProgramName")).replace("SchoolName",dataset.get("SchoolName"));
        WebElement programListItem = driver.findElement(By.xpath(specificProgramList));
        clickElement(programListItem);
        assertTrue(driver.getTitle().contains(dataset.get("ProgramName")));
    }

}
