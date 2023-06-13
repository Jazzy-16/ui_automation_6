package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;


import java.util.List;

public class Project3Page {

    public Project3Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//input[@class='mr-1'])[1]")
    public WebElement oneWayButton;

    @FindBy(xpath = "(//input[@class='mr-1'])[2]")
    public WebElement roundTripButton;

    @FindBy(xpath = "(//label[@class='label'])[2]")
    public WebElement cabinClassLabel;

    @FindBy(xpath = "(//div[@class='select'])[1]")
    public WebElement cabinClassDropdown;

    @FindBy(xpath = "(//label[@class='label'])[3]")
    public WebElement from;

    @FindBy(css = ".field:nth-child(3) select")
    public WebElement fromDropdown;

    @FindBy(xpath = "(//label[@class='label'])[4]")
    public WebElement to;

    @FindBy(css = ".field:nth-child(4) select")
    public WebElement toDropdown;

    @FindBy(xpath = "(//label[@class='label'])[5]")
    public WebElement departLabel;

    @FindBy(css = "div[class*='enabled']")
    public WebElement departDatePicker;

    @FindBy(xpath = "(//label[@class='label'])[6]")
    public WebElement returnLabel;

    @FindBy(css = "div[class*='disabled']")
    public WebElement returnDatePickerDisabled;

    @FindBy(css = "form>div>div:nth-child(6)>div")
    public WebElement returnDatePickerEnable;

    @FindBy(xpath = "(//label[@class='label'])[7]")
    public WebElement NumberOfPassengersLabel;

    @FindBy(xpath = "(//div[@class='select'])[4]")
    public WebElement passengerNumberDropdown;

    @FindBy(css = "div:nth-child(7)>div>select>option:nth-child(1)")
    public WebElement passengerNumberDropdownDefault;

    @FindBy(xpath = "(//label[@class='label'])[8]")
    public WebElement Passenger1;

    @FindBy(xpath = "(//div[@class='select'])[5]")
    public WebElement passenger1Dropdown;

    @FindBy(css = "div:nth-child(8)>div>select>option:nth-child(1")
    public WebElement passenger1DropdownDefault;

    @FindBy(css = "button[class*='w4']")
    public WebElement bookButton;

    @FindBy(css = ".field:nth-child(2) select")
    public WebElement cabinClass;


    @FindBy (css = ".field:nth-child(5) input[class$='month']")
    public WebElement departDatePickerMonth;

    @FindBy (css = ".field:nth-child(5) input[class$='day']")
    public WebElement departDatePickerDay;

    @FindBy (css = ".field:nth-child(5) input[class$='year']")
    public WebElement departDatePickerYear;

    @FindBy (css = ".field:nth-child(6) input[class$='month']")
    public WebElement returnDatePickerMonth;

    @FindBy (css = ".field:nth-child(6) input[class$='day']")
    public WebElement returnDatePickerDay;

    @FindBy (css = ".field:nth-child(6) input[class$='year']")
    public WebElement returnDatePickerYear;

    @FindBy (css = ".field:nth-child(7) option:nth-child(1)")
    public WebElement passNumber1;

    @FindBy (css = ".field:nth-child(7) option:nth-child(2)")
    public WebElement passNumber2;

    @FindBy (css = ".field:nth-child(8) option:nth-child(2)")
    public WebElement senior;

    @FindBy (css = ".ml-3 h1")
    public WebElement departMessage;

    @FindBy (xpath = "(//h3[@class='is-italic'])[1]")
    public WebElement depart_from_to;


    @FindBy (css = ".ml h1")
    public WebElement returnMessage;

    @FindBy (xpath = "(//h3[@class='is-italic'])[2]")
    public WebElement return_from_to;

    @FindBy (css = ".mt-4 p")
    public List<WebElement> departMessageTag;

    @FindBy(css = "div:nth-child(9) > div > select > option:nth-child(4)")
    public WebElement passenger2Dropdown;

}
