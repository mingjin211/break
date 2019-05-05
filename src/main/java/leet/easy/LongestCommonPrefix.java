package leet.easy;


/**
 * No 14
 * Code longest-common-prefix
 * Url https://leetcode-cn.com/problems/longest-common-prefix/
 * Status pass
 * Answer https://leetcode-cn.com/articles/longest-common-prefix/
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 */
public class LongestCommonPrefix {

  public static String longestCommonPrefix(String[] strs) {
    if(strs.length == 0){
      return "";
    }
    if(strs.length == 1){
      return strs[0];
    }
    int minLength = strs[0].length();

    for(int i = 0 ; i < strs.length ; i++){
      minLength = minLength < strs[i].length() ? minLength : strs[i].length();
    }
    for(int i = 0 ; i < strs.length ; i++){
      if(minLength == 0){
        return "";
      }
      String ex = strs[0].substring(0,minLength);
      boolean flag = true;
      for(int j = i+1 ; j < strs.length ; j++){
        if(!strs[j].substring(0,minLength).equals(ex)){
          i = -1;
          minLength--;
          flag = false;
          break;
        }
      }
      if(flag){
        return strs[0].substring(0,minLength);
      }

    }
    return "";
  }

  public static void main(String args[]){
//    String[] array = {"dog","racecar","car"};
//    String[] array = {"flower","flow","flight"};
    String[] array = {"c","c"};
    System.out.println(longestCommonPrefix(array));
  }

}
