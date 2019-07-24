package com.divya.fileutils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class LoginPage extends AbstractChromeWebDriverTest {

    @Test

    public void userCredentials(){

        driver.get("http://localhost:8080/login");
        
        WebElement user= driver.findElement(By.name("name"));

        user.sendKeys("in28minutes");

        WebElement password= driver.findElement(By.name("password"));

        password.sendKeys("dummy");

        WebElement submitElement = driver.findElement(By.id("submit"));

        submitElement.click();

        sleep(5);

        System.out.println(driver.getTitle());

        WebElement validation=driver.findElement(By.id("welcome-message"));

        System.out.println(validation.getText());

        String actual= validation.getText();

        String expected ="Welcome in28minutes!! Click here to manage your todo's.";

        assertEquals(expected,actual);

        WebElement click=driver.findElement(By.xpath("//*[@id=\"welcome-message\"]/a"));

        click.click();

        sleep(5);


    }
}
