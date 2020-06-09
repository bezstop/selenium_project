package ru.selenium.courses;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SetUp {

    public ChromeDriver driver;
    public WebDriverWait wait;


    public void checkAuthAdmin() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElementByName("username").sendKeys("admin");
        driver.findElementByName("password").sendKeys("admin");
        driver.findElementByName("login").click();
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("My Store"));
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/QA/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 1000000);
    }

    @After
    public void close() {
        driver.quit();
    }
}

