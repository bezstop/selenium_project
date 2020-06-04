package ru.selenium.courses;

import org.junit.Test;

public class FirstTest extends SetUp {

    @Test
    public void firstTest() {
        driver.get("https://www.yandex.ru/");
    }

}
