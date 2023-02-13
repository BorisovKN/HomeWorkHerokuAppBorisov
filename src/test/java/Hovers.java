import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class Hovers {
    private static final String HOVERS = "//a[@href='/hovers']";
    private static final String FIRSTUSER = "//div[@id='content']//descendant::div[@class='figure'][1]";
    private static final String SECONDUSER = "//div[@id='content']//descendant::div[@class='figure'][2]";
    private static final String THIRDUSER = "//div[@id='content']//descendant::div[@class='figure'][3]";
    private static final String FIRSTNAMEUSER = "//h5[text()='name: user1']";
    private static final String SECONDNAMEUSER = "//h5[text()='name: user2']";
    private static final String THIRDNAMEUSER = "//h5[text()='name: user3']";
    private static final String LINKFIRSTUSER = "//h5[text()='name: user1']/following-sibling::a";
    private static final String LINKSECONDUSER = "//h5[text()='name: user2']/following-sibling::a";
    private static final String LINKTHIRDUSER = "//h5[text()='name: user3']/following-sibling::a";
    private static final String NOTFOUND = "//h1[text()='Not Found']";
    @Test
    public void hovers(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.xpath(String.format(HOVERS))).click();
        Actions actions = new Actions(driver);
        WebElement firstUser = driver.findElement(By.xpath(String.format(FIRSTUSER)));
        actions.moveToElement(firstUser).build().perform();
        WebElement firstNameUser = driver.findElement(By.xpath(String.format(FIRSTNAMEUSER)));
        WebElement linkFirstUser = driver.findElement(By.xpath(String.format(LINKFIRSTUSER)));
        Assert.assertTrue(firstNameUser.isDisplayed());
        linkFirstUser.click();
        WebElement page = driver.findElement(By.xpath(String.format(NOTFOUND)));
        Assert.assertTrue(page.isDisplayed());
        driver.navigate().back();
        WebElement secondUser = driver.findElement(By.xpath(String.format(SECONDUSER)));
        actions.moveToElement(secondUser).build().perform();
        WebElement secondNameUser = driver.findElement(By.xpath(String.format(SECONDNAMEUSER)));
        WebElement linkSecondUser = driver.findElement(By.xpath(String.format(LINKSECONDUSER)));
        Assert.assertTrue(secondNameUser.isDisplayed());
        linkSecondUser.click();
        WebElement page2 = driver.findElement(By.xpath(String.format(NOTFOUND)));
        Assert.assertTrue(page2.isDisplayed());
        driver.navigate().back();
        WebElement thirdUser = driver.findElement(By.xpath(String.format(THIRDUSER)));
        actions.moveToElement(thirdUser).build().perform();
        WebElement thirdNameUser = driver.findElement(By.xpath(String.format(THIRDNAMEUSER)));
        WebElement linkThirdUser = driver.findElement(By.xpath(String.format(LINKTHIRDUSER)));
        Assert.assertTrue(thirdNameUser.isDisplayed());
        linkThirdUser.click();
        WebElement page3 = driver.findElement(By.xpath(String.format(NOTFOUND)));
        Assert.assertTrue(page3.isDisplayed());
        driver.quit();
    }
}
