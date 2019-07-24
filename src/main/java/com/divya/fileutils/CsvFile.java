package com.divya.fileutils;

import com.opencsv.CSVReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CsvFile {

        WebDriver driver;

        public void sleep(int seconds) {

            try {
                Thread.sleep(seconds * 1000);

            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }

        @Test

        public void testReadingDataFromCSV(){

            List<String[]> data = readFromCSVFile("C:\\Users\\navee\\divyaProjects\\hybrid-framework\\target\\generated-sources\\Login-data.csv");

            for(String[] element: data){

                System.out.println(Arrays.toString(element));
            }
        }

    public List<String[]> readFromCSVFile(String csvFilePath) {
      try {

          CSVReader reader = new CSVReader(new FileReader(csvFilePath));
          List<String[]> data = reader.readAll();

          return data;
      }
      catch(Exception e){

          e.printStackTrace();
          throw new RuntimeException(e);
      }
    }


    @DataProvider(name = "CSV-userid- password")
    public Iterator<String[]> multipleUserLoginCredentials(){
        return readFromCSVFile("C:\\Users\\navee\\divyaProjects\\hybrid-framework\\target\\generated-sources\\Login-data.csv").iterator();
    }

    @Test(dataProvider = "CSV-userid- password")
public void userCredentials(String userID, String Password){

            WebDriverManager.chromedriver().setup();

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


