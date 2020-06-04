package ru.selenium.courses;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CheckStickersTest extends SetUp {

    //Задание 8. Сделайте сценарий, проверяющий наличие стикеров у товаров
        public List<WebElement> imageWrapper;

        @Test
        public void checkStickers() {
            driver.get("http://localhost/litecart/en/");
            int productOnPageCount = driver.findElementsByClassName("product").size();
            int stickerListCount = driver.findElementsByClassName("sticker").size();
            for (int i = 0; i < productOnPageCount; i++) {
                System.out.println("Всего элементов:" + productOnPageCount);
                System.out.println("Всего стикеров:" + stickerListCount);
                Assert.assertTrue(stickerListCount == productOnPageCount);
            }
        }
    }
