package test;

public class StringTest {
  public static void main(String[] args) {


    // 中文常见字
    String s = "你好";
    System.out.println("1. string length = " + s.length());
    System.out.println("1. string bytes length = " + s.getBytes().length);
    System.out.println("1. string char length = " + s.toCharArray().length);
    System.out.println();
    // emojis
    s = "\uD83D\uDC65\uD83D\uDC66👦👩\uD83D\uDE18\uD83D\uDE17\uD83D\uDE19\uD83D\uDE1A";
    System.out.println("2. string length = " + s.length());
    System.out.println("2. string bytes length = " + s.getBytes().length);
    System.out.println("2. string char length = " + s.toCharArray().length);
    System.out.println(s.substring(0,4));
    // 中文生僻字
    s = "𡃁妹";
    System.out.println("3. string length = " + s.length());
    System.out.println("3. string bytes length = " + s.getBytes().length);
    System.out.println("3. string char length = " + s.toCharArray().length);
    System.out.println();
  }

}
