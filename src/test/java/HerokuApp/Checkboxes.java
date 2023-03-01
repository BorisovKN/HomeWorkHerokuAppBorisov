package HerokuApp;

import framework.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Checkboxes extends BaseTest {
    private static final By CHECKBOXES = By.xpath("//a[@href='/checkboxes']");
    @Test
    public void checkboxes(){
        driver.findElement(CHECKBOXES).click();
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        assertFalse(checkBoxes.get(0).isSelected(), "the 1st checkbox is unchecked");
        checkBoxes.get(0).click();
        assertTrue(checkBoxes.get(0).isSelected(), "the 1st checkbox is checked");
        assertTrue(checkBoxes.get(1).isSelected(), "the 2nd checkbox is checked");
        checkBoxes.get(1).click();
        assertFalse(checkBoxes.get(1).isSelected(), "the 2nd checkbox is unchecked");
    }
}
