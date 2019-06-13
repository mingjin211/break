package leet.easy;

/**
 * No 9
 * Code palindrome-number
 * Url https://leetcode-cn.com/problems/palindrome-number/
 * Status pass
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 */
public class No9PalindromeNumber {

  public static boolean isPalindrome(int x) {
    if(x < 0)return false;
    if(x < 10)return true;
    String str = String.valueOf(x);
    char[] strs = str.toCharArray();
    int length = strs.length;
    for(int i = 0 ; i < length / 2 ; i++){
      if(strs[i]!=strs[length-1-i]){
        return false;
      }
    }
    return true;
  }

  public static void main(String args[]){
    System.out.println(isPalindrome(1001));
  }

}

