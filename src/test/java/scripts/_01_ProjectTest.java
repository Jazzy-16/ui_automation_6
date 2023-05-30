package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

import java.util.List;

public class _01_ProjectTest extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-1");

    }

    @Test
    public void validateContactUsPage(){

        WebElement heading = driver.findElement(By.cssSelector("h1[class ='is-size-2']"));
        Assert.assertTrue(heading.isDisplayed());
        Assert.assertEquals(heading.getText(),"Contact Us");

        WebElement address = driver.findElement(By.id("address"));
        Assert.assertTrue(address.isDisplayed());
        Assert.assertEquals(address.getText(),"2860 S River Rd Suite 350, Des Plaines IL 60018");

        WebElement email = driver.findElement(By.id("email"));
        Assert.assertTrue(email.isDisplayed());
        Assert.assertEquals(email.getText(),"info@techglobalschool.com");

        WebElement phoneNumber = driver.findElement(By.id("phone-number"));
        Assert.assertTrue(phoneNumber.isDisplayed());
        Assert.assertEquals(phoneNumber.getText(),"(773) 257-3010");

    }

    @Test
    public void validateFullName(){

        WebElement inputBox = driver.findElement(By.cssSelector("form>div:nth-child(1)>div>input"));
        Assert.assertTrue(inputBox.isDisplayed());
        Assert.assertTrue(true,inputBox.getAttribute("required"));

        WebElement label = driver.findElement(By.cssSelector("form>div:nth-child(1)>div>label"));
        Assert.assertEquals(label.getText(),"Full name");
        Assert.assertEquals(inputBox.getAttribute("placeholder"),"Enter your name");

    }

    @Test
    public void validateGenderRadioButtons() {

        WebElement gender = driver.findElement(By.cssSelector("div.field:nth-child(2) label.label"));
        Assert.assertEquals(gender.getText(), "Gender");
        Assert.assertTrue(true, gender.getAttribute("required"));

        List<WebElement> genderLabels = driver.findElements(By.cssSelector(".mr-1"));
        List<WebElement> genderInput = driver.findElements(By.cssSelector("div[class='field'] label.radio"));

        String[] labelList = {"Male", "Female", "Prefer not to disclose"};

        for (int i = 0; i < genderLabels.size(); i++) {
            Assert.assertTrue(genderLabels.get(i).isDisplayed());
            Assert.assertEquals(genderLabels.get(i).getText(), labelList[i]);
            Assert.assertTrue(genderInput.get(i).isEnabled());
            Assert.assertFalse(genderInput.get(i).isSelected());
        }

        genderLabels.get(0).click();
        Assert.assertTrue(genderInput.get(0).isSelected());
        for (int i = 1; i < genderLabels.size(); i++) {
            Assert.assertFalse(genderInput.get(i).isSelected());
        }

        genderLabels.get(1).click();
        Assert.assertTrue(genderInput.get(1).isSelected());

        for (int i = 0; i < genderLabels.size(); i++) {
            Assert.assertFalse(genderInput.get(i).isSelected());
            i += 1;
        }
    }
        @Test
    public void validateAddressInput(){

        WebElement addressInputBox = driver.findElement(By.cssSelector("div[class='field']:nth-child(3) input"));
        Assert.assertTrue(addressInputBox.isDisplayed());
        Assert.assertFalse(false,addressInputBox.getAttribute("required"));

        WebElement addressLabel = driver.findElement(By.cssSelector("div[class='field']:nth-child(3) label"));
        Assert.assertEquals(addressLabel.getText(),"Address");
        Assert.assertEquals(addressInputBox.getAttribute("placeholder"),"Enter your address*");

        }

        @Test
    public void validateEmailInputBox(){

        WebElement emailInputBox = driver.findElement(By.cssSelector("div[class='field']:nth-child(4) input"));
        Assert.assertTrue(emailInputBox.isDisplayed());
        Assert.assertTrue(true, emailInputBox.getAttribute("required"));

        WebElement emailLabel = driver.findElement(By.cssSelector("div[class='field']:nth-child(4) label"));
        Assert.assertEquals(emailLabel.getText(), "Email");//fails due to requirement did not have * sign
        Assert.assertEquals(emailInputBox.getAttribute("placeholder"),"Enter your email");

        }

        @Test
    public void validatePhoneInputBox(){

        WebElement phoneInputBox = driver.findElement(By.cssSelector("div[class='field']:nth-child(5) input"));
        Assert.assertTrue(phoneInputBox.isDisplayed());
        Assert.assertFalse(false,phoneInputBox.getAttribute("required"));

        WebElement phoneLabel = driver.findElement(By.cssSelector("div[class='field']:nth-child(5) label"));
        Assert.assertEquals(phoneLabel.getText(), "Phone");
        Assert.assertEquals(phoneInputBox.getAttribute("placeholder"), "Enter your phone number");

        }

        @Test
    public void validateMessageTextArea(){

        WebElement messageTextArea = driver.findElement(By.cssSelector(".textarea"));
        Assert.assertTrue(messageTextArea.isDisplayed());
        Assert.assertFalse(false, messageTextArea.getAttribute("required"));

        WebElement messageLabel = driver.findElement(By.cssSelector("div[class='field']:nth-child(6) label"));
        Assert.assertEquals(messageLabel.getText(), "Message");
        Assert.assertEquals(messageTextArea.getAttribute("placeholder"), "Type your message here…");//failed due to requirement did not have spaces between dots

        }

        @Test
    public void validateConsentCheckBox(){

        WebElement consentLabel = driver.findElement(By.cssSelector("div[class='field']:nth-child(7) label"));
        Assert.assertEquals(consentLabel.getText(),"I give my consent to be contacted.");

        WebElement consentCheckBox = driver.findElement(By.cssSelector("div[class='field']:nth-child(7) input"));
        Assert.assertTrue(true,consentCheckBox.getAttribute("required"));
        Assert.assertTrue(consentCheckBox.isEnabled());
        consentCheckBox.click();
        Assert.assertTrue(consentCheckBox.isSelected());
        consentCheckBox.click();
        Assert.assertFalse(consentCheckBox.isSelected());

        }


        @Test
    public void validateSubmitButton() {
            WebElement submitButton = driver.findElement(By.cssSelector(".is-link"));
            Assert.assertTrue(submitButton.isDisplayed());
            Assert.assertTrue(submitButton.isEnabled());
            Assert.assertEquals(submitButton.getText(), "SUBMIT");


        }

        @Test
        public void  ValidateTheFormSubmission(){

            WebElement enterFullName = driver.findElement(By.cssSelector("div:nth-child(1)>div>input"));
            List<WebElement> genderOptions = driver.findElements(By.className("radio"));
            WebElement addressInputBox = driver.findElement(By.cssSelector("div:nth-child(3)>div > input"));
            WebElement emailInputBox = driver.findElement(By.cssSelector("div:nth-child(4)>div>input"));
            WebElement phoneInputBox = driver.findElement(By.cssSelector("div:nth-child(5)>div>input"));
            WebElement messageInputBox = driver.findElement(By.cssSelector("div:nth-child(6)>div>textarea"));
            WebElement consentInput = driver.findElement(By.cssSelector("div:nth-child(7)>div>label>input"));
            WebElement submitButton = driver.findElement(By.cssSelector(".is-link"));

            genderOptions.get(0).click();
            enterFullName.sendKeys("John Doe");
            addressInputBox.sendKeys("2860 S River Rd Suite 350, Des Plaines IL 60018");
            emailInputBox.sendKeys("info@techglobalschool.com");
            phoneInputBox.sendKeys("(773) 257-3010");
            messageInputBox.sendKeys("Automation test is fun!");
            consentInput.click();
            Waiter.pause(3);
            submitButton.click();
        }

    }


