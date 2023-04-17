@Test
public void testUnsuccessfulLoginWithEmail() {

    // Launch the Evernote application
    driver.get("https://www.evernote.com/Login.action");

    // Enter invalid email in email field
    WebElement emailField = driver.findElement(By.id("username"));
    emailField.sendKeys("invalidEmail");

    // Enter the correct password in password field
    WebElement passwordField = driver.findElement(By.id("password"));
    passwordField.sendKeys("password");

    // Click on the sign-in button
    WebElement signInButton = driver.findElement(By.id("loginButton"));
    signInButton.click();

    // Verify the error message for invalid email
    WebElement errorMessage = driver.findElement(By.xpath("//div[@class='genericError']"));
    String expectedErrorMessage = "Invalid email address or password";
    String actualErrorMessage = errorMessage.getText();
    Assert.assertEquals(actualErrorMessage, expectedErrorMessage);

}
