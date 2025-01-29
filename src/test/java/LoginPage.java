import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By usernameField = By.id("userName");
    private By tinField = By.id("tin");
    private By passwordField = By.id("password");
    private By loginButton = By.id("mainForm:loginBtn");
    private By continueButton = By.xpath("//form[@id='popupForm_notificationPanel']/input");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Login method
    public void login(String username, String tin, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(tinField).sendKeys(tin);
        driver.findElement(passwordField).sendKeys(password);

        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();

        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueBtn.click();
    }
}
