package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PageClass extends BaseClass{
    public static CommonFunctions commonFunctions= new CommonFunctions();

    static void login() throws InterruptedException {
        commonFunctions.sendKeys(driver.findElement(By.xpath("//*[@id='txtUsername']")),"Admin");
        commonFunctions.sendKeys(driver.findElement(By.xpath("//*[@id='txtPassword']")),"admin123");
        commonFunctions.waitAndClick( driver.findElement(By.xpath("//*[@*='button']")));
        Thread.sleep(3000);
    }

    static void navigateToMyInfo(){
        commonFunctions.waitAndClick(driver.findElement(By.id("menu_pim_viewMyDetails")));

    }
    static void enterPersonalDetails() throws InterruptedException {
        commonFunctions.waitAndClick(driver.findElement(By.id("btnSave")));
        Thread.sleep(3000);
        commonFunctions.waitAndClick(driver.findElement(By.xpath("//*[@id='personal_optGender_2']")));
        WebElement nationalityDropDown= driver.findElement(By.id("personal_cmbNation"));
        commonFunctions.selectDropdown(nationalityDropDown,"Indian");

    }
}
