package Day06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public   class C01_Before_AfterClass {
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
    @ Test
     public void test01(){
    driver.get("https://amazon.com/");
    String expectedWord="Amazon";
    String actualWord=driver.getTitle();

    if(actualWord.contains(expectedWord)){
        System.out.println("amazon title test passed");
    }else{
        System.out.println("amazon title test failed");
    }
    }
    @ Test
    public void test02(){
    WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
    searchBox.sendKeys("nutella"+ Keys.ENTER);
    String searchWord="nutella";
    WebElement resultActualWord= driver.findElement(By.xpath(
            "//div[@class='a-section a-spacing-small a-spacing-top-small']"));
    String resultActualWordValue=resultActualWord.getText();

    if(resultActualWordValue.contains(searchWord)){
        System.out.println(" search nutella test passed");
    }else {
        System.out.println("search nutella test failed");
    }
    }

    @ Test
     public void test03(){
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("nutella"+ Keys.ENTER);

        WebElement resultActualWord= driver.findElement(By.xpath(
                "//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String resultActualWordValue=resultActualWord.getText();

        String [] arrayOfresultActualWordValue=resultActualWordValue.split(" ");
        System.out.println(Arrays.toString(arrayOfresultActualWordValue));
        String resultOfNumber=arrayOfresultActualWordValue[1];
        int resultNumber=Integer.parseInt(resultOfNumber);
        if(resultNumber>50){
            System.out.println("test number passed");
        }else{
            System.out.println("test number failed");
        }



    }
}
