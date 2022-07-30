package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MyInfo {
    public WebDriver driver;
    public static void main(String[] args) {
        MyInfo obj=new MyInfo();
        obj.launch_browser();
        obj.login();
        obj.myInfo();
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
    }
    void myInfo() {
        WebElement myInfo=driver.findElement(By.linkText("My Info"));
        myInfo.click();
        WebElement edit=driver.findElement(By.id("btnSave"));
        edit.click();
        WebElement firstName= driver.findElement(By.id("personal_txtEmpFirstName"));
        firstName.clear();
        firstName.sendKeys("Maruthi");
        WebElement lastName=driver.findElement(By.id("personal_txtEmpLastName"));
        lastName.clear();
        lastName.sendKeys("Nayak");
        WebElement employeid=driver.findElement(By.name("personal[txtEmployeeId]"));
        employeid.clear();
        employeid.sendKeys("1334");
        WebElement licence=driver.findElement(By.name("personal[txtLicenNo]"));
        licence.clear();
        licence.sendKeys("88800");
        driver.findElement(By.name("personal[optGender]")).click();
        driver.findElement(By.id("personal_chkSmokeFlag")).click();
        WebElement maritalStatus=driver.findElement(By.xpath("//select[@id='personal_cmbMarital']"));
        Select select=new Select(maritalStatus);
        select.selectByVisibleText("Single");
        WebElement nationality=driver.findElement(By.xpath("//select[@id='personal_cmbNation']"));
        Select select1=new Select(nationality);
        select1.selectByValue("82");
        WebElement nickName=driver.findElement(By.name("personal[txtEmpNickName]"));
        nickName.clear();
        driver.findElement(By.id("personal_DOB")).click();
        WebElement month=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select select3=new Select(month);
        select3.selectByVisibleText("Jan");
        WebElement year=driver.findElement(By.xpath("//*[@class='ui-datepicker-year']"));
        Select select2=new Select(year);
        select2.selectByVisibleText("1993");
        driver.findElement(By.xpath("//a[@class='ui-state-default']")).click();
        driver.findElement(By.xpath("//*[@*='btnSave']")).click();
        driver.findElement(By.xpath("//*[@name='btnEditCustom']")).click();
        WebElement bloodGroup=driver.findElement(By.xpath("//select[@name='custom1']"));
        Select select4=new Select(bloodGroup);
        select4.selectByValue("O+");
        driver.findElement(By.xpath("//*[@name='btnEditCustom']")).click();
        driver.findElement(By.xpath("//*[@*='addbutton']")).click();
        //driver.findElement(By.xpath("//*[@*='ufile']")).click();

    }
}
