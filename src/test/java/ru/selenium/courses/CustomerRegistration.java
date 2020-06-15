package ru.selenium.courses;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

public class CustomerRegistration extends SetUp {
    String random = String.valueOf(Math.random());
    String email = "qwer" + random + "@ya.ru";
    String password = "123";


    private void newCustomerRegistrationLogout(){
        //кликаем по кнопке разлогиниться
        driver.findElementByXPath("//div[@class='content']//a[contains(text(),'Logout')]").click();
    }

    private void newCustomerEmailPasswordData() {
        //вводим логин и пароль
        driver.findElementByXPath("//input[@name = 'email']").sendKeys(email);
        driver.findElementByXPath("//input[@name = 'password']").sendKeys(password);
    }

    @Test
    public void newCustomerRegistration() throws InterruptedException {
        driver.get("http://localhost/litecart/en/");
        driver.findElementByXPath("//a[contains(text(),'New customers click here')]").click();
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Create Account | My Store"));
        Thread.sleep(5000);
        driver.findElementByXPath("//span[@class= 'select2-selection__arrow']").click();
        Thread.sleep(5000);
        driver.findElementByXPath("//input[@class = 'select2-search__field']").sendKeys("United States" + Keys.ENTER);
        Thread.sleep(5000);
        driver.findElementByXPath("//input[@name = 'firstname']").sendKeys("Yuri");
        driver.findElementByXPath("//input[@name = 'lastname']").sendKeys("Schiryaev");
        driver.findElementByXPath("//input[@name = 'address1']").sendKeys("Gorod");
        driver.findElementByXPath("//input[@name = 'city']").sendKeys("Boston");
        newCustomerEmailPasswordData();
        driver.findElementByXPath("//input[@name = 'phone']").sendKeys("+123456789");
        driver.findElementByXPath("//input[@name = 'confirmed_password']").sendKeys("123");
        driver.findElementByXPath("//input[@name = 'postcode']").sendKeys("11111");
        driver.findElementByXPath("//button[@name='create_account']").click();
        Thread.sleep(10000);
        //разлогиниваемся
        newCustomerRegistrationLogout();
        //вводим логин и пароль
        newCustomerEmailPasswordData();
        //Кликаем по кнопке логин
        driver.findElementByXPath("//button[@name ='login']").click();
        //разлогиниваемся
        newCustomerRegistrationLogout();
    }

}
