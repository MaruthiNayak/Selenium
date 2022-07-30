package automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DynamicXPath {
    public WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        DynamicXPath obj= new DynamicXPath();
        obj.launch();
        obj.login();
        obj.selectDate(17,"1","1929");
    }
    void launch(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
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
        driver.findElement(By.linkText("My Info")).click();
    }
    void selectDate( int date,String monthData, String yearData) throws InterruptedException {
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("personal_DOB")).click();
        WebElement year= driver.findElement(By.xpath("//*[@*='ui-datepicker-year']"));
        Select select1=new Select(year);
        select1.selectByValue(yearData);
        Thread.sleep(2000);
        WebElement month= driver.findElement(By.xpath("//*[@*='ui-datepicker-month']"));
        Select select=new Select(month);
        select.selectByValue(monthData);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(@class,'ui-state-default') and text()='"+date+"']"));
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
    }
}
