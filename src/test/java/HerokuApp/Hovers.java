package HerokuApp;

import framework.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Hovers extends BaseTest {
    private static final By HOVERS = By.xpath("//a[@href='/hovers']");
    private static final By FIRSTUSER = By.xpath("//div[@id='content']//descendant::div[@class='figure'][1]");
    private static final By SECONDUSER = By.xpath("//div[@id='content']//descendant::div[@class='figure'][2]");
    private static final By THIRDUSER = By.xpath("//div[@id='content']//descendant::div[@class='figure'][3]");
    private static final By FIRSTNAMEUSER = By.xpath("//h5[text()='name: user1']");
    private static final By SECONDNAMEUSER = By.xpath("//h5[text()='name: user2']");
    private static final By THIRDNAMEUSER = By.xpath("//h5[text()='name: user3']");
    private static final By LINKFIRSTUSER = By.xpath("//h5[text()='name: user1']/following-sibling::a");
    private static final By LINKSECONDUSER = By.xpath("//h5[text()='name: user2']/following-sibling::a");
    private static final By LINKTHIRDUSER = By.xpath("//h5[text()='name: user3']/following-sibling::a");
    private static final By NOTFOUND = By.xpath("//h1[text()='Not Found']");
    @Test
    public void hovers(){
        driver.findElement(HOVERS).click();
        Actions actions = new Actions(driver);
        WebElement firstUser = driver.findElement(FIRSTUSER);
        actions.moveToElement(firstUser).build().perform();
        WebElement firstNameUser = driver.findElement(FIRSTNAMEUSER);
        WebElement linkFirstUser = driver.findElement(LINKFIRSTUSER);
        Assert.assertTrue(firstNameUser.isDisplayed());
        linkFirstUser.click();
        WebElement page = driver.findElement(NOTFOUND);
        Assert.assertTrue(page.isDisplayed());
        driver.navigate().back();
        WebElement secondUser = driver.findElement(SECONDUSER);
        actions.moveToElement(secondUser).build().perform();
        WebElement secondNameUser = driver.findElement(SECONDNAMEUSER);
        WebElement linkSecondUser = driver.findElement(LINKSECONDUSER);
        Assert.assertTrue(secondNameUser.isDisplayed());
        linkSecondUser.click();
        WebElement page2 = driver.findElement(NOTFOUND);
        Assert.assertTrue(page2.isDisplayed());
        driver.navigate().back();
        WebElement thirdUser = driver.findElement(THIRDUSER);
        actions.moveToElement(thirdUser).build().perform();
        WebElement thirdNameUser = driver.findElement(THIRDNAMEUSER);
        WebElement linkThirdUser = driver.findElement(LINKTHIRDUSER);
        Assert.assertTrue(thirdNameUser.isDisplayed());
        linkThirdUser.click();
        WebElement page3 = driver.findElement(NOTFOUND);
        Assert.assertTrue(page3.isDisplayed());
    }
}
