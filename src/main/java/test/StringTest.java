package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringTest {
  public static void main(String[] args) {


//    List<String> flavorNames = Arrays.asList("高性能计算型h3","通用入门型","内存优化型m3","通用计算型s3","通用计算型c2","内存优化型m1","通用计算型s2","通用计算型c1","超高IO型i3","通用共享型s1","通用计算增强型c3");
//    List<String> flavorNames = Arrays.asList("内存优化型m3","通用计算型s3","通用计算增强型c3");
//    Collections.sort(flavorNames, new Comparator<String>() {
//      final String prefix = "通用计算型";
//      @Override
//      public int compare(String o1, String o2) {
//        if (o1.startsWith(prefix) && !o2.startsWith(prefix)) {
//          return -1;
//        }else if(o1.charAt(o1.length()-1) < o2.charAt(o2.length()-1) ){
//          return -1;
//        }else return 0;
//      }
//    });
    System.out.println(setXXXId("510321199002115784"));
    System.out.println(setXXXName("510321199002115784"));
    System.out.println(setXXXPhone("18190846873"));
    System.out.println("value  is  " + ((4>4) ? 99 : 9));
    System.out.println("value  is  " + (8 + 1));

    // 中文常见字
//    String s = "你好";
//    System.out.println("1. string length = " + s.length());
//    System.out.println("1. string bytes length = " + s.getBytes().length);
//    System.out.println("1. string char length = " + s.toCharArray().length);
//    System.out.println();
    // emojis
//    s = "\uD83D\uDC65\uD83D\uDC66👦👩\uD83D\uDE18\uD83D\uDE17\uD83D\uDE19\uD83D\uDE1A";
//    System.out.println("2. string length = " + s.length());
//    System.out.println("2. string bytes length = " + s.getBytes().length);
//    System.out.println("2. string char length = " + s.toCharArray().length);
//    System.out.println(s.substring(0,4));
    // 中文生僻字
//    s = "𡃁妹";
//    System.out.println("3. string length = " + s.length());
//    System.out.println("3. string bytes length = " + s.getBytes().length);
//    System.out.println("3. string char length = " + s.toCharArray().length);
//    System.out.println();
  }


  /**
   *身份ID a****b
   *
   * @return
   */
  public static String setXXXId(String Id) {
    try {
      String id_s = Id.replaceAll("(?<!^)\\w(?<!$)", "*");
      return id_s;
    }catch (Exception e){
      return Id;
    }
  }

  /**
   *姓名*号只显示最后一个字
   *
   * @return
   */
  public static String setXXXName(String name) {
    return "*" + name.substring(name.length()-1);
//    String name_s = name.replaceAll("(\\w{"+1+"})(\\w+)", "*$2");
//    return name_s;
  }
  /**
   *姓名*号只显示最后一个字
   *
   * @return
   */
  public static String setXXXPhone(String phone) {
    return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
//    String name_s = name.replaceAll("(\\w{"+1+"})(\\w+)", "*$2");
//    return name_s;
  }

}
