@Test
public void testLoginWriteNoteLogout() {

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

    // Click on the "New Note" button to create a new note
    WebElement newNoteButton = driver.findElement(By.id("gwt-debug-NoteAttributesView-add-tag"));
    newNoteButton.click();

    // Enter the title and content of the note in the respective fields
    WebElement noteTitle = driver.findElement(By.id("gwt-debug-NoteTitleView-textBox"));
    noteTitle.sendKeys("Test Note");

    WebElement noteContent = driver.findElement(By.id("gwt-debug-NoteContentEditView-textarea"));
    noteContent.sendKeys("This is a test note.");

    // Click on the "Save" button to save the note
    WebElement saveButton = driver.findElement(By.id("gwt-debug-NoteAttributesView-save"));
    saveButton.click();

    // Verify that the note is successfully saved by checking if it appears in the note list
    WebElement noteList = driver.findElement(By.id("gwt-debug-NoteList-listView"));
    Assert.assertTrue(noteList.isDisplayed());

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
