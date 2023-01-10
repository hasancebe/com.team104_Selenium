package Day08_HandleWindow;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.awt.*;

import static org.junit.Assert.assertTrue;

public class C03_Iframe extends TestBase {
    @Test
    public void test01(){

        //https://the-internet.herokuapp.com/iframe adresine gidin.

        driver.get("https://the-internet.herokuapp.com/iframe");
        //2 ) Bir metod olusturun: iframeTest
        //- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve
        //konsolda yazdirin.

        WebElement text= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(text.isEnabled());
        System.out.println(text.getText());


        //- Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframeElement= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeElement);


        WebElement textBox= driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya");

        ReusableMethods.wait(5);
        //- TextBox’in altinda bulunan “Elemental Selenium” linkini textinin
        //gorunur oldugunu dogrulayin ve konsolda yazdirin.
        driver.switchTo().defaultContent();
        WebElement text2=driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(text2.isDisplayed());
    }
}
