import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestWidgetsSlider extends TestPreconditions {
    private WebDriver driver;

    @Test
    private void checkWidgetsSlider() {
        driver = openDemoQA();

        //click on Widgets
        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[4]")).click();

        scrollDown();
        //click on Slider
        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[4]")).click();

        //get default value from slider and check
        String actualDefaultSliderValue = getSliderValue();
        Assert.assertEquals(actualDefaultSliderValue, "25");

        //move the slider to 76 and check
        String actualSliderValue = sendSliderValue();
        Assert.assertEquals(actualSliderValue, "76");

        driver.close();
    }


    private void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

    private String getSliderValue() {
        return driver.findElement(By.xpath("//input[@id='sliderValue']")).getDomAttribute("value");
    }

    private String sendSliderValue() {
        WebElement slider = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/span[1]/input[1]"));

        int width = slider.getSize().getWidth();
        int value = (int) (width * 0.25);

        // Use Actions class to move the slider to 76
        Actions builder = new Actions(driver);
        builder.moveToElement(slider)
                .click()
                .dragAndDropBy(slider, value, 0)
                .release()
                .perform();
        return slider.getAttribute("value");
    }
}