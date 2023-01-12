package Day11_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Collections;
import java.util.List;

public class C02_Tables extends TestBase {
    @Test

    public void test01() {
        //1- Amazon anasayfaya gidin
        driver.get("https://amazon.com/");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END);

        ReusableMethods.wait(4);

        List<WebElement> rowNumber= (driver.findElements(By.xpath("//table//tr")));
        System.out.println(rowNumber.size());
        Assert.assertEquals(10,rowNumber.size());
        for (WebElement each:rowNumber
             ) {
            System.out.println(each.getText());
        }

        List<WebElement>column5Elements=driver.findElements(By.xpath("//table//tr/td[5]"));
        for (WebElement each:column5Elements
             ) {
            System.out.println(each.getText());
        }


    }
}