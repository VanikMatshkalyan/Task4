import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Task4 {
    static WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void Login() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://uatfile-online.taxservice.am/pages/loginPage.jsf");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement userName = driver.findElement(By.id("userName"));
        String searchName = "test";
        userName.sendKeys(searchName);

        WebElement userTin = driver.findElement(By.id("tin"));
        String searchTin = "32425955";
        userTin.sendKeys(searchTin);

        WebElement userPass = driver.findElement(By.id("password"));
        String searchPass = "LBw0FE31";
        userPass.sendKeys(searchPass);


        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("mainForm:loginBtn")));
        loginButton.click();

        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='popupForm_notificationPanel']/input")));
        continueButton.click();
    }

    @Test
    public static void TC4() throws InterruptedException {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement menuLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("menuLink_2")));
            menuLink.click();

            WebElement menuLink259 = driver.findElement(By.xpath("//*[@id=\"ia\"]"));
            menuLink259.click();


            WebElement selectCombo = driver.findElement(By.id("mainForm:activityCodeSelected"));
            Select select = new Select(selectCombo);
            select.selectByIndex(1);

            WebElement addCombo = driver.findElement(By.id("mainForm:j_id78"));
            addCombo.click();

            LocalDate firstDayNextMonth = LocalDate.now().plusMonths(1).withDayOfMonth(1);
            String firstDayFormatted = firstDayNextMonth.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            WebElement firstDayInput = driver.findElement(By.id("mainForm:f_activityPatentList:0:f_startDateInputDate"));
            firstDayInput.sendKeys(firstDayFormatted);


            LocalDate lastDayNextMonth = firstDayNextMonth.withDayOfMonth(firstDayNextMonth.lengthOfMonth());
            String lastDayFormatted = lastDayNextMonth.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            WebElement lastDayInput = driver.findElement(By.id("mainForm:f_activityPatentList:0:f_endDateInputDate"));
            lastDayInput.sendKeys(lastDayFormatted);

            WebElement calculateIcon = driver.findElement(By.id("mainForm:f_activityPatentList:0:j_id145"));
            calculateIcon.click();

                Thread.sleep(2000);
                WebElement registerButton = driver.findElement(By.id("mainForm:generatePDF"));
                registerButton.click();

    }
}
