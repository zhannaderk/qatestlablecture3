package myprojects.automation.assignment3.tests;

import myprojects.automation.assignment3.BaseScript;
import myprojects.automation.assignment3.GeneralActions;
import myprojects.automation.assignment3.pages.CategoryPage;
import org.openqa.selenium.WebDriver;

public class CreateCategoryTest extends BaseScript {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = null;
        try {
            driver = getConfiguredDriver();
            GeneralActions generalActions = new GeneralActions(driver);
            generalActions.login("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw");
            generalActions.createCategory("Category8080");

        } finally {
            if (driver != null) {
                driver.close();
            }
        }
    }
}
