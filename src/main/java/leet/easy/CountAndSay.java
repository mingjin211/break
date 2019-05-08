package leet.easy;

/**
 * No 38
 * Code count-and-say
 * Url https://leetcode-cn.com/problems/count-and-say/
 * Status pass
 * Answer https://leetcode-cn.com/articles/count-and-say/
 *
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 */
public class CountAndSay {

  public static String countAndSay(int n) {
    String ex = "1";
    if(n==1)return ex;
    for(int i=2 ; i <= n ; i++){
      int length = ex.length();
      StringBuilder sb = new StringBuilder();
      for(int j = 0 ; j <length ; ){
        char x = ex.charAt(j);
        int k = 0;
        while(j+k < length && x == ex.charAt(j+k)){
          k++;
        }
        sb.append(k).append(x);
        j = j +k;
      }
      ex = sb.toString();
    }
    return ex;
  }

  public static void main(String args[]){
    int n =3;
    System.out.println(countAndSay(10));
  }
}
