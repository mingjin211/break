package leet.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No 39
 * Code combination-sum
 * Url https://leetcode-cn.com/problems/combination-sum/
 * Status pass but need thinking
 * Answer https://leetcode-cn.com/articles/combination-sum/
 * Comments search combination
 *
 * 思考DP的解法
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
 */
public class No39CombinationSum {

  private static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
    ArrayList<Integer> path = new ArrayList<>();
    recursionSum(candidates,target,0,path,result);
    return result;
  }

  private static void recursionSum(int[] candidates, int target, int index ,ArrayList<Integer> path,List<List<Integer>> result){
    System.out.println("index:" + index + " temp:" + new ArrayList<>(path));
    if(target < 0){
      return;
    }
    if(target == 0){
      result.add(new ArrayList<>(path));
      return;
    }
    for(int i = index ; i < candidates.length ; ++i){
      if(i > index && candidates[i] == candidates[i-1])continue; //如果candidates是可重复元素数组 这里是去重方式
      path.add(candidates[i]);
      recursionSum(candidates,target - candidates[i],i,path,result);
      path.remove(path.size() -1);
    }
  }

  public static void main(String args[]){
    int[] num = {2,3,5};
    System.out.println(combinationSum(num,8));
  }

}
