package com.divya.fileutils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class CommonLogin{

    String userName;
    String password;
    WebDriver driver;


    public CommonLogin(String usr, String pwd) {

        userName = usr;

        password = pwd;
    }
    public void sleep(int seconds) {

        try {
            Thread.sleep(seconds * 1000);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

        public void loginPage(){

            WebDriverManager.chromedriver().setup();

            // create a instance of your web driver

            driver = new ChromeDriver();

            driver.get("http://localhost:8080/login");

            WebElement user = driver.findElement(By.name("name"));

            user.sendKeys(userName);

            WebElement password1 = driver.findElement(By.name("password"));

            password1.sendKeys(password);

            WebElement submitElement = driver.findElement(By.id("submit"));

            submitElement.click();
            sleep(5);

            driver.quit();


        }
        public static void main (String[] args ) {

            CommonLogin abc = new CommonLogin("adam", "adam@123");

            abc.loginPage();


        }
    }


