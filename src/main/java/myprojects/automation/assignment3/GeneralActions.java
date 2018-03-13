package myprojects.automation.assignment3;

import myprojects.automation.assignment3.pages.CategoryPage;
import myprojects.automation.assignment3.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {

    private WebDriver driver;
    private WebDriverWait wait;


    public GeneralActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    /**
     * Logs in to Admin Panel.
     * @param login
     * @param password
     */
    public void login(String login, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.fillEmailInput(login);
        loginPage.fillPasswordInput(password);
        loginPage.clickLoginButton();
    }


    /**
     * Adds new category in Admin Panel.
     * @param categoryName
     */
    public void createCategory(String categoryName) {
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.clickCategorySubmenu();
        categoryPage.clickOnAddCategoryButton();
        categoryPage.fillCategoryName(categoryName);
        categoryPage.saveCategory();
        Assert.assertTrue(ExpectedConditions.presenceOfElementLocated(categoryPage.getCreated()).apply(driver).isDisplayed());
        categoryPage.fillCreatedCatName(categoryName);
        categoryPage.clickSearchButton();
        Assert.assertTrue(ExpectedConditions.textToBePresentInElementLocated(categoryPage.getTableBody(), categoryName).apply(driver));


    }

    /**
     * Waits until page loader disappears from the page
     */
    public void waitForContentLoad(By loader) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(loader)));
    }
}
