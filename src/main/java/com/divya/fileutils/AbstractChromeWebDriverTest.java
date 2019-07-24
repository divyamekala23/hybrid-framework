package com.divya.fileutils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractChromeWebDriverTest {

    protected WebDriver driver;

    public AbstractChromeWebDriverTest() {
        super();
    }

    @BeforeTest
    public void beforeTest() {
        // download the webdriver executable

        WebDriverManager.chromedriver().setup();

        // create a instance of your web driver

        driver = new ChromeDriver();
    }

    @AfterTest
    public void afterTest() {

        driver.quit();
    }

    public void sleep(int seconds) {

        try {
            Thread.sleep(seconds * 1000);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

}