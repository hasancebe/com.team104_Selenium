package Day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BestBuyAssertion {


    //Bir class oluşturun: BestBuyAssertions
    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak
    //asagidaki testleri yapin




    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://bestbuy.com/");
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }

    //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
    @Test
    public  void test01(){
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl= driver.getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    //○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    @Test
    public void test02(){

        String expectedTitleIsContainRest="Rest";
        String actualTitle= driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertFalse(actualTitle.contains(expectedTitleIsContainRest));
    }

    //○ logoTest => BestBuy logosunun görüntülendigini test edin
    @Test
    public void test03(){
        WebElement logo= driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }
    //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    @Test

    public void test04(){
        WebElement francaisLink= driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(francaisLink.isDisplayed());

    }

}
