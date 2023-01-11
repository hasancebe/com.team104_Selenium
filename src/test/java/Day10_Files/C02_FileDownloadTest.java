package Day10_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTest extends TestBase {
    @Test
    public void test01(){
        //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://www.selenium.dev/downloads/");

        //3. logo.png dosyasını indirelim
        driver.findElement(By.linkText("64 bit Windows IE")).click();
        ReusableMethods.wait(14);
        String filepath=System.getProperty("user.home")+"\\Downloads\\IEDriverServer_x64_4.7.0.zip";
        System.out.println(filepath);
        Assert.assertTrue(Files.exists(Paths.get(filepath)));

        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
    }
}
