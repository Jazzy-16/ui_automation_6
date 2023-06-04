package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TableHandler;

import java.util.List;

public class _17_TGStaticTableTest extends Base {

    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-11")).click();
    }

    /**
     * TEST CASE 1
     * Verify the headers of the table
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Static Tables" card
     * Check that the headers of the table are "Rank", "Company", "Employees", and "Country"
     * Verify the rows of the table
     */


    @Test
    public void validateTableHeader() {

        List<WebElement> tableHeaders = driver.findElements(By.cssSelector(".header"));
        String[] expectedResults = {"Rank", "Company", "Employees", "Country"};

        for (int i = 0; i < tableHeaders.size(); i++) {
            Assert.assertEquals(tableHeaders.get(i).getText(), expectedResults[i]);
        }
    }

    /**
     * TEST CASE 2
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Static Tables" card
     * Check that the first row of the table has the values "1", "Amazon", "1,523,000", and "USA"
     * Verify the columns of the table
     */

    @Test
    public void validateFirstRow() {
        List<WebElement> firstTableRow = TableHandler.getTableRow(1);
        String[] expectedText = {"1", "Amazon", "1,523,000", "USA"};

        for (int i = 0; i < firstTableRow.size(); i++) {
            Assert.assertEquals(firstTableRow.get(i).getText(), expectedText[i]);
        }
    }

    /**
     * TEST CASE 3
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Static Tables" card
     * Check that the "Country" column of the table has the values "USA", "China", "USA", "USA", "S. Korea"
     * Verify the entire table
     */

    @Test
    public void validateLastColumn() {
        List<WebElement> lastColumnCells = TableHandler.getTableColumn(4);
        String[] expectedText = {"USA", "China", "USA", "USA", "S. Korea"};

        for (int i = 0; i < expectedText.length; i++) {
            Assert.assertEquals(lastColumnCells.get(i).getText(), expectedText[i]);
        }
    }
}