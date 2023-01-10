package Day09_ActionClass;

import org.apache.hc.core5.util.Asserts;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import javax.swing.*;

public class C02 extends TestBase {
    @Test
    public void test01(){
        //1- https://demoqa.com/droppable adresine gidelim

        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim

        Actions actions=new Actions(driver);
        WebElement dragButton= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropButton=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(dragButton,dropButton).perform();
        ReusableMethods.wait(5);
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String actualStr=driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
        String expectedStr="Dropped!";
        Assert.assertEquals(actualStr,expectedStr);
    }
}
