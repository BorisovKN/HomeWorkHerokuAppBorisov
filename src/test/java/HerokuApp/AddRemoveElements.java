package HerokuApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import framework.BaseTest;

public class AddRemoveElements extends BaseTest {
    private static final By ADD_REMOVE_DELETE = By.xpath("//a[@href='/add_remove_elements/']");
    private static final By ADD_ELEMENT = By.xpath("//button[@onclick='addElement()']");
    private static final By DELETE = By.xpath("//button[@onclick='deleteElement()']");
    @Test
    public void addRemoveElements(){
        driver.findElement(ADD_REMOVE_DELETE).click();
        WebElement buttonClick = driver.findElement(ADD_ELEMENT);
        buttonClick.click();
        buttonClick.click();
        driver.findElement(DELETE).click();
        var count= driver.findElements(DELETE).stream().count();
        System.out.println("Количестов элементов Delete: " + count);
    }
}
