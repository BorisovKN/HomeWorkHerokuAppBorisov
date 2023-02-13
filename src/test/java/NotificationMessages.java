import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NotificationMessages {
    private static final String NOTIFIC_MESSAGE = "//a[@href='/notification_message']";
    private static final String CLICK_HERE = "//a[@href='/notification_message']";
    private static final String MESSAGE = "//div[@class='flash notice']";
    @Test
    public void notificationMessages(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.xpath(String.format(NOTIFIC_MESSAGE))).click();
        String message = driver.findElement(By.xpath(String.format(MESSAGE))).getText();
        driver.findElement(By.xpath(String.format(CLICK_HERE))).click();
        String message2 = driver.findElement(By.xpath(String.format(MESSAGE))).getText();
        while (!message.contentEquals(message2)){
            driver.findElement(By.xpath(String.format(CLICK_HERE))).click();
            message2 = driver.findElement(By.xpath(String.format(MESSAGE))).getText();
        }
        driver.quit();
    }
}
