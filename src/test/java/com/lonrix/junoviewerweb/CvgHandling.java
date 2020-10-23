package com.lonrix.junoviewerweb;

import com.lonrix.common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CvgHandling extends TestBase {

    @BeforeMethod
    public void loginToJunoViewer() {
        getWebDriver().get(getJunoViewerWebBaseUrl());
        getWebDriver().findElement(By.id("txtUserName")).sendKeys("Jaspal");
        getWebDriver().findElement(By.id("txtPassword")).sendKeys("$#lnx1Jaspal@");
        getWebDriver().findElement(By.id("btnSubmit")).click();
    }

    @Test
    public void verifyContentInCellsForNetworkA_LwpIri_DisplayedCellsOnly() throws InterruptedException {
        System.out.println("Test: verifyContentInCellsForNetworkA_LwpIri_DisplayedCellsOnly");
        getWebDriver().findElement(By.xpath("//a[text()='Views ']")).click();
        getWebDriver().findElement(By.linkText("Strip Map View")).click();
        Thread.sleep(500);
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(By.id("btnGetDataScope"))).click();
        getSelect(getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("lstNetworkNames"))))
                .selectByVisibleText("Network A");
        getSelect(getWebDriver().findElement(By.id("lstSubSection"))).selectByVisibleText("103");
        getWebDriver().findElement(By.id("btnDoDataScopeChange")).click();

        String [] expectedLwpIriCellText = {"3.77", "4.24", "3.87", "5.86", "3.00", "4.54", "3.85", "5.75", "4.65", "3.53", "4.55", "5.43", "6.79", "6.77", "4.88", "4.93", "5.32", "3.86", "4.12", "3.18"};
        String [] expectedLwpIriCellColor = {"rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)"};

        SoftAssert softAssert = new SoftAssert();
        for(int i=0; i<expectedLwpIriCellText.length; i++) {
            WebElement cellTextElement = getWebDriver().findElement(By.xpath("(//*[@id='singleStripData_2']//*[text()])[" + (i+1) + "]"));
            WebElement cellColorElement = getWebDriver().findElement(By.xpath("(//*[@id='singleStripData_2']//*[@fill and @stroke])[" + (i+1) + "]"));
            System.out.println("Column " + (i+1) + " -> Actual Cell Text: " + cellTextElement.getText() + " | Actual Cell Color: " + cellColorElement.getAttribute("fill"));
            softAssert.assertEquals(cellTextElement.getText(), expectedLwpIriCellText[i]);
            softAssert.assertEquals(cellColorElement.getAttribute("fill"), expectedLwpIriCellColor[i]);
        }
        softAssert.assertAll();
    }

    @Test
    public void verifyContentInCellsForNetworkA_LwpMeanRut_DisplayedCellsOnly() throws InterruptedException {
        System.out.println("Test: verifyContentInCellsForNetworkA_LwpMeanRut_DisplayedCellsOnly");
        getWebDriver().findElement(By.xpath("//a[text()='Views ']")).click();
        getWebDriver().findElement(By.linkText("Strip Map View")).click();
        Thread.sleep(500);
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(By.id("btnGetDataScope"))).click();
        getSelect(getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("lstNetworkNames"))))
                .selectByVisibleText("Network A");
        getSelect(getWebDriver().findElement(By.id("lstSubSection"))).selectByVisibleText("103");
        getWebDriver().findElement(By.id("btnDoDataScopeChange")).click();

        String [] expectedLwpMeanRutCellText = {"9.3", "19.1", "10.6", "11.4", "5.0", "11.3", "7.1", "8.1", "7.9", "6.5", "12.7", "8.1", "8.7", "8.5", "6.0", "10.9", "10.4", "7.3", "11.8", "12.2"};
        String [] expectedLwpMeanRutCellColor = {"rgb(255, 255, 0)", "rgb(0, 128, 0)", "rgb(255, 255, 0)", "rgb(255, 255, 0)", "rgb(255, 165, 0)", "rgb(255, 255, 0)", "rgb(255, 165, 0)", "rgb(255, 255, 0)", "rgb(255, 165, 0)", "rgb(255, 165, 0)", "rgb(154, 205, 50)", "rgb(255, 255, 0)", "rgb(255, 255, 0)", "rgb(255, 255, 0)", "rgb(255, 165, 0)", "rgb(255, 255, 0)", "rgb(255, 255, 0)", "rgb(255, 165, 0)", "rgb(255, 255, 0)", "rgb(154, 205, 50)"};

        SoftAssert softAssert = new SoftAssert();
        for(int i=0; i<expectedLwpMeanRutCellText.length; i++) {
            WebElement cellTextElement = getWebDriver().findElement(By.xpath("(//*[@id='singleStripData_1']//*[text()])[" + (i+1) + "]"));
            WebElement cellColorElement = getWebDriver().findElement(By.xpath("(//*[@id='singleStripData_1']//*[@fill and @stroke])[" + (i+1) + "]"));
            System.out.println("Column " + (i+1) + " -> Actual Cell Text: " + cellTextElement.getText() + " | Actual Cell Color: " + cellColorElement.getAttribute("fill"));
            softAssert.assertEquals(cellTextElement.getText(), expectedLwpMeanRutCellText[i]);
            softAssert.assertEquals(cellColorElement.getAttribute("fill"), expectedLwpMeanRutCellColor[i]);
        }
        softAssert.assertAll();
    }

    @Test
    public void verifyContentInCellsForNetworkA_SurfacingCode_DisplayedCellsOnly() throws InterruptedException {
        System.out.println("Test: verifyContentInCellsForNetworkA_SurfacingCode_DisplayedCellsOnly");
        getWebDriver().findElement(By.xpath("//a[text()='Views ']")).click();
        getWebDriver().findElement(By.linkText("Strip Map View")).click();
        Thread.sleep(500);
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(By.id("btnGetDataScope"))).click();
        getSelect(getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("lstNetworkNames"))))
                .selectByVisibleText("Network A");
        getSelect(getWebDriver().findElement(By.id("lstSubSection"))).selectByVisibleText("103");
        getWebDriver().findElement(By.id("btnDoDataScopeChange")).click();

        String [] expectedSurfacingCodeCellText = {"2CHIP", "2CHIP", "2CHIP", "2CHIP", "2CHIP", "2CHIP", "1CHIP", "2CHIP"};
        String [] expectedSurfacingCodeCellColor = {"white", "white", "white", "white", "white", "white", "white", "white"};

        SoftAssert softAssert = new SoftAssert();
        for(int i=0; i<expectedSurfacingCodeCellText.length; i++) {
            WebElement cellTextElement = getWebDriver().findElement(By.xpath("(//*[@id='singleStripData_0']//*[text()])[" + (i+1) + "]"));
            WebElement cellColorElement = getWebDriver().findElement(By.xpath("(//*[@id='singleStripData_0']//*[@fill and @stroke='Black'])[" + (i+1) + "]"));
            System.out.println("Column " + (i+1) + " -> Actual Cell Text: " + cellTextElement.getText() + " | Actual Cell Color: " + cellColorElement.getAttribute("fill"));
            softAssert.assertEquals(cellTextElement.getText(), expectedSurfacingCodeCellText[i]);
            softAssert.assertEquals(cellColorElement.getAttribute("fill"), expectedSurfacingCodeCellColor[i]);
        }
        softAssert.assertAll();
    }

    @Test
    public void verifyContentInCellsForNetworkA_Accidents_DisplayedCellsOnly() throws InterruptedException {
        System.out.println("Test: verifyContentInCellsForNetworkA_Accidents_DisplayedCellsOnly");
        getWebDriver().findElement(By.xpath("//a[text()='Views ']")).click();
        getWebDriver().findElement(By.linkText("Strip Map View")).click();
        Thread.sleep(500);
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(By.id("btnGetDataScope"))).click();
        getSelect(getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("lstNetworkNames"))))
                .selectByVisibleText("Network A");
        getSelect(getWebDriver().findElement(By.id("lstSubSection"))).selectByVisibleText("103");
        getWebDriver().findElement(By.id("btnDoDataScopeChange")).click();

        String [] expectedAccidentsCellText = {"1", "1", "1", "4", "1", "1", "1", "1"};
        String [] expectedAccidentsCellColor = {"LightBlue", "LightBlue", "LightBlue", "LightBlue", "LightBlue", "LightBlue", "LightBlue", "LightBlue"};

        SoftAssert softAssert = new SoftAssert();
        for(int i=0; i<expectedAccidentsCellText.length; i++) {
            WebElement cellTextElement = getWebDriver().findElement(By.xpath("(//*[@id='singleStripData_3']//*[text()])[" + (i+1) + "]"));
            WebElement cellColorElement = getWebDriver().findElement(By.xpath("(//*[@id='singleStripData_3']//*[@fill and @stroke])[" + (i+1) + "]"));
            System.out.println("Column " + (i+1) + " -> Actual Cell Text: " + cellTextElement.getText() + " | Actual Cell Color: " + cellColorElement.getAttribute("fill"));
            softAssert.assertEquals(cellTextElement.getText(), expectedAccidentsCellText[i]);
            softAssert.assertEquals(cellColorElement.getAttribute("fill"), expectedAccidentsCellColor[i]);
        }
        softAssert.assertAll();
    }

    @Test
    public void verifyContentInCellsForNetworkA_LwpIri_WithJavascript() throws InterruptedException {
        System.out.println("Test: verifyContentInCellsForNetworkA_LwpIri_WithJavascript");
        getWebDriver().findElement(By.xpath("//a[text()='Views ']")).click();
        getWebDriver().findElement(By.linkText("Strip Map View")).click();
        Thread.sleep(500);
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(By.id("btnGetDataScope"))).click();
        getSelect(getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("lstNetworkNames"))))
                .selectByVisibleText("Network A");
        getSelect(getWebDriver().findElement(By.id("lstSubSection"))).selectByVisibleText("103");
        getWebDriver().findElement(By.id("btnDoDataScopeChange")).click();

        String [] expectedLwpIriCellText = {"3.77", "4.24", "3.87", "5.86", "3.00", "4.54", "3.85", "5.75", "4.65", "3.53", "4.55", "5.43", "6.79", "6.77", "4.88", "4.93", "5.32", "3.86", "4.12", "3.18",
                "4.13", "3.90", "4.01", "3.84", "3.36", "3.32", "6.26", "3.92", "3.87", "6.82", "5.64", "3.71", "6.95", "4.43", "6.43", "2.82", "3.57", "3.17", "3.14", "3.57"};
        String [] expectedLwpIriCellColor = {"rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)",
                "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)", "rgb(0, 128, 0)"};

        SoftAssert softAssert = new SoftAssert();
        for(int i=0; i<expectedLwpIriCellText.length; i++) {
            WebElement cellTextElement = getWebDriver().findElement(By.xpath("(//*[@id='singleStripData_2']//*[text()])[" + (i+1) + "]"));
            WebElement cellColorElement = getWebDriver().findElement(By.xpath("(//*[@id='singleStripData_2']//*[@fill and @stroke])[" + (i+1) + "]"));
            String cellText = (String) getJavascriptExecutor().executeScript("return arguments[0].innerHTML;",cellTextElement);
            String cellColor = (String) getJavascriptExecutor().executeScript("return arguments[0].getAttribute('fill');",cellColorElement);
            System.out.println("Column " + (i+1) + " -> Actual Cell Text: " + cellText + " | Actual Cell Color: " + cellColor);
            softAssert.assertEquals(cellText, expectedLwpIriCellText[i]);
            softAssert.assertEquals(cellColor, expectedLwpIriCellColor[i]);
        }
        softAssert.assertAll();
    }

    @Test
    public void verifyContentInNaasraForNetworkA() throws InterruptedException {
        System.out.println("Test: verifyContentInCellsForNetworkA_LwpIri_WithJavascript");
        getWebDriver().findElement(By.xpath("//a[text()='Views ']")).click();
        getWebDriver().findElement(By.linkText("Strip Map View")).click();
        Thread.sleep(500);
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(By.id("btnGetDataScope"))).click();
        getSelect(getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("lstNetworkNames"))))
                .selectByVisibleText("Network A");
        getSelect(getWebDriver().findElement(By.id("lstSubSection"))).selectByVisibleText("103");
        getWebDriver().findElement(By.id("btnDoDataScopeChange")).click();

        String [] expectedNaasraTextInRow1 = {"65.0", "62.0", "64.0", "66.0", "67.0", "66.0", "67.0", "68.0", "69.0", "72.0"};
        String [] expectedNaasraTextInRow2 = {"42.0", "42.0", "43.0", "47.0", "46.0", "45.0", "45.0", "45.0", "46.0", "47.0"};

        SoftAssert softAssert = new SoftAssert();
        for(int i=0; i<expectedNaasraTextInRow1.length; i++) {
            WebElement row1TextElement = getWebDriver().findElement(By.xpath("(//*[@id='pnl1_highLow_" + i + "HLBar']//*[text()])[1]"));
            System.out.println("Row 1 -> Actual Column " + (i+1) + " Text: " + row1TextElement.getText());
            softAssert.assertEquals(row1TextElement.getText(), expectedNaasraTextInRow1[i]);
        }
        for(int i=0; i<expectedNaasraTextInRow2.length; i++) {
            WebElement row2TextElement = getWebDriver().findElement(By.xpath("(//*[@id='pnl1_highLow_" + i + "HLBar']//*[text()])[2]"));
            System.out.println("Row 2 -> Actual Column " + (i+1) + " Text: " + row2TextElement.getText());
            softAssert.assertEquals(row2TextElement.getText(), expectedNaasraTextInRow2[i]);
        }
        softAssert.assertAll();
    }

}
