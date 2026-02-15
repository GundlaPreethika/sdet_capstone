package cap.cap.Stepdef;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.AppBase;
import cap.cap.Page.CommunityPage;
import cap.cap.Page.DownloadPage;
import cap.cap.Page.HomePage;

public class WordPressSteps extends AppBase {

    HomePage home;
    DownloadPage download;
    CommunityPage community;

    @BeforeClass
    public void setUpTest() {
        setup();                       // Launch browser
        home = new HomePage(driver);   // Initialize HomePage
    }

    @Test(priority = 1)
    public void verifyTitle() {
        String title = home.getPageTitle();
        System.out.println("Page Title: " + title);

        Assert.assertTrue(
                title.toLowerCase().contains("wordpress"),
                "Home page title does not contain 'WordPress'"
        );
    }

    @Test(priority = 2)
    public void verifyGetWordPressNavigation() {

        home.clickGetWordPress();
        download = new DownloadPage(driver);

        String heading = download.getHeadingText();
        System.out.println("Download Page Heading: " + heading);

        Assert.assertTrue(
                heading.toLowerCase().contains("wordpress")
                        || heading.toLowerCase().contains("download"),
                "Download page heading validation failed"
        );
    }

    @Test(priority = 3)
    public void verifyPhotoSearch() {

        home.clickPhotoDirectory();
        community = new CommunityPage(driver);

        community.searchPhoto("nature");

        boolean imagesDisplayed = community.isImagesDisplayed();
        System.out.println("Images displayed: " + imagesDisplayed);

        Assert.assertTrue(
                imagesDisplayed,
                "Images are not displayed after searching"
        );
    }

    @AfterClass
    public void tearDownTest() {
        tearDown();   // Close browser
    }
}