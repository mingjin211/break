package leet.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No 40
 * Code combination-sum II
 * Url https://leetcode-cn.com/problems/combination-sum-ii/
 * Status pass but need thinking
 * Answer https://leetcode-cn.com/articles/combination-sum-ii/
 * Comments search combination
 * 
 * 思考DP的解法
 * 和39最主要的区别是每个数字只能用一次 且candidates数组元素变成可重复了
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 *
 *
 */
public class No40CombinationSumII {

  private static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
    ArrayList<Integer> path = new ArrayList<>();
    diguiSum(candidates,target,0,path,result);
    return result;
  }

  private static void diguiSum(int[] candidates, int target, int index ,ArrayList<Integer> path,List<List<Integer>> result){
    if(target < 0){
      return;
    }
    if(target == 0){
//      if(!result.contains(path)){ //去重方式1 加入结果集的时候判断
        result.add(new ArrayList<>(path));
//      }
      return;
    }
    for(int i = index ; i < candidates.length ; ++i){
      if(i > index && candidates[i] == candidates[i-1])continue; //去重方式2 回溯查找的时候判断
      path.add(candidates[i]);
      diguiSum(candidates,target - candidates[i],i + 1,path,result);
      path.remove(path.size() -1);
    }
  }

  public static void main(String args[]){
    int[] num = {10,1,2,7,6,1,5};
    System.out.println(combinationSum(num,8));
  }


}
