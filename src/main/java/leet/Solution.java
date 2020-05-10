package leet;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 438
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    //滑动窗口
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        int l = 0;
        int r = -1;
        int res = 0;
        char[] strs = s.toCharArray();
        while(l < strs.length){
            if(r + 1 < strs.length && freq[strs[r+1]] == 0){
                freq[strs[++r]]++;
            }else{
                freq[strs[l++]]--;
            }
            res = Math.max(res,r-l+1);
        }
        return res;
    }
    public String minWindow(String s, String t) {
        // 记录最短子串的开始位置和长度
        int start = 0, minLen = Integer.MAX_VALUE;
        int left = 0, right = 0;
        HashMap<Integer,Integer> window = new HashMap<>();
        HashMap<Integer,Integer> needs = new HashMap<>();
        for(char c : t.toCharArray()){
            needs.put('a'-c,needs.getOrDefault('a'-c,0) + 1);
        }
        // 记录 window 中已经有多少字符符合要求了
        int match = 0;
        String res = s;

        while (right < s.length()){
            int c1 = 'a' - s.charAt(right);
            if(needs.containsKey(c1)){
                window.put(c1,needs.getOrDefault(c1,0) + 1);
                if(window.getOrDefault(c1,0).equals(needs.get(c1))){
                    match++;
                }
            }
            right++;

            while(match==needs.size()){
//                res = res.length()>right-left?s.substring(left,right):res;
                if (right - left < minLen) {
                    // 更新最小子串的位置和长度
                    start = left;
                    minLen = right - left;
                }
                int c2 = 'a' - s.charAt(left);
                if (needs.containsKey(c2)){
                    window.put(c2,window.get(c2)-1);
                    if(window.getOrDefault(c2,0) < needs.get(c2)){
                        match--;
                    }
                }
                left++;
            }
        }
//        return res;
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }


    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList();
        int[] freq = new int[256];
        int l = 0;
        int r = -1;
        return new ArrayList<>();
    }

    public static void main(String args[]){
        Map<Integer, Integer> myMap = new HashMap<>();

    }
}