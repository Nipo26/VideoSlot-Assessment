@Test
public void testSuccessfulLoginWithEmail() {

    // Launch the Evernote application
    driver.get("https://www.evernote.com/Login.action");

    // Enter valid email in email field
    WebElement emailField = driver.findElement(By.id("username"));
    emailField.sendKeys("validEmail@example.com");

    // Enter the correct password in password field
    WebElement passwordField = driver.findElement(By.id("password"));
    passwordField.sendKeys("password");

    // Click on the sign-in button
    WebElement signInButton = driver.findElement(By.id("loginButton"));
    signInButton.click();

    // Verify the successful login by checking the URL of the homepage
    String expectedURL = "https://www.evernote.com/Home.action";
    String actualURL = driver.getCurrentUrl();
    Assert.assertEquals(actualURL, expectedURL);

}
