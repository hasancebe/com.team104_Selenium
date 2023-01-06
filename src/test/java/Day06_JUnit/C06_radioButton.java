package Day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_radioButton {

    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void test01(){
        //Verilen web sayfasına gidin.
        //https://facebook.com
        driver.get("https://facebook.com/");
        //b. Cookies’i kabul edin
        //c. Create an account buton’una basin
       driver.findElement(By.xpath("//a[@rel='async']")).click();



        //d. Radio button elementlerini locate edin ve size uygun olani secin
        driver.findElement(By.xpath("//input[@value='2']")).click();




    }

}
