package leet.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * No 40
 * Code combination-sum III
 * Url https://leetcode-cn.com/problems/combination-sum-ii-i/
 * Status pass but need thinking
 * Answer https://leetcode-cn.com/articles/combination-sum-iii/
 * Comments search combination
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 */
public class No216CombinationSumIII {

  private static List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<>();
    recursion(k,n,1,0,new ArrayList<>(),result);
    return result;
  }

  private static void recursion(int k,int n,int index,int target,List<Integer> tmp,List<List<Integer>> result){
    System.out.println("index:" + index + " temp:" + new ArrayList<>(tmp));
    if(target == n && tmp.size() == k){
      result.add(new ArrayList<>(tmp));
      return;
    }
    for(int i = index ; i <= 9 ; i++){
      if(n - target < i)break;
        tmp.add(i);
        recursion(k,n,i + 1,target + i,tmp,result);
        tmp.remove(tmp.size() - 1);
    }
  }

  public static void main(String args[]){
    System.out.println(combinationSum3(3,8));
  }
}
