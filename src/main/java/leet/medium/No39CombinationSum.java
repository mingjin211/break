package leet.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * No 39
 * Code combination-sum
 * Url https://leetcode-cn.com/problems/combination-sum/
 * Status working
 * Answer https://leetcode-cn.com/articles/combination-sum/
 * Comments search combination
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 执行用时 :2 ms, 在所有Java提交中击败了76.03%的用户
 * 内存消耗 :35.2 MB, 在所有Java提交中击败了87.02%的用户
 */
public class No39CombinationSum {

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> digui = new ArrayList<>();
    diguiSum(candidates,target,digui,result);
    return result;
  }

  public static void diguiSum(int[] candidates, int target, List<Integer> list,List<List<Integer>> result){
    List<Integer> diguiList = new ArrayList<>();
    diguiList.addAll(list);
    for(int i = 0 ; i < candidates.length ;){
      int x = candidates[i];
      i++;
      diguiList.add(x);
      if(target == x){
        result.add(diguiList);
        return;
      }else if(target < x){
        list = new ArrayList<>();
        return;
      }else {
        diguiSum(candidates,target - x,diguiList,result);
      }
    }

  }

  public static void main(String args[]){
    int[] num = {2,3,6,7};
    System.out.println(combinationSum(num,7));
  }

}
