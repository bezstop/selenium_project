package ru.selenium.courses;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckCart extends SetUp {
    //проверяем добавление в корзину
    @Test
    public void checkCart() {
        driver.get("http://localhost/litecart/en/");
        wait.until(ExpectedConditions.titleIs("Online Store | My Store"));
        int count = 0;
        for (; count < 3; count++) {
            driver.findElementByXPath("//div[@id='box-most-popular']//li[1]//a[1]").click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='add_cart_product']")));
            int quanity = Integer.parseInt(driver.findElementByXPath("//span[@class='quantity']").getText());
            if (checkTrueSize()) {
                driver.findElementByXPath("//option[contains(text(),'Select')]").click();
                driver.findElementByXPath("//option[contains(text(),'Small')]").click();
            }
            driver.findElementByXPath("//button[@name='add_cart_product']").click();
            wait.until(ExpectedConditions.textToBe(By.xpath("//span[@class='quantity']"), String.valueOf(quanity + 1)));
            System.out.println(quanity + 1);
            driver.navigate().back();
        }

        //checkout
        driver.findElementByXPath("//a[contains(text(),'Checkout »')]").click();

        //проверяем удаление из корзины
        wait.until(ExpectedConditions.titleIs("Checkout | My Store"));

        WebElement buttonDeleteItem;
        WebElement table = driver.findElementByXPath("//table[@class='dataTable rounded-corners']");

        while(driver.findElements(By.name("remove_cart_item")).size() != 0){
            buttonDeleteItem = driver.findElement(By.name("remove_cart_item"));
            buttonDeleteItem.click();
            wait.until(ExpectedConditions.stalenessOf(buttonDeleteItem));
        }

        wait.until(ExpectedConditions.stalenessOf(table));
        Assert.assertTrue(driver.findElement(By.tagName("p")).getText().contains("There are no items in your cart."));
        System.out.println("дошли до конца");
    }

    //Проверяем размер в товаре если он есть
        private boolean checkTrueSize() {
        try {
            driver.findElementByXPath("//strong[contains(text(),'Size')]");
            return true;
        } catch (NoSuchElementException e) {
            return false;

        }
    }
}
