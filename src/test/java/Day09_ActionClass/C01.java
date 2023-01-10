package Day09_ActionClass;

import org.apache.hc.core5.util.Asserts;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.util.Set;

public class C01 extends TestBase {
    @Test

    public void test01() {
        //Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapin
        WebElement linearea = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(linearea).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedText="You selected a context menu";
        String actualText=driver.switchTo().alert().getText();

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        String firstwindowHandleMenu=driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();
        String secondWHM="";
        Set<String> allHandleMenu=driver.getWindowHandles();
        for (String each:allHandleMenu
             ) {
            if(!each.equals(firstwindowHandleMenu)){
                secondWHM=each;
            }
        }

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        driver.switchTo().window(secondWHM);
        WebElement text2=driver.findElement(By.tagName("h1"));
        String actualText2=text2.getText();
        String expectedText2="Elemental Selenium";
        Assert.assertEquals(actualText2,expectedText2);




    }
}