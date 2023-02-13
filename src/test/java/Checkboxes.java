import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class Checkboxes {
    private static final String CHECKBOXES = "//a[@href='/checkboxes']";
    @Test
    public void checkboxes(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.xpath(String.format(CHECKBOXES))).click();
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        assertFalse(checkBoxes.get(0).isSelected(), "the 1st checkbox is unchecked");
        checkBoxes.get(0).click();
        assertTrue(checkBoxes.get(0).isSelected(), "the 1st checkbox is checked");
        assertTrue(checkBoxes.get(1).isSelected(), "the 2nd checkbox is checked");
        checkBoxes.get(1).click();
        assertFalse(checkBoxes.get(1).isSelected(), "the 2nd checkbox is unchecked");
        driver.quit();
    }
}
