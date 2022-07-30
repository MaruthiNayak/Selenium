package automation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions extends BaseClass{
    public  void sendKeys(WebElement element, String data){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(data);
    }

    public  void selectDropdown(WebElement element,String text){
        Select select= new Select(element);
        select.selectByVisibleText(text);
    }

    public  void acceptAlert(){
        Alert alert= driver.switchTo().alert();
        alert.accept();
    }

    public  void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public  void waitAndClick(WebElement element){
        waitForElement(element);
        element.click();
    }

    static void sendKeysBySelenium(WebElement element, String data){
        element.clear();
        element.sendKeys(data);
    }

    static void sendKeysByActions(WebElement element, String data){
        Actions actions= new Actions(driver);
        actions.sendKeys(element,data).perform();
    }

    static void sendKeysByJavaScript(WebElement element, String data){
        JavascriptExecutor executor= (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].value='"+data+"';",element);
    }

    static void selectFromDropDown(WebElement element,String visibleText){
        Select select= new Select(element);
        select.selectByVisibleText(visibleText);
    }

}
