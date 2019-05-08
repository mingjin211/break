package leet.easy;

import java.util.Stack;

/**
 * No 20
 * Code valid-parentheses
 * Url https://leetcode-cn.com/problems/valid-parentheses/
 * Status pass
 * Answer https://leetcode-cn.com/articles/valid-parentheses/
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 * 所有输入只包含小写字母 a-z 。
 *
 */
public class ValidParentheses {

  public static boolean isValid(String s) {
    if(s.isEmpty())return true;
    if(s.length() % 2 !=0){
      return false;
    }
    while(s.contains("[]") || s.contains("{}") || s.contains("()")){
      s = s.replace("[]","");
      s = s.replace("{}","");
      s = s.replace("()","");
    }
    if(s.length() == 0)return true;
    return false;
  }

  public static boolean isValid2(String s) {
    if(s.isEmpty())return true;
    Stack<Character> s1 = new Stack<>();
    for(int i = 0 ; i < s.length() ; i++){
      if(!s1.empty()){
        if(isSym(s1.peek(),s.charAt(i))){
          s1.pop();
        }else{
          s1.push(s.charAt(i));
        }
      }else{
        s1.push(s.charAt(i));
      }
    }
    return s1.empty();
  }

  private static boolean isSym(char c1, char c2) {
    return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
  }

  public static void main(String args[]){
    String s = "()";
    System.out.println(isValid2(s));
  }

}
