package leet.easy;

/**
 * No 58
 * Code length-of-last-word
 * Url https://leetcode-cn.com/problems/length-of-last-word/
 * Status pass
 * Answer https://leetcode-cn.com/articles/length-of-last-word/
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 */
public class No58LengthOfLastWord {

  public static int lengthOfLastWord(String s) {
    String[] strs = s.split(" ");
    if(strs.length == 0)return 0;
    else return strs[strs.length-1].length();
  }

  public static void main(String args[]){
    System.out.println(lengthOfLastWord("Hello World"));
  }

}
