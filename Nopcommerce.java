import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 *
 /Project-1 - ProjectName : com-nopcommerce
 BaseUrl = https://demo.nopcommerce.com/
 1. Setup chrome browser.
 2. Open URL.
 3. Print the title of the page.
 4. Print the current url.
 5. Print the page source.
 6. Navigate to Url.
 “https://demo.nopcommerce.com/login?returnUrl=%2F”
 7. Print the current url.
 8. Navigate back to the home page.
 9. Navigate to the login page.
 10. Print the current url.
 11. Refresh the page.
 12. Enter the email to email field.
 13. Enter the password to password field.
 14. Click on Login Button.
 15. Close the browser.
 */
public class Nopcommerce
{
    static String browser = "Chrome";
    static String baseUrl = "https://demo.nopcommerce.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        //Setup chrome browser.
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Wrong Browser name");
        }

        // Open URL
        driver.get(baseUrl);
        Thread.sleep(4000);

        // Maximize the browser
        driver.manage().window().maximize();

        // we give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Print the title of the page
        String title = driver.getTitle();
        System.out.println(title);

        // Get current url
        System.out.println("The current Url " + driver.getCurrentUrl());

        // Print the page source.
        System.out.println(driver.getPageSource());

        // Navigate to Url.
        String loginUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        driver.get(loginUrl);
        Thread.sleep(4000);

        // Print the current url.
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(4000);

        // Navigate back to the home page.
        driver.navigate().back();
        Thread.sleep(4000);

        // Navigate to the login page.
        driver.navigate().to(loginUrl);
        Thread.sleep(4000);

        // Print the current url.
        System.out.println("Get current Url " + driver.getCurrentUrl());

        // Refresh the page.
        driver.navigate().refresh();

        // Enter the email to email field.
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("prime123@gmail.com");
        Thread.sleep(4000);

        // Enter the password to password field.
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("Prime123");
        Thread.sleep(4000);

        // Click on Login Button.
        WebElement loginButton = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        loginButton.click();
        Thread.sleep(4000);

        // Close the browser.
        driver.quit();
    }

}
