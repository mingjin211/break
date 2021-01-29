package leet.medium;

import java.util.*;

/**
 * No 53
 * Code letter-combinations-of-a-phone-number
 * Url https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * Status pass
 * Answer https://leetcode-cn.com/articles/letter-combinations-of-a-phone-number/
 * Comments search combination
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * 执行用时 :2 ms, 在所有Java提交中击败了76.03%的用户
 * 内存消耗 :35.2 MB, 在所有Java提交中击败了87.02%的用户
 */
public class No17LetterCombinationsOfPhoneNumber {

//    private static HashMap<String, List<String>> map;
//
//    static {
//        map = new HashMap<>();
//        List<String> num2 = Arrays.asList("a", "b", "c");
//        List<String> num3 = Arrays.asList("d", "e", "f");
//        List<String> num4 = Arrays.asList("g", "h", "i");
//        List<String> num5 = Arrays.asList("j", "k", "l");
//        List<String> num6 = Arrays.asList("m", "n", "o");
//        List<String> num7 = Arrays.asList("p", "q", "r", "s");
//        List<String> num8 = Arrays.asList("t", "u", "v");
//        List<String> num9 = Arrays.asList("w", "x", "y", "z");
//        map.put("2", num2);
//        map.put("3", num3);
//        map.put("4", num4);
//        map.put("5", num5);
//        map.put("6", num6);
//        map.put("7", num7);
//        map.put("8", num8);
//        map.put("9", num9);
//    }
//
//    public static List<String> letterCombinations(String digits) {
//        List<String> result = new ArrayList<>();
//        List<String> combine1;
//        List<String> combine2;
//        switch (digits.length()) {
//            case 0:
//                return new ArrayList<>();
//            case 1:
//                return map.get(digits);
//            case 2: {
//                combine1 = map.get(digits.substring(0, 1));
//                combine2 = map.get(digits.substring(1));
//                break;
//            }
//            default: {
//                combine1 = map.get(digits.substring(0, 1));
//                combine2 = letterCombinations(digits.substring(1));
//            }
//        }
//        for (String com1 : combine1) {
//            for (String com2 : combine2) {
//                result.add(com1 + com2);
//            }
//        }
//        return result;
//    }


    //官方解法 DFS
    Map<String, String> phone = new HashMap<String, String>() {{
        put("0", "   ");
        put("1", "");
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> ans = new ArrayList<>();

    private void backTree(String combination, String next_digits) {
        if (next_digits.length() == 0) {
            ans.add(combination);
        } else {
            String letters = phone.get(next_digits.substring(0, 1));
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                backTree(combination + letter, next_digits.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backTree("", digits);
        }
        return ans;
    }

    //花花 dfs 模板化
    public void dfs(String digits, int l, String cur, List<String> ans) {
        if (l == digits.length()) {
            ans.add(cur);
        } else {
            String letters = phone.get(digits.substring(l, l + 1));
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                dfs(digits, l + 1, cur + letter, ans);
            }
        }
    }

    public static void main(String args[]) {
//        System.out.println(new No17LetterCombinationsOfPhoneNumber().letterCombinations("23"));
        List<String> ans = new ArrayList<>();
        new No17LetterCombinationsOfPhoneNumber().dfs("23", 0, "", ans);
        System.out.println(ans);
    }

}
