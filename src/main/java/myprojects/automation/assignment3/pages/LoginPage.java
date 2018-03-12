package myprojects.automation.assignment3.pages;

import myprojects.automation.assignment3.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * For login page.
 */
public class LoginPage {
    private WebDriver webDriver;

    private By emailInput = By.id ("email");
    private By passInput = By.id ("passwd");
    private By loginBtn = By.name ("submitLogin");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void open() {
        webDriver.get(Properties.getBaseAdminUrl());
    }

    public void fillEmailInput(String email) {
        webDriver.findElement(emailInput).sendKeys(email);
    }

    public void fillPasswordInput(String password) {
        webDriver.findElement(passInput).sendKeys(password);
    }

    public void clickLoginButton() {
        webDriver.findElement(loginBtn).click ();
    }
}
