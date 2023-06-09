package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DropdownHandler;
import utils.Waiter;

import java.util.List;

public class _11_TGDropdownsTest extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-5")).click();
    }

    @Test
    public void productDropdownTest(){

        WebElement dropdown = driver.findElement(By.id("product_dropdown"));
        DropdownHandler.selectByVisibleText(dropdown, "iPhone 14 Pro Max");
    }

    @Test
    public void productColorTest(){
        WebElement dropdown = driver.findElement(By.id("color_dropdown"));
        DropdownHandler.selectByIndex(dropdown, 2);
    }

    @Test
    public void productDeliveryTest(){
        WebElement dropdown = driver.findElement(By.id("shipment_dropdown"));
        List<WebElement> dropdownOption = driver.findElements(By.cssSelector("#shipment_dropdown span"));

        DropdownHandler.clickDropdownOption(dropdown, dropdownOption, "Delivery");
    }


}