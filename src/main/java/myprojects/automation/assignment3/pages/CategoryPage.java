package myprojects.automation.assignment3.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

@Getter
public class CategoryPage {

    private WebDriver driver;

    private By catalogItem = By.id("subtab-AdminCatalog");
    private By categorySubmenu = By.id ("subtab-AdminCategories");
    private By addCategory = By.xpath("//*[@id=\"page-header-desc-category-new_category\"]/div");
    private By catNameInput = By.id ("name_1");
    private By saveBtn = By.id("category_form_submit_btn");
    private By created = By.className("alert-success");
    private By createdCatName = By.name("categoryFilter_name");
    private By searchBtn = By.id("submitFilterButtoncategory");
    private By tableBody = By.xpath("//*[@id=\"table-category\"]/tbody");

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCategorySubmenu () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(catalogItem));
        WebElement catalogElement = driver.findElement(catalogItem);
        Actions actions = new Actions(driver);
        actions.moveToElement(catalogElement).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(categorySubmenu));
        driver.findElement(categorySubmenu).click();
    }

    public void clickOnAddCategoryButton() {
        driver.findElement(addCategory).click();
    }

    public void fillCategoryName(String categoryName) {
        driver.findElement(catNameInput).sendKeys(categoryName);
    }

    public void saveCategory() {
        driver.findElement(saveBtn).click();
    }

    public void fillCreatedCatName(String categoryName){
        driver.findElement(createdCatName).sendKeys(categoryName);
    }

    public void clickSearchButton() {
        driver.findElement(searchBtn).click();
    }

    public void findCreatedCategory(String categoryName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(createdCatName).sendKeys(categoryName);
        driver.findElement(searchBtn).click();
        wait.until(ExpectedConditions.titleIs(categoryName));
    }
}
