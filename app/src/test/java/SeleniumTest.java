import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest {

    static WebDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
    }

    @AfterAll
    public static void teardown() {
        driver.quit();
    }

    @Test
    public void testSearch() {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();

        driver.findElement(By.id("search"));
        assertTrue(driver.getTitle().startsWith("Selenium WebDriver"));
    }

    @Test
    public void testGoogleLogoIsDisplayed() {
        WebElement logo = driver.findElement(By.xpath("//img[@alt='Google']"));
        assertTrue(logo.isDisplayed());
    }
}
