import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestPreconditions {
    private static final String demoQa= "https://demoqa.com/";

    public WebDriver openDemoQA() {
        WebDriver driver = new FirefoxDriver();
        driver.get(demoQa);
        System.out.println(driver.getTitle());
        return driver;
    }
}