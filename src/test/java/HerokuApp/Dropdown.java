package HerokuApp;

import framework.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Dropdown extends BaseTest {
    private static final String DROPDOWN = "//a[@href='/dropdown']";
    private static final String LIST = "//select[@id='dropdown']";
    private static final String VALUE1 = "//select[@id='dropdown']//option[@value='1']";
    private static final String VALUE2 = "//select[@id='dropdown']//option[@value='2']";
    @Test
    public void dropdown(){
        driver.findElement(By.xpath(String.format(DROPDOWN))).click();
        driver.findElement(By.xpath(String.format(LIST))).click();
        var value = driver.findElement(By.xpath(String.format(VALUE1,VALUE2))).isDisplayed();
        System.out.println("Элементы оторбражаются " + value);
        driver.findElement(By.xpath(String.format(VALUE1))).click();
        var value1 = driver.findElement(By.xpath(String.format(VALUE1))).isSelected();
        System.out.println("Элемент Option 1 оторбражается " + value1);
        driver.findElement(By.xpath(String.format(LIST))).click();
        driver.findElement(By.xpath(String.format(VALUE2))).click();
        var value2 = driver.findElement(By.xpath(String.format(VALUE2))).isSelected();
        System.out.println("Элемент Option 2 оторбражается " + value2);
    }
}
