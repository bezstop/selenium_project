package ru.selenium.courses;

import org.junit.Assert;
import org.junit.Test;

public class AuthorisationTest extends SetUp {

    @Test
    public void checkAuthAdmin() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElementByName("username").sendKeys("admin");
        driver.findElementByName("password").sendKeys("admin");
        driver.findElementByName("login").click();
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("My Store"));
    }
}