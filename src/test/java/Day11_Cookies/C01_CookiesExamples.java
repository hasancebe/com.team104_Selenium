package Day11_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_CookiesExamples extends TestBase {
    @Test

    public void test01() {
        //1- Amazon anasayfaya gidin
        driver.get("https://amazon.com/");

        //2- tum cookie’leri listeleyin
        Set<Cookie>cookieList=driver.manage().getCookies();
        int orderNo=1;
        for (Cookie eachCookie:cookieList
             ) {
            System.out.println(orderNo+"- "+eachCookie.toString());
            orderNo++;
        }
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        System.out.println(cookieList.size());
        Assert.assertTrue(cookieList.size()>5);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String expectedValue="USD";
        String actualValue="";
        for (Cookie each:cookieList
             ) {
            if(each.getName().equals("i18n-prefs")){
                actualValue=each.getValue();
            }

        }
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
        //olusturun ve sayfaya ekleyin
        Cookie myFavorite=new Cookie("My favorite cookie","chocolate");

        orderNo=1;
        driver.manage().addCookie(myFavorite);
        cookieList=driver.manage().getCookies();
        for (Cookie each:cookieList
             ) {
            System.out.println(orderNo+" - "+each);
            orderNo++;
        }

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        cookieList=driver.manage().getCookies();
        int isItThere=0;
        for (Cookie each:cookieList
             ) {
            if(each.getName().equals("My favorite cookie"))
                isItThere++;
        }
        Assert.assertTrue(isItThere>0);

        //7- ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
         isItThere=0;
         cookieList=driver.manage().getCookies();
        for (Cookie each:cookieList
        ) {
            if(each.getName().equals("skin"))
                isItThere++;
        }
        Assert.assertTrue(isItThere==0);

        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookieList=driver.manage().getCookies();

        Assert.assertTrue(cookieList.size()==0);

    }
}