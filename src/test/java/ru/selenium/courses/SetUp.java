package ru.selenium.courses;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class SetUp {

    public EventFiringWebDriver driver;
    public WebDriverWait wait;

    public static class MyListener extends AbstractWebDriverEventListener {
        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println("Ищем элемент" + " " + by);
        }


        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by + " нашли элемент");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            System.out.println(throwable);
        }

    }


    public void checkAuthAdmin() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
//        driver.findElementByName("username").sendKeys("admin");
//        driver.findElementByName("password").sendKeys("admin");
//        driver.findElementByName("login").click();
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("My Store"));
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/QA/Downloads/chromedriver.exe");
//        driver = new ChromeDriver();
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new MyListener());
        wait = new WebDriverWait(driver, 20);
    }

    @After
    public void close() {
        driver.quit();
    }
}

