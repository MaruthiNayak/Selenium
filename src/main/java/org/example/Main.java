package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Main {
    public static void main(String[] args) {
//   D:\Automation\Selenium\src\main\resources\chromedriver.exe
        String path = System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+File.separator+
                "resources"+File.separator+"chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }
}