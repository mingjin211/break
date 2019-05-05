package leet.easy;

/**
 * No 13
 * Code roman-to-integer
 * Url https://leetcode-cn.com/problems/roman-to-integer/
 * Status pass
 *
 * <p>
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 * <p>
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 * <p>
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 *
 * public int romanToInt(String s) {
 * 		int n = s.length();
 * 		int roman_int = 0;
 * 		for(int i=0;i<n;i++)
 *        {
 * 			switch(s.charAt(i))
 *      {
 * 			case 'I' : roman_int = roman_int + 1;break;
 * 			case 'V' : roman_int = roman_int + 5;break;
 * 			case 'X' : roman_int = roman_int + 10;break;
 * 			case 'L' : roman_int = roman_int + 50;break;
 * 			case 'C' : roman_int = roman_int + 100;break;
 * 			case 'D' : roman_int = roman_int + 500;break;
 * 			case 'M' : roman_int = roman_int + 1000;break;
 * 			default: System.out.println("default");break;
 *      }
 *
 * 			if(i!=0)
 *      {
 * 				if(((s.charAt(i)=='V')||(s.charAt(i)=='X'))&&(s.charAt(i-1)=='I'))
 * 					roman_int = roman_int-1*2;
 * 				if(((s.charAt(i)=='L')||(s.charAt(i)=='C'))&&(s.charAt(i-1)=='X'))
 * 					roman_int = roman_int-10*2;
 * 				if(((s.charAt(i)=='D')||(s.charAt(i)=='M'))&&(s.charAt(i-1)=='C'))
 * 					roman_int = roman_int-100*2;
 *      }
 *    }
 * 		return roman_int; 	}
 *
 */
public class RomanToInteger {

  public static int romanToInt(String s) {
    int res = 0;

    char[] strs = s.toCharArray();
    int length = strs.length;

    for (int i = 0; i < length; i++) {
      char now = strs[i];
      if (now == 'M') {
        res += 1000;
        continue;
      }
      if (now == 'D') {
        res += 500;
        continue;
      }
      if (now == 'L') {
        res += 50;
        continue;
      }
      if (now == 'V') {
        res += 5;
        continue;
      }
      if (now == 'C') {
        if (i + 1 < length) {
          if (strs[i + 1] == 'D') {
            res += 400;
            i++;
            continue;
          } else if (strs[i + 1] == 'M') {
            res += 900;
            i++;
            continue;
          } else {
            res += 100;
            continue;
          }
        } else {
          res += 100;
          continue;
        }
      }
      if (now == 'X') {
        if (i + 1 < length) {
          if (strs[i + 1] == 'L') {
            res += 40;
            i++;
            continue;
          } else if (strs[i + 1] == 'C') {
            res += 90;
            i++;
            continue;
          } else {
            res += 10;
            continue;
          }
        } else {
          res += 10;
          continue;
        }
      }
      if (now == 'I') {
        if (i + 1 < length) {
          if (strs[i + 1] == 'V') {
            res += 4;
            i++;
            continue;
          } else if (strs[i + 1] == 'X') {
            res += 9;
            i++;
            continue;
          } else {
            res += 1;
            continue;
          }
        } else {
          res += 1;
          continue;
        }
      }
    }

    return res;
  }

  public static void main(String args[]) {
    System.out.println(romanToInt("XXVII"));
  }
}
