package ru.selenium.courses;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;

import java.util.List;

public class CheckLogsNotification extends SetUp {


    @Test
    public void checkLogs() {
        checkAuthAdmin();
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        // получаем список карточек товара
        List<WebElement> goodsList = driver.findElements(By.xpath("//img/../a[contains(@href,'edit_product')]"));
        int countGoods = goodsList.size();
        // последовательно открывать страницы товаров и проверять,
        // не появляются ли в логе браузера сообщения (любого уровня)
        for (int i = 0; i < countGoods; i++) {
            goodsList = driver.findElements(By.xpath("//img/../a[contains(@href,'edit_product')]"));
            goodsList.get(i).click();
            List<LogEntry> logs = driver.manage().logs().get("browser").getAll();
            Assert.assertTrue(logs.isEmpty());
            System.out.println(logs);
            driver.navigate().back();
        }
    }
}




