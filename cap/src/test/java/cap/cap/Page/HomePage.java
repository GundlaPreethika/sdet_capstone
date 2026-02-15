package cap.cap.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    By downloadExtend = By.linkText("Extend");
//    By getWordPress = By.partialLinkText("Get WordPress");
    By getWordPressButton = By.xpath("/html/body/div/header/div/a");
    
    By community = By.linkText("Community");
    By photoDirectory = By.linkText("Photo Directory");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clickGetWordPress() {

        Actions act = new Actions(driver);
        act.moveToElement(wait.until(
                ExpectedConditions.visibilityOfElementLocated(downloadExtend)))
                .perform();

        wait.until(ExpectedConditions.elementToBeClickable(getWordPressButton)).click();
    }

    public void clickPhotoDirectory() {

        Actions act = new Actions(driver);
        act.moveToElement(wait.until(
                ExpectedConditions.visibilityOfElementLocated(community)))
                .perform();

        wait.until(ExpectedConditions.elementToBeClickable(photoDirectory)).click();
    }
}