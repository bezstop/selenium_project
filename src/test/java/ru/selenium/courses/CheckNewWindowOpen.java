package ru.selenium.courses;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;
import java.util.Set;

public class CheckNewWindowOpen extends SetUp {
    @Test
    public void checkCart() {
        checkAuthAdmin();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElementByXPath("//a[contains(text(),'Add New Country')]").click();
        List<WebElement> allLinks2 = driver.findElementsByXPath("//i[@class='fa fa-external-link']");
        for (WebElement allLink : allLinks2) {
            String originalWindow = driver.getWindowHandle();
            Set<String> existingWindows = driver.getWindowHandles();
            allLink.click();
            String newWindow = wait.until(anyWindowOtherThan(existingWindows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(originalWindow);
        }
    }

    private ExpectedCondition<String> anyWindowOtherThan(Set<String> oldWindows) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver driver) {
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(oldWindows);
                return handles.size() > 0 ? handles.iterator().next() : null;
            }
        };
    }
}

