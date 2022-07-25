package automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextAndGetAttribute {
    public WebDriver driver;
    public static void main(String[] args) {
        GetTextAndGetAttribute getTextAndGetAttribute= new GetTextAndGetAttribute();
        getTextAndGetAttribute.launchBrowser();
        getTextAndGetAttribute.login();
        getTextAndGetAttribute.navigateToMyInfo();

    }

    void launchBrowser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    void login(){

        WebElement userName= driver.findElement(By.xpath("//input[@id='txtUsername']"));
        userName.sendKeys("Admin");
        WebElement password= driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("admin123");
        WebElement loginButton= driver.findElement(By.xpath("//input[@class='button']"));
        loginButton.click();
    }

    void navigateToMyInfo() {
        driver.findElement(By.id("menu_pim_viewMyDetails")).click();
        driver.findElement(By.id("btnSave")).click();
        WebElement ssnNO= driver.findElement(By.xpath("//label[text()='SSN Number']"));
        String ssnText= ssnNO.getText();
        System.out.println("Text from getText :"+ssnText);

        WebElement employeeId= driver.findElement(By.id("personal_txtEmployeeId"));
        String empId=employeeId.getAttribute("value");
        System.out.println("From get Attribute :"+empId);

        String name=employeeId.getAttribute("name");
        System.out.println("Name  :"+name);
    }
}
