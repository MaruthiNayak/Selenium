package automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesDeMoQa {
    public WebDriver driver;

    public static void main(String[] args) {
        FramesDeMoQa frames= new FramesDeMoQa();
        frames.handleFrames();
    }

    void handleFrames(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/frames");
        WebElement frame= driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame);
        String text=driver.findElement(By.id("sampleHeading")).getText();
        System.out.println("Text :" +text);
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[text()='Browser Windows']")).click();

    }
}
