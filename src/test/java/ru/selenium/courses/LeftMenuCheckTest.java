package ru.selenium.courses;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.Thread.sleep;

public class LeftMenuCheckTest extends SetUp {
    public WebElement h1;
    public List<WebElement> elementsMenu, submenuElements;

    public void checkH1Element() {
        h1 = driver.findElementByCssSelector("h1");
        Assert.assertTrue(h1.isEnabled());
    }

    @Test
    public void LeftMenuCheck() throws InterruptedException {
        checkAuthAdmin();
        int count = driver.findElementsById("app-").size();
        //поиск по заголовку меню
        for (int i = 0; i < count; i++) {
            elementsMenu = driver.findElementsById("app-");
            elementsMenu.get(i).click();
            checkH1Element();
            //поиск по внутренним элементам меню
            submenuElements = driver.findElementsByCssSelector("ul.docs li");
            int newCount = driver.findElementsByCssSelector("ul.docs li").size();
            if (submenuElements.size() != 0) {
                for (int j = 0; j < newCount; j++) {
                    submenuElements = driver.findElementsByCssSelector("ul.docs li");
                    submenuElements.get(j).click();
                    checkH1Element();
                }
            }
            sleep(1000);
        }
    }
}
