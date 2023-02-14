package HerokuApp;

import framework.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NotificationMessages extends BaseTest {
    private static final String NOTIFIC_MESSAGE = "//a[@href='/notification_message']";
    private static final String CLICK_HERE = "//a[@href='/notification_message']";
    private static final String MESSAGE = "//div[@class='flash notice']";
    @Test
    public void notificationMessages(){
        driver.findElement(By.xpath(String.format(NOTIFIC_MESSAGE))).click();
        String message = driver.findElement(By.xpath(String.format(MESSAGE))).getText();
        driver.findElement(By.xpath(String.format(CLICK_HERE))).click();
        String message2 = driver.findElement(By.xpath(String.format(MESSAGE))).getText();
        while (!message.contentEquals(message2)){
            driver.findElement(By.xpath(String.format(CLICK_HERE))).click();
            message2 = driver.findElement(By.xpath(String.format(MESSAGE))).getText();
        }
    }
}
