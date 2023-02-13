import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AddRemoveElements {
    private static final String ADD_REMOVE_DELETE = "//a[@href='/add_remove_elements/']";
    private static final String ADD_ELEMENT = "//button[@onclick='addElement()']";
    private static final String DELETE = "//button[@onclick='deleteElement()']";
    @Test
    public void addRemoveElements(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.xpath(String.format(ADD_REMOVE_DELETE))).click();
        WebElement buttonClick = driver.findElement(By.xpath(String.format(ADD_ELEMENT)));
        buttonClick.click();
        buttonClick.click();
        driver.findElement(By.xpath(String.format(DELETE))).click();
        var count= driver.findElements(By.xpath(String.format(DELETE))).stream().count();
        System.out.println("Количестов элементов Delete: " + count);
        driver.quit();
    }
}
