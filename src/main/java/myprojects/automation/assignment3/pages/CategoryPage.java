package myprojects.automation.assignment3.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@Getter
public class CategoryPage {

    private WebDriver driver;

    private By catalogItem = By.xpath("//*[@id=\"subtab-AdminCatalog\"]/a/span");
    private By categorySubmenu = By.id ("subtab-AdminParentCustomerThreads");
    private By addCategory = By.xpath("//*[@id=\"page-header-desc-category-new_category\"]/div");
    private By catName = By.id ("name_1");
    private By saveBtn = By.className("ps_back-office page-sidebar admincategories");
    private String categoryName = "Category1";
    private By created = By.xpath("//*[@id=\"content\"]/div[3]/div");
    private By createdCatName = By.name("categoryFilter_name");
    private By searchBtn = By.id("submitFilterButtoncategory");

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnCatalogItem() {
        driver.findElement(catalogItem).click();
    }

    public void clickOnCategoryItem() {
        driver.findElement(categorySubmenu).click();
    }

    public void clickOnAddCategoryButton() {
        driver.findElement(addCategory).click();
    }

    public void createCategory(String categoryName) {

        driver.findElement(catName).sendKeys(categoryName);
        driver.findElement(saveBtn).click();
        driver.findElement(created).isDisplayed();

        driver.findElement(createdCatName).sendKeys(categoryName);
        driver.findElement(searchBtn).click();
        Assert.assertEquals(categoryName, driver.getTitle());

    }
}
