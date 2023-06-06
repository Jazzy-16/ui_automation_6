package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _02_ProjectTest extends Base {

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/project-2");
    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-2
        Validate that the username input box is displayed
        Validate that the username input box is not required
        Validate that the label of the username input box is “Please enter your username”
        Validate that the password input box is displayed
        Validate that the password input box is not required
        Validate that the label of the password input box is “Please enter your password”
        Validate the “LOGIN” button is displayed
        Validate the “LOGIN” button is clickable
        Validate that the button text is “LOGIN”
        Validate the “Forgot Password?” link is displayed
        Validate that the “Forgot Password?” link is clickable
        Validate that the link text is “Forgot Password?”
     */
    @Test
    public void validateLoginForm(){

        WebElement userInput = driver.findElement(By.id("username"));
        Assert.assertTrue(userInput.isDisplayed());
        Assert.assertFalse(false,userInput.getAttribute("required"));

        WebElement usernameLabel = driver.findElement(By.cssSelector("div [for='username']"));
        Assert.assertEquals(usernameLabel.getText(),"Please enter your username");

        WebElement passwordInput = driver.findElement(By.id("password"));
        Assert.assertTrue(passwordInput.isDisplayed());
        Assert.assertFalse(false,passwordInput.getAttribute("required"));

        WebElement passwordLabel = driver.findElement(By.cssSelector("div  [for='password']"));
        Assert.assertEquals(passwordLabel.getText(),"Please enter your password");

        WebElement loginButton = driver.findElement(By.id("login_btn"));
        Assert.assertTrue(loginButton.isDisplayed());
        Assert.assertTrue(loginButton.isEnabled());
        Assert.assertEquals(loginButton.getText(),"LOGIN");

        WebElement forgotPassword = driver.findElement(By.xpath("//button[@id='login_btn']/../a"));
        Assert.assertTrue(forgotPassword.isDisplayed());
        Assert.assertTrue(forgotPassword.isEnabled());
        Assert.assertEquals(forgotPassword.getText(),"Forgot Password?");

    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-2
        Enter the username as “TechGlobal”
        Enter the password as “Test1234”
        Click on the “LOGIN” button
        Validate the success message is displayed as “You are logged in”
        Validate the logout button displayed with the text “LOGOUT”
     */

    @Test
    public void validateTheValidLogin(){
        WebElement userInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));

        userInput.sendKeys("TechGlobal");
        passwordInput.sendKeys("Test1234");
        loginButton.click();

        WebElement successfulLogin = driver.findElement(By.id("success_lgn"));
        Assert.assertEquals(successfulLogin.getText(),"You are logged in");

        WebElement logOut = driver.findElement(By.id("logout"));
        Assert.assertTrue(logOut.isDisplayed());
        Assert.assertEquals(logOut.getText(),"LOGOUT");
    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-2
        Enter the username as “TechGlobal”
        Enter the password as “Test1234”
        Click on the “LOGIN” button
        Click on the “LOGOUT” button
        Validate that the login form is displayed
     */
    @Test
    public void validateTheLogout(){
        WebElement userInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));

        userInput.sendKeys("TechGlobal");
        passwordInput.sendKeys("Test1234");
        loginButton.click();

        WebElement logOut = driver.findElement(By.id("logout"));
        logOut.click();

        WebElement loginForm = driver.findElement(By.cssSelector(".LoginForm_form__b4o6J"));
        loginForm.isDisplayed();
    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-2
        Click on the “Forgot Password?” link
        Validate that the modal heading “Reset Password” is displayed
        Validate that the close button is displayed
        Validate that the email input box is displayed
        Validate that the label of the email input box is “Enter your email address and we'll send you a link to reset your password.”
        Validate the “SUBMIT” button is displayed
        Validate the “SUBMIT” button is clickable
        Validate that the button text is “SUBMIT”
     */

    @Test
    public void validateTheForgotPassword(){
        WebElement forgotPassword = driver.findElement(By.xpath("//button[@id='login_btn']/../a"));
        forgotPassword.click();

        WebElement modelHeading = driver.findElement(By.id("modal_title"));
        Assert.assertTrue(modelHeading.isDisplayed());

        WebElement closeButton = driver.findElement(By.cssSelector("[aria-label='close']"));
        Assert.assertTrue(closeButton.isDisplayed());

        WebElement emailInput = driver.findElement(By.id("email"));
        Assert.assertTrue(emailInput.isDisplayed());

        WebElement emailLabel = driver.findElement(By.cssSelector("label[for='email']"));
        Assert.assertEquals(emailLabel.getText(),"Enter your email address and we'll send you a link to reset your password.");

        WebElement submitButton = driver.findElement(By.id("submit"));
        Assert.assertTrue(submitButton.isDisplayed());
        Assert.assertTrue(submitButton.isEnabled());
        Assert.assertEquals(submitButton.getText(),"SUBMIT");
    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-2
        Click on the “Forgot Password?” link
        Validate that the “Reset Password” modal is displayed
        Click on the close button
        Validate that the “Reset Password” modal is closed
     */
    @Test
    public void validateTheResetModalCloseButton(){
        WebElement forgotPassword = driver.findElement(By.xpath("//button[@id='login_btn']/../a"));
        forgotPassword.click();

        WebElement modalDisplayed = driver.findElement(By.cssSelector(".modal-card-body"));
        Assert.assertTrue(modalDisplayed.isDisplayed());

        WebElement closeButton = driver.findElement(By.cssSelector("[aria-label='close']"));
        closeButton.click();

        WebElement loginForm = driver.findElement(By.cssSelector(".LoginForm_form__b4o6J"));
        loginForm.isDisplayed();
    }

     /*
    Navigate to https://techglobal-training.com/frontend/project-2
        Click on the “Forgot Password?” link
        Enter an email
        Click on the “SUBMIT” button
        Validate the form message “A link to reset your password has been sent to your email address.” is displayed under the “SUBMIT” button
     */

    @Test
    public void validateTheResetPasswordFormSubmission(){
        WebElement forgotPassword = driver.findElement(By.xpath("//button[@id='login_btn']/../a"));
        forgotPassword.click();

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("jazzy_chargyn@gmail.com");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement validateMessage = driver.findElement(By.id("confirmation_message"));
        Assert.assertEquals(validateMessage.getText(),"A link to reset your password has been sent to your email address.");
    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-2
        Leave username empty
        Leave password empty
        Click on the “LOGIN” button
        Validate the failure message is displayed as “Invalid Username entered!” above the form
     */
    @Test
    public void validateTheInvalidLoginWithEmptyCredentials(){
        WebElement loginButton = driver.findElement(By.id("login_btn"));

        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertEquals(errorMessage.getText(),"Invalid Username entered!");
    }

    /*
        Enter the username as “John”
        Enter the password as “Test1234”
        Click on the “LOGIN” button
        Validate the failure message is displayed as “Invalid Username entered!” above the form
     */
    @Test
    public void validateInvalidLoginWithWrongUserName(){
        WebElement userInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));

        userInput.sendKeys("John");
        passwordInput.sendKeys("Test1234");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertEquals(errorMessage.getText(),"Invalid Username entered!");
    }

    /*
        Enter the username as “TechGlobal”
        Enter the password as “1234”
        Click on the “LOGIN” button
        Validate the failure message is displayed as “Invalid Password entered!” above the form
     */
    @Test
    public void validateInvalidLoginWithWrongPassword(){
        WebElement userInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));

        userInput.sendKeys("TechGlobal");
        passwordInput.sendKeys("1234");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertEquals(errorMessage.getText(),"Invalid Password entered!");
    }
    /*
        Enter the username as “John”
        Enter the password as “1234”
        Click on the “LOGIN” button
        Validate the failure message is displayed as “Invalid Username entered!” above the form
     */

    @Test
    public void validateTheInvalidLoginWithWrongUserNameAndPassword(){
        WebElement userInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_btn"));

        userInput.sendKeys("John");
        passwordInput.sendKeys("1234");
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("error_message"));
        Assert.assertEquals(errorMessage.getText(),"Invalid Username entered!");
    }



}
