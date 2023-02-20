import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestPracticeForm {

    @Test
    public void fillPracticeForm() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }

}
