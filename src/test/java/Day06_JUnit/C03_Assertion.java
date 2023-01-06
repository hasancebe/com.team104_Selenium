package Day06_JUnit;

import org.junit.Assert;
import org.junit.Test;

public class C03_Assertion {

    int age1=60;
    int age2=66;
    int age3=80;

    @Test
    public void test01(){

        //emekli yaşı 65 ise age2 nin emekli olabileceğini test edin

        Assert.assertTrue(age2>65);
    }

    @Test
    public void test02(){

        //emekli yaşı 65 ise age1 nin emekli olamayacağını test edin

        Assert.assertFalse(age1>65);
    }

    @Test
    public void test03(){

        //emekli yaşı 65 ise age3 nin emekli olamayacağını test edin

        Assert.assertFalse("girilen yaş 65 den küçük olmadığından emekli olabilir",age3>65);
    }
}
