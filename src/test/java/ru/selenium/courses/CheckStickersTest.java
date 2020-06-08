package ru.selenium.courses;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckStickersTest extends SetUp {

    //Задание 8. Сделайте сценарий, проверяющий наличие стикеров у товаров


    @Test
    public void checkStickers() {
        driver.get("http://localhost/litecart/en/");
        int productOnPageCount = driver.findElementsByClassName("product").size();
        for (int i = 0; i < productOnPageCount; i++) {
            int stickerListCount = driver.findElementsByClassName("sticker").size();
            Assert.assertTrue("Количество стикеров = " + stickerListCount + " Ожидалось = 1", stickerListCount == 1);
        }
    }


    @Test
    public void checkStickers2() {
        driver.get("http://localhost/litecart/en/");
        List<WebElement> productOnPageCount = driver.findElements(By.cssSelector(".product"));
        for (WebElement product: productOnPageCount) {
            int stickerListCount = product.findElements(By.cssSelector(".sticker")).size();
            Assert.assertTrue("Количество стикеров = " + stickerListCount + " Ожидалось = 1", stickerListCount == 1);
        }
    }
}


