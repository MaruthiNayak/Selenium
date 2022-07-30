package automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
    public WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        DragAndDrop dragAndDrop= new DragAndDrop();
        dragAndDrop.launchBrowser();
        dragAndDrop.dragAndDropFunc();
    }


    void launchBrowser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
    }

    void dragAndDropFunc() throws InterruptedException {
        WebElement source= driver.findElement(By.id("box3"));
        WebElement target= driver.findElement(By.xpath("//div[text()='United States']"));
        Actions actions= new Actions(driver);
        actions.dragAndDrop(source,target).build().perform();
        Thread.sleep(3000);
        WebElement target1= driver.findElement(By.id("capitals"));
        actions.dragAndDrop(source,target1).perform();


    }
}
