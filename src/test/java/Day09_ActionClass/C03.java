package Day09_ActionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C03 extends TestBase {
    @Test
    public void test01(){
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com");

        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //mouse’u bu menunun ustune getirin
        Actions actions=new Actions(driver);
        WebElement account_List= driver.findElement(By.xpath("//span[@ class='nav-line-2 ']"));
        //account_List.click();
        actions.moveToElement(account_List).perform();
        ReusableMethods.wait(5);
        //3- “Create a list” butonuna basin
       WebElement createList= driver.findElement(By.xpath("//span[text()='Create a List']"));
        createList.click();

        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        String firstwindowHandleMenu=driver.getWindowHandle();
        String secondWHM="";
        Set<String> allHandleMenu=driver.getWindowHandles();
        for (String each:allHandleMenu
        ) {
            if(!each.equals(firstwindowHandleMenu)){
                secondWHM=each;
            }
        }
        driver.switchTo().window(secondWHM);
        WebElement text2=driver.findElement(By.xpath("//div[@role='heading']"));
        String actualText2=text2.getText();
        String expectedText2="Your Lists";
        Assert.assertEquals(actualText2,expectedText2);

    }
}
