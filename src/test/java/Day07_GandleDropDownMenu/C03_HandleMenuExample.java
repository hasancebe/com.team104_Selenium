package Day07_GandleDropDownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_HandleMenuExample {
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
        driver.close();
    }

    @Test
    public void test01() {

        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //2. Sign in butonuna basin
        WebElement signButton=driver.findElement(By.id("signin_button"));
        signButton.click();

        //3. Login kutusuna “username” yazin
        WebElement userName= driver.findElement(By.xpath("//input[@id='user_login']"));
        userName.sendKeys("username");

        //4. Password kutusuna “password.” yazin
        //5. Sign in tusuna basin
        //6. Pay Bills sayfasina gidin
        //7. “Purchase Foreign Currency” tusuna basin
        //8. “Currency” drop down menusunden Eurozone’u secin
        //9. “amount” kutusuna bir sayi girin
        //10. “US Dollars” in secilmedigini test edin
        //11. “Selected currency” butonunu secin
        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
        //kontrol edin.
    }
}