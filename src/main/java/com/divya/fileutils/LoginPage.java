package com.divya.fileutils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class LoginPage{

WebDriver driver;

    public void sleep(int seconds) {

        try {
            Thread.sleep(seconds * 1000);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
    @DataProvider(name="userid- password")
    public String[][] multipleUserLoginCredentials(){
        return new String[][]{{"in28minutes","dummy"},{"adam","adam@123"},{"eve","eve@123"}};
    }

    @Test(dataProvider = "userid- password")
    public void userCredentials(String userID, String Password){

        WebDriverManager.chromedriver().setup();

        // create a instance of your web driver

        driver = new ChromeDriver();

        driver.get("http://localhost:8080/login");

        WebElement user= driver.findElement(By.id("name"));

        user.sendKeys(userID);

        WebElement password= driver.findElement(By.name("password"));

        password.sendKeys(Password);

        WebElement submitElement = driver.findElement(By.id("submit"));

        submitElement.click();

        WebElement validation=driver.findElement(By.id("welcome-message"));

        String a=validation.getText();

        if(a.equalsIgnoreCase("Welcome in28minutes!! Click here to manage your todo's.")){

            System.out.println(a);

        }else if(a.equalsIgnoreCase("Welcome adam!! Click here to manage your todo's.")) {

            System.out.println(a);

        }else if(a.equalsIgnoreCase("Welcome eve!! Click here to manage your todo's.")) {

            System.out.println(a);

        }else{

            System.out.println("no match found");
        }

     WebElement click=driver.findElement(By.xpath("//*[@id=\"welcome-message\"]/a"));

        click.click();

        sleep(5);

        driver.quit();

    }
}
