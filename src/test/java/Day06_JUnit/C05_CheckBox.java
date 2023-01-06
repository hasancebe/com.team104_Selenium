package Day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_CheckBox {
    //a. Verilen web sayfasına gidin.
    //https://the-internet.herokuapp.com/checkboxes


    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    //b. Checkbox1 ve checkbox2 elementlerini locate edin.
    //c. Checkbox1 seçili değilse onay kutusunu tıklayın
    //d. Checkbox2 seçili değilse onay kutusunu tıklayın
    @Test
    public void chechkbox() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement chechkbox1= driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement chechkbox2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        if(!chechkbox1.isSelected()){
            chechkbox1.click();
        }
        Assert.assertTrue(chechkbox1.isSelected());

        if(!chechkbox2.isSelected()){
            chechkbox2.click();
        }
        Assert.assertTrue(chechkbox2.isSelected());

        Thread.sleep(5000);

    }
}
