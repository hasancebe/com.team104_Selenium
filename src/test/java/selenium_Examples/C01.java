package selenium_Examples;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01 extends TestBase {
@Test
    public void test01(){
    driver.get("https://amazon.com/");
    ReusableMethods.wait(5);
}

}
