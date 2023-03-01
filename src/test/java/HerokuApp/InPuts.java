package HerokuApp;

import framework.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class InPuts extends BaseTest {
    private static final By INPUTS = By.xpath("//a[@href='/inputs']");
    private static final By INPUT = By.xpath("//input[@type='number']");

    @Test
    public void inPuts() {
        driver.findElement(INPUTS).click();
        WebElement input = driver.findElement(INPUT);
        input.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_UP, Keys.ARROW_UP, Keys.ARROW_DOWN, Keys.ARROW_UP);
        var value = driver.findElement(INPUT).getAttribute("value");
        assertEquals(value, "1");
        driver.navigate().refresh();
        WebElement inputText = driver.findElement(INPUT);
        inputText.sendKeys("qwrtyuioasfafhasfkvsd");
        var value1 = driver.findElement(INPUT).getAttribute("value");
        assertEquals(value1, "");
        driver.navigate().refresh();
        WebElement inputNumber = driver.findElement(INPUT);
        inputNumber.sendKeys("843344");
        var value2 = driver.findElement(INPUT).getAttribute("value");
        assertEquals(value2, "843344");
    }
}
