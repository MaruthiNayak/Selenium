package automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class WindowHandle {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");


        driver.findElement(By.linkText("OrangeHRM, Inc")).click();
        Thread.sleep(2000);
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> itr = handles.iterator();
        String parentWindow = itr.next();
        String childWindow = itr.next();
        driver.switchTo().window(childWindow);
        Thread.sleep(10000);

        //code to execute in sub tab
        WebElement plotForm= driver.findElement(By.xpath("//*[@*='link']"));
        Actions actions= new Actions(driver);
        actions.moveToElement(plotForm).build().perform();
        Thread.sleep(3000);
        WebElement recruitment= driver.findElement(By.linkText("Recruitment (ATS)"));
        actions.click(recruitment).perform();

        driver.switchTo().window(parentWindow);
        //code to execute in main Tab
        WebElement userName = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        userName.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("admin123");
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button']"));
        loginButton.click();
    }
}
