package Day08_HandleWindow;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.time.Duration;
import java.util.Set;

public class C02_WindowHandle {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
@Test
    public void test01() throws InterruptedException {


        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
   // String firstTab="https://the-internet.herokuapp.com/windows";

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualTextElement= driver.findElement(By.tagName("h3")).getText();
        String expectedTextElement="Opening a new window";
        Assert.assertEquals(actualTextElement,expectedTextElement);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitlle="The Internet";
        String actualTitle= driver.getTitle();
        System.out.println(actualTitle);
        String firstPageHandleValue=driver.getWindowHandle();
        Assert.assertEquals(actualTitle,expectedTitlle);



        //● Click Here butonuna basın.
        driver.findElement(By.xpath("(//a[@target='_blank'])[1]")).click();

    Set<String>allWindowHandleValues=driver.getWindowHandles();
    String secondPageWindowHandleValue="";
    for (String each:allWindowHandleValues
         ) {
        if(!each.equals(firstPageHandleValue)){
            secondPageWindowHandleValue=each;
        }
    }

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu
        //dogrulayin.
    driver.switchTo().window(secondPageWindowHandleValue);
    String expectedNewTitlle="New Window";
    String actualNewTitle= driver.getTitle();
    System.out.println(actualTitle);
    Assert.assertEquals(actualNewTitle,expectedNewTitlle);


        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    String expectedTextNewWindow="New Window";
    WebElement TextNewWindow= driver.findElement(By.tagName("h3"));
    String actualTextNewWindow=TextNewWindow.getText();
    Assert.assertEquals(expectedNewTitlle,actualTextNewWindow);


        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet”
        //olduğunu doğrulayın.
    driver.switchTo().window(firstPageHandleValue);
        expectedTitlle="The Internet";
        actualTitle= driver.getTitle();
        Assert.assertEquals(expectedTitlle,actualTitle);


    }
}