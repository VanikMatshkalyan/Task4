import org.testng.annotations.Test;

public class TaskTest extends BaseTest {

    @Test
    public void testTask4() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("test", "32425955", "LBw0FE31");

        TaskPage taskPage = new TaskPage(driver);
        taskPage.performTask();
    }
}
