package Day07_GandleDropDownMenu;

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

public class C04_Alerts {
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
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsAlertbutton = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        jsAlertbutton.click();
        String expectedWarningMessage = "I am a JS Alert";
        String warningMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(warningMessage, expectedWarningMessage);
        driver.switchTo().alert().accept();
        Thread.sleep(10000);
    }

    @Test
        public void test02() throws InterruptedException {
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");


            WebElement jsconfirmElement= driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
            jsconfirmElement.click();
            driver.switchTo().alert().dismiss();
            WebElement cancelText= driver.findElement(By.xpath("//*[@id='result']"));
            String expectedText="You clicked: Cancel";
            String actualText=cancelText.getText();
            Assert.assertEquals(actualText,expectedText);
            Thread.sleep(10000);

    }
@Test
    public void test03(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jspromptElement= driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jspromptElement.click();
        driver.switchTo().alert().sendKeys("ahmet");
        driver.switchTo().alert().accept();
        WebElement sendText= driver.findElement(By.xpath("//*[@id='result']"));
        String actualText=sendText.getText();
        String expectedSendText="You entered: ahmet";
        Assert.assertEquals(actualText,expectedSendText);

    }
}