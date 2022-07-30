package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class launch_without_driver {
    public WebDriver driver;
    public static void main(String[] args) {
    launch_without_driver obj = new launch_without_driver();
    obj.launch_browser();
    obj.login();
    }
        void launch_browser() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://opensource-demo.orangehrmlive.com/");
        }
        void login() {
            WebElement userName = driver.findElement(By.id("txtUsername"));
            userName.sendKeys("Admin");
            WebElement passWord = driver.findElement(By.id("txtPassword"));
            passWord.sendKeys("admin123");
            WebElement login = driver.findElement(By.id("btnLogin"));
            login.click();
            //WebElement forgotPassword= driver.findElement(By.partialLinkText("Forgot your password?"));
            //forgotPassword.click();
        }
}
