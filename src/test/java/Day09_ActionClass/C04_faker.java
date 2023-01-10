package Day09_ActionClass;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_faker extends TestBase {
    @Test
    public void test(){
        //1. "https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");

        Faker faker=new Faker();
        Actions actions=new Actions(driver);

        //2. “create new account” butonuna basin
        WebElement createAccount= driver.findElement(By.xpath("//a[@rel='async']"));
        createAccount.click();



        //3. “firstName” giris kutusuna bir isim yazin
        WebElement firstName1= driver.findElement(By.xpath("//input[@name='firstname']"));
       actions.sendKeys(firstName1,faker.name().firstName()).perform();
       ReusableMethods.wait(3);

        //4. “surname” giris kutusuna bir soyisim yazin
        WebElement lastName1= driver.findElement(By.xpath("//input[@name='lastname']"));
        actions.sendKeys(lastName1,faker.name().lastName()).perform();
        ReusableMethods.wait(3);

        //5. “email” giris kutusuna bir email yazin
        WebElement email= driver.findElement(By.xpath("//input[@name='reg_email__']"));
        actions.sendKeys(email,faker.expression("123abc@gmail.com")).perform();
        ReusableMethods.wait(3);

        //6. “email” onay kutusuna emaili tekrar yazin
        WebElement emailonay= driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        actions.sendKeys(emailonay,faker.expression("123abc@gmail.com")).perform();
        ReusableMethods.wait(3);

        //7. Bir sifre girin
        WebElement password= driver.findElement(By.xpath("//input[@data-type='password']"));
        actions.sendKeys(password, faker.expression("1234")).perform();

        //8. Tarih icin gun secin
        WebElement day= driver.findElement(By.xpath("//select[@aria-label='Gün']"));
        //actions.sendKeys(day,faker.).perform();
        //9. Tarih icin ay secin
        //10. Tarih icin yil secin
        //11. Cinsiyeti secin
        //12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        //13. Sayfayi kapatin
    }
}
