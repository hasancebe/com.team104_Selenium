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
import java.util.List;

public class C02_ExampleHandle {
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
        //https://the-internet.herokuapp.com/dropdown adresine gidin
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement optionBox=driver.findElement(By.xpath("//*[@id='dropdown']"));
        optionBox.click();
        Select option1=new Select(optionBox);
        option1.selectByIndex(1);
        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        optionBox=driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select option2=new Select(optionBox);
        option1.selectByValue("2");

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        optionBox=driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select option1nd=new Select(optionBox);
        option1.selectByVisibleText("Option 1");
        System.out.println(option1nd.getFirstSelectedOption().getText());


        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement>optionsList=option1nd.getOptions();
        for (WebElement each : optionsList){
            System.out.println(each.getText());
        }
        //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True ,
        //degilse False yazdırın.
        int dropDownMenuSize=optionsList.size();
        System.out.println("liste boyutu "+dropDownMenuSize);
        System.out.println(dropDownMenuSize == 4);

        //Assert.assertTrue(dropDownMenuSize==4);

    }


    


}
