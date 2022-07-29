package automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dynamic {
    public WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        Dynamic obj= new Dynamic();
        obj.launch();
        obj.selectDate("10","November","2020");


    }

    void launch(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");

    }

    void selectDate( String dayData,String monthData, String yearData) throws InterruptedException {
        driver.findElement(By.id("dateOfBirthInput")).click();
        WebElement month= driver.findElement(By.className("react-datepicker__month-select"));
        WebElement year= driver.findElement(By.className("react-datepicker__year-select"));
        selectFromDropDown(month,monthData);
        Thread.sleep(3000);
        selectFromDropDown(year,yearData);
        Thread.sleep(3000);
        WebElement day= driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day') and text()='"+dayData+"']"));
        System.out.println("//div[contains(@class,'react-datepicker__day') and text()='"+dayData+"']");
        day.click();

    }

    void selectFromDropDown(WebElement element,String visibleText){
        Select select= new Select(element);
        select.selectByVisibleText(visibleText);
    }

}

