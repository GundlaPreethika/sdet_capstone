package cap.cap.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class DownloadPage {

    WebDriver driver;
    WebDriverWait wait;

    By heading = By.tagName("h1");

    public DownloadPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String getHeadingText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(heading));
        return driver.findElement(heading).getText();
    }
}