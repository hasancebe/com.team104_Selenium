package Day07_GandleDropDownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_handleDropDown {
    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("http://amazon.com/");
        WebElement handleMenu= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));

        Select select=new Select(handleMenu);
        //select.selectByValue("search-alias=stripbooks-intl-ship");
        select.selectByVisibleText("Books");

        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("java"+ Keys.ENTER);

        String expectedWord="java";
        String actualTitlr= driver.getTitle();

        Assert.assertTrue(actualTitlr.contains(expectedWord));

        handleMenu=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select=new Select(handleMenu);
        String actualSelectedOption=select.getFirstSelectedOption().getText();
        select.selectByVisibleText("Books");
        String expectedSelectedOption="Books";
        Assert.assertEquals(expectedSelectedOption,actualSelectedOption);

    }

}
