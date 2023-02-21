import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPracticeForm {

    @Test
    public void fillPracticeForm() {
        String expectedResult = "Thanks for submitting the form";
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        System.out.println(driver.getTitle());

        //click on form button
        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]")).click();

        //click on Practice Form
        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]")).click();

        //click on firstName input and enter test data
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("test_name");

        //click on lastName input and enter test data
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("test_name_2");

        //click on email input
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("test@email.top");

        //click on Male radio button
        driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();

        //click on mobile input
        driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys("1234567891");

        // Find the element containing the advertisement
        WebElement adElement = driver.findElement(By.xpath("//div[@id='fixedban']"));

        // Hide the element using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", adElement);

        // Find the element containing the advertisement 2
        WebElement adElement2 = driver.findElement(By.xpath("//body/div[@id='app']/footer[1]"));

        // Hide the element using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", adElement2);

        //click on Submit button
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        //check text
        String actualResult = driver.findElement(By.xpath("//div[@id='example-modal-sizes-title-lg']")).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
