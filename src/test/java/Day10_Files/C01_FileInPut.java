package Day10_Files;

import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C01_FileInPut  {
    @Test
    public void test01() throws FileNotFoundException {
        String filePath="C:\\Users\\hasan\\Desktop\\java.docx";// not dynamic
        FileInputStream fis=new FileInputStream(filePath);

        System.out.println(System.getProperty("user.dir"));//returns C:/users/hasancebe/IdeaProject/com.Team104AfterMaven

        System.out.println(System.getProperty("user.home"));//by using this part of the path, Ican createa dynamic path for all computers

        String dynamicFilePath=System.getProperty("user.home")+"\\Desktop\\java.docx";
        System.out.println(dynamicFilePath);
    }
}
