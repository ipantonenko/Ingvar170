import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class TestAlertsFrameWindows extends TestPreconditions {

    private WebDriver driver;
    private String expectedResult = "This is a sample page";
    private String mainWindowHandle;
    private Set<String> allWindowHandles;

    @Test
    public void fillPracticeForm() {
        driver = openDemoQA();
        mainWindowHandle = driver.getWindowHandle();
        //click on Alerts, Frame & Windows button
        driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]")).click();
        //click on Browser Windows point
        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[1]/*[1]")).click();
        //click on New Tab button
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();

        // Switch to the second Sample window
        switchToSampleWindow();

        //check text
        String actualResult = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
        Assert.assertEquals(actualResult, expectedResult);
        closeWindows(allWindowHandles);
    }

    public void closeWindows(Set<String> windowHandle) {
        for (String handle : allWindowHandles) {
            if (!handle.equals(windowHandle)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }
    }

    public void switchToSampleWindow() {
        allWindowHandles = driver.getWindowHandles();
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }
}
