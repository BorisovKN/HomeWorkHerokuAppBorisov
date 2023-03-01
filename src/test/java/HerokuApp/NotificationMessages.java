package HerokuApp;

import framework.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NotificationMessages extends BaseTest {
    private static final By NOTIFIC_MESSAGE = By.xpath("//a[@href='/notification_message']");
    private static final By CLICK_HERE = By.xpath("//a[@href='/notification_message']");
    private static final By MESSAGE = By.xpath("//div[@class='flash notice']");
    @Test
    public void notificationMessages(){
        driver.findElement(NOTIFIC_MESSAGE).click();
        String message = driver.findElement(MESSAGE).getText();
        driver.findElement(CLICK_HERE).click();
        String message2 = driver.findElement(MESSAGE).getText();
        while (!message.contentEquals(message2)){
            driver.findElement(CLICK_HERE).click();
            message2 = driver.findElement(MESSAGE).getText();
        }
    }
}
