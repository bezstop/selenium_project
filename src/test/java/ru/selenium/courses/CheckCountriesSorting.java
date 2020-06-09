package ru.selenium.courses;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

public class CheckCountriesSorting extends SetUp {

//    Задание 9. Проверить сортировку стран и геозон в админке
//    Сделайте сценарии, которые проверяют сортировку стран и геозон (штатов) в учебном приложении litecart.
//
//            1) на странице http://localhost/litecart/admin/?app=countries&doc=countries
//    а) проверить, что страны расположены в алфавитном порядке
//    б) для тех стран, у которых количество зон отлично от нуля -- открыть страницу этой страны и там проверить, что зоны расположены в алфавитном порядке

    @Test
    public void TestCountryList() {
        checkAuthAdmin();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");

        List<WebElement> countriesList = driver.findElements(By.xpath("//tr[@class='row']"));
        String currentCountry = countriesList.get(0).findElement(By.xpath("./td[5]")).getText();
        for (WebElement countryItem : countriesList) {
            String nextCountry = countryItem.findElement(By.xpath("./td[5]")).getText();
            Assert.assertEquals(true, (currentCountry.compareTo(nextCountry) <= 0));
            System.out.println(nextCountry);

        }
    }

    @Test
    public void TestCountryListNotZero() {
        checkAuthAdmin();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");

        int countriesNumber = driver.findElements(By.xpath("//tr[@class='row']//td[6][not(contains(text(),'0'))]")).size();
        for (int i = 0; i < countriesNumber; i++) {

            driver.findElements(By.xpath("//tr[@class='row']//td[6][not(contains(text(),'0'))]")).get(i).findElement(By.xpath("../td[5]/a")).click();
            List<WebElement> zonesList = driver.findElements(By.xpath("//*[@id='remove-zone']/../.."));
            String currentZone = zonesList.get(0).findElement(By.xpath("./td[3]")).getText();
            for (WebElement zoneItem : zonesList) {

                String nextZone = zoneItem.findElement(By.xpath("./td[3]")).getText();
                Assert.assertEquals(true, (currentZone.compareTo(nextZone) <= 0));
                System.out.println(nextZone);
            }
            driver.navigate().back();
        }
    }


//    2) на странице http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones
//    зайти в каждую из стран и проверить, что зоны расположены в алфавитном порядке

    @Test
    public void TestCountryGeoZones() {
        checkAuthAdmin();
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        int countriesNumber = driver.findElements(By.xpath("//tr[@class='row']//td[3]")).size();
        for (int i = 0; i < countriesNumber; i++) {
            driver.findElements(By.xpath("//tr[@class='row']//td[3]")).get(i).findElement(By.xpath("../td[3]/a")).click();
            List<WebElement> zonesList = driver.findElements(By.xpath("//*[@id='remove-zone']/../.."));
            String currentZone = zonesList.get(0).findElement(By.xpath("./td[3]")).getText();
            for (WebElement zoneItem : zonesList) {
                String nextZone = zoneItem.findElement(By.xpath("./td[3]")).getText();
                Assert.assertEquals(true, (currentZone.compareTo(nextZone) <= 0));
                System.out.println(nextZone);
            }
            driver.navigate().back();

        }
    }
}




