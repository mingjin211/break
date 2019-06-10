package leet.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * No 53
 * Code letter-combinations-of-a-phone-number
 * Url https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * Status pass
 * Answer https://leetcode-cn.com/articles/letter-combinations-of-a-phone-number/
 *
 *  给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 执行用时 :2 ms, 在所有Java提交中击败了76.03%的用户
 * 内存消耗 :35.2 MB, 在所有Java提交中击败了87.02%的用户
 */
public class No17LetterCombinationsOfPhoneNumber {

  private static HashMap<String,List<String>> map;
  static {
    map = new HashMap<>();
    List<String> num2  = Arrays.asList("a","b","c");
    List<String> num3  = Arrays.asList("d","e","f");
    List<String> num4  = Arrays.asList("g","h","i");
    List<String> num5  = Arrays.asList("j","k","l");
    List<String> num6  = Arrays.asList("m","n","o");
    List<String> num7  = Arrays.asList("p","q","r","s");
    List<String> num8  = Arrays.asList("t","u","v");
    List<String> num9  = Arrays.asList("w","x","y","z");
    map.put("2", num2);
    map.put("3", num3);
    map.put("4", num4);
    map.put("5", num5);
    map.put("6", num6);
    map.put("7", num7);
    map.put("8", num8);
    map.put("9", num9);
  }

  public static List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    List<String> combine1;
    List<String> combine2;
    switch (digits.length()){
      case 0:return new ArrayList<>();
      case 1:return map.get(digits);
      case 2:{
        combine1 = map.get(digits.substring(0,1));
        combine2 = map.get(digits.substring(1));
        break;
      }
      default:{
        combine1 = map.get(digits.substring(0,1));
        combine2 = letterCombinations(digits.substring(1));
      }
    }
    for(String com1 : combine1){
      for(String com2 : combine2){
        result.add(com1 + com2);
      }
    }
    return result;
  }

  public static void main(String args[]){
    System.out.println(letterCombinations(""));
  }

}
