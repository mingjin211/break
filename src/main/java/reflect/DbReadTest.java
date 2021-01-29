package reflect;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DbReadTest {

  public static void main(String[] args) throws IOException {

    BufferedInputStream bis = null;

    int bytesRead = 0;
    bis = new BufferedInputStream(new FileInputStream("C:\\Users\\Yu\\Downloads\\ip\\ipv6wry.db"));

    int len = bis.available();
    byte []b = new byte[len];

    bis.read(b, 0, len);
    //从文件中按字节读取内容，到文件尾部时read方法将返回-1
//    while ((bytesRead = bis.read(b)) != -1) {
//
//      //将读取的字节转为字符串对象
//      String chunk = new String(b, 0, bytesRead);
//      System.out.print(chunk);
//    }
    String chunk = new String(b, 0, len, "UTF-8");
    System.currentTimeMillis();
  }

}
