package ru.selenium.courses;

import org.junit.Assert;
import org.junit.Test;

public class CorrectProductPage extends SetUp {
    @Test
    public void TestCountryList() {
        driver.get("http://localhost/litecart/en/");

        //Внешняя страница товара
        String nameMain = driver.findElementByXPath("//div[@id='box-campaigns']//div[@class='name']").getText();
        String getSalePriceMain = driver.findElementByXPath("//div[@id='box-campaigns']//strong[@class='campaign-price']").getText();
        String getFixPriceMain = driver.findElementByXPath("//div[@id='box-campaigns']//s[@class='regular-price']").getText();

        String getFixPriceMainColor = driver.findElementByCssSelector(".regular-price").getCssValue("color");
        boolean checkFixPriceMainColorS = driver.findElementByCssSelector(".regular-price").getTagName().equals("s");
        String getFontFixPriceMain = driver.findElementByCssSelector(".regular-price").getCssValue("font-size");
        Assert.assertEquals(getFixPriceMainColor, "rgba(119, 119, 119, 1)");
        Assert.assertTrue(checkFixPriceMainColorS);

        String getSalePriceMainColor = driver.findElementByCssSelector(".campaign-price").getCssValue("color");
        String getFontSalePriceMain = driver.findElementByCssSelector(".campaign-price").getCssValue("font-size");
        boolean checkSalePriceMainColorS = driver.findElementByCssSelector(".campaign-price").getTagName().equals("strong");
        Assert.assertEquals(getSalePriceMainColor, "rgba(204, 0, 0, 1)");
        Assert.assertTrue(checkSalePriceMainColorS);
        Assert.assertTrue(getFontFixPriceMain.compareTo(getFontSalePriceMain) < 0);

        //Внутренняя страница товара
        driver.findElementByXPath("//div[@id='box-campaigns']//a[@class='link']").click();
        String nameInside = driver.findElementByXPath("//h1[@class='title']").getText();
        String getSalePriceInside = driver.findElementByXPath("//div[@id='box-product']//strong[@class='campaign-price']").getText();
        String getFixPriceInside = driver.findElementByXPath("//div[@id='box-product']//s[@class='regular-price']").getText();

        String getFixPriceInsideColor = driver.findElementByCssSelector(".regular-price").getCssValue("color");
        boolean checkFixPriceInsideColorS = driver.findElementByCssSelector(".regular-price").getTagName().equals("s");
        String getFontFixPriceInside = driver.findElementByCssSelector(".regular-price").getCssValue("font-size");

        Assert.assertEquals(getFixPriceInsideColor, "rgba(102, 102, 102, 1)");
        Assert.assertTrue(checkFixPriceInsideColorS);

        String getSalePriceInsideColor = driver.findElementByCssSelector(".campaign-price").getCssValue("color");
        String getFontSalePriceInside = driver.findElementByCssSelector(".campaign-price").getCssValue("font-size");
        boolean checkSalePriceInsideColorS = driver.findElementByCssSelector(".campaign-price").getTagName().equals("strong");
        Assert.assertEquals(getSalePriceInsideColor, "rgba(204, 0, 0, 1)");
        Assert.assertTrue(checkSalePriceInsideColorS);
        Assert.assertTrue(getFontFixPriceInside.compareTo(getFontSalePriceInside) < 0);

        Assert.assertTrue(nameMain.equals(nameInside));
        Assert.assertTrue(getSalePriceMain.equals(getSalePriceInside));
        Assert.assertTrue(getFixPriceMain.equals(getFixPriceInside));
    }
}

