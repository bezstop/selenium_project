package ru.selenium.courses;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.file.Path;
import java.nio.file.Paths;

public class AddGoodsByAdmin extends SetUp {

    private void saveButton() {
        driver.findElementByXPath("//button[@name='save']").click();
    }

    @Test
    public void addGoodsByAdminMenu() throws InterruptedException {
        checkAuthAdmin();
        Thread.sleep(5000);
        driver.findElementByXPath("//span[contains(text(),'Catalog')]").click();
        Thread.sleep(10000);
        driver.findElementByXPath("//a[contains(text(),'Add New Product')]").click();
        Thread.sleep(5000);

        driver.findElementByXPath("//label[contains(text(),'Enabled')]//input[@name = 'status']").click();
        driver.findElementByXPath("//input[@name='name[en]']").sendKeys("TestGood");
        driver.findElementByXPath("//input[@name='code']").sendKeys("TestName");
        driver.findElementByXPath("//td[contains(text(),'Female')]").click();
        WebElement quantity = driver.findElementByXPath("//input[@name='quantity']");
        quantity.clear();
        quantity.sendKeys("100");

       //файл
        String relativePath = "./src/test/resources/testimages.jpg";
        Path filePath = Paths.get(relativePath);
        String photoPath = filePath.normalize().toAbsolutePath().toString();
        driver.findElement(By.name("new_images[]")).sendKeys(photoPath);

        //календарь от
        WebElement calendar1 = driver.findElementByXPath("//input[@name='date_valid_from']");
        calendar1.click();
        calendar1.sendKeys("06/15/2020");

        //календарь до
        WebElement calendar2 = driver.findElementByXPath("//input[@name='date_valid_to']");
        calendar2.click();
        calendar2.sendKeys("06/15/2021");

        //переход на вкладку
        driver.findElementByXPath("//a[contains(text(),'Information')]").click();
        driver.findElementByXPath("//select[@name='manufacturer_id']").click();
        driver.findElementByXPath("//select[@name='manufacturer_id']//option[contains(text(),'ACME Corp.')]").click();
        driver.findElementByXPath("//input[@name='keywords']").sendKeys("test");
        driver.findElementByXPath("//input[@name='short_description[en]']").sendKeys("test2");
        driver.findElementByXPath("//div[@class='trumbowyg-editor']").sendKeys("test3");
        driver.findElementByXPath("//input[@name='head_title[en]']").sendKeys("test4");
        driver.findElementByXPath("//input[@name='meta_description[en]']").sendKeys("test5");
//        Select manufacturer = new Select(driver.findElementByXPath("//select[@name='manufacturer_id']"));
//        manufacturer.selectByVisibleText("ACME Corp.");

        //Переходим на вкладку Prices
        driver.findElementByXPath("//a[contains(text(),'Prices')]").click();
        WebElement purchase_price = driver.findElementByXPath("//input[@name='purchase_price']");
        purchase_price.clear();
        purchase_price.sendKeys("100");
        driver.findElementByXPath("//select[@name='purchase_price_currency_code']").click();
        driver.findElementByXPath("//select[@name='purchase_price_currency_code']//option[contains(text(),'US Dollars')]").click();
        driver.findElementByXPath("//input[@name='prices[USD]']").sendKeys("5");
        driver.findElementByXPath("//input[@name='prices[EUR]']").sendKeys("10");

        //сохраняем
        saveButton();

        //проверяем
        Assert.assertTrue( driver.findElementByXPath("//a[contains(text(),'TestGood')]").isDisplayed());
    }

}
