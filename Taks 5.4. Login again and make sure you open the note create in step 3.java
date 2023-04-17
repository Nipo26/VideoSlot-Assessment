@Test
public void testLoginOpenNote() {

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

    // Locate the previously created note in the note list and click on it to open
    WebElement noteTitle = driver.findElement(By.xpath("//span[text()='Test Note']"));
    noteTitle.click();

    // Verify that the note is opened by checking the note title and content
    WebElement noteTitleDisplayed = driver.findElement(By.xpath("//div[@class='editableTitleView']/h1"));
    Assert.assertTrue(noteTitleDisplayed.isDisplayed());

    WebElement noteContentDisplayed = driver.findElement(By.xpath("//div[@class='en-note-content']"));
    Assert.assertTrue(noteContentDisplayed.isDisplayed());

    // Close the note
    driver.navigate().back();

    // Click on the "Logout" button to log out of the Evernote application
    WebElement logoutButton = driver.findElement(By.id("gwt-debug-UserDropdown-menuButton"));
    logoutButton.click();

    WebElement signoutButton = driver.findElement(By.id("gwt-debug-UserDropdown-signout"));
    signoutButton.click();

    // Verify that the user is successfully logged out by checking if the user is directed to the login page
    String expectedLoginPageTitle = "Evernote Login";
    String actualLoginPageTitle = driver.getTitle();
    Assert.assertEquals(actualLoginPageTitle, expectedLoginPageTitle);

}
