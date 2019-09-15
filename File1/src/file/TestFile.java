package file;

import java.io.File;
import java.io.IOException;

public class TestFile {
    public static void main(String[] args) throws IOException {
        File file1=new File("d:/LOLFolder");
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.exists());
        //新建文件夹
        if(!file1.exists()) file1.mkdir();
        File file2=new File("LOL.exe");
        System.out.println(file2.getAbsolutePath());
        File file3=new File(file1,"LOL.exe");
        //新建文件
        if(!file3.exists()) file3.createNewFile();
        System.out.println(file3.getAbsolutePath());
    }
}
