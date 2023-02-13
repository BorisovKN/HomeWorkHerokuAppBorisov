import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class InPuts {
    private static final String INPUTS = "//a[@href='/inputs']";
    private static final String INPUT = "//input[@type='number']";

    @Test
    public void inPuts() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.xpath(String.format(INPUTS))).click();
        WebElement input = driver.findElement(By.xpath(String.format(INPUT)));
        input.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_UP, Keys.ARROW_UP, Keys.ARROW_DOWN, Keys.ARROW_UP);
        var value = driver.findElement(By.xpath(String.format(INPUT))).getAttribute("value");
        assertEquals(value, "1");
        driver.navigate().refresh();
        WebElement inputText = driver.findElement(By.xpath(String.format(INPUT)));
        inputText.sendKeys("qwrtyuioasfafhasfkvsd");
        var value1 = driver.findElement(By.xpath(String.format(INPUT))).getAttribute("value");
        assertEquals(value1, "");
        driver.navigate().refresh();
        WebElement inputNumber = driver.findElement(By.xpath(String.format(INPUT)));
        inputNumber.sendKeys("843344");
        var value2 = driver.findElement(By.xpath(String.format(INPUT))).getAttribute("value");
        assertEquals(value2, "843344");
        driver.quit();
    }
}
