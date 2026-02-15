package cap.cap.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;

public class CommunityPage {

    WebDriver driver;
    WebDriverWait wait;

    By searchBox = By.id("wp-block-search__input-8");
    By resultList = By.cssSelector("ul.wp-block-post-template");
    By resultItems = By.cssSelector("ul.wp-block-post-template > li.wp-block-post");


    public CommunityPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void searchPhoto(String picName) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(picName);
        driver.findElement(searchBox).submit();
        
        // Wait until UL container is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultList));

        // Wait until at least 1 LI loads
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(resultItems, 0));


    }

    public boolean isImagesDisplayed() {

        List<WebElement> items = driver.findElements(resultItems);

        System.out.println("Total Images Found: " + items.size());

        return items.size() > 0;
    }
}