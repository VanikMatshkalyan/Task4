import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaskPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By menuLink = By.id("menuLink_2");
    private By menuLink259 = By.xpath("//*[@id=\"mainForm:declarations:73:j_id80\"]");
    private By activityCodeDropdown = By.id("mainForm:activityCodeSelected");
    private By addActivityButton = By.id("mainForm:j_id78");
    private By startDateInput = By.id("mainForm:f_activityPatentList:0:f_startDateInputDate");
    private By endDateInput = By.id("mainForm:f_activityPatentList:0:f_endDateInputDate");
    private By calculateIcon = By.id("mainForm:f_activityPatentList:0:j_id145");
    private By registerButton = By.id("mainForm:generatePDF");

    // Constructor
    public TaskPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    // Method to perform test steps
    public void performTask() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(menuLink)).click();
        driver.findElement(menuLink259).click();

        WebElement dropdown = driver.findElement(activityCodeDropdown);
        Select select = new Select(dropdown);
        select.selectByIndex(1);

        driver.findElement(addActivityButton).click();

        LocalDate firstDayNextMonth = LocalDate.now().plusMonths(1).withDayOfMonth(1);
        String firstDayFormatted = firstDayNextMonth.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        driver.findElement(startDateInput).sendKeys(firstDayFormatted);

        LocalDate lastDayNextMonth = firstDayNextMonth.withDayOfMonth(firstDayNextMonth.lengthOfMonth());
        String lastDayFormatted = lastDayNextMonth.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        driver.findElement(endDateInput).sendKeys(lastDayFormatted);

        driver.findElement(calculateIcon).click();

        Thread.sleep(2000);
        driver.findElement(registerButton).click();
    }
}
