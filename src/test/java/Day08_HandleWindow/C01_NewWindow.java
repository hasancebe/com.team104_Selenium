package Day08_HandleWindow;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C01_NewWindow {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){driver.quit();}

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://amazon.com/");
        String amazonTabValue=driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://wisequarter.com/");
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(5000);
        driver.switchTo().window(amazonTabValue);

        String expectedWord="amazon";
        String actualWord=driver.getCurrentUrl();
        System.out.println(actualWord);
        Assert.assertTrue(actualWord.contains(expectedWord));

        Set<String> handleUniqueValues=driver.getWindowHandles();
        String secondTabHandleValue="";
        for (String each:handleUniqueValues){
            if(!each.equals(amazonTabValue))
                secondTabHandleValue=each;
            System.out.println(each.toString());
            
        }
        System.out.println(handleUniqueValues.toString());
    }
}
