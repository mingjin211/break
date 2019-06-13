package leet.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No 90
 * Code subsets-ii
 * Url https://leetcode-cn.com/problems/subsets-ii/
 * Status working
 * Answer https://leetcode-cn.com/articles/subsets-ii/
 * Comments search combination
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 */
public class No90SubsetsII {

  public static List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    recursion(nums,0,new ArrayList<>(),result);
    return result;
  }

  public static void recursion(int[] nums,int index,List<Integer> path,List<List<Integer>> result){
      result.add(new ArrayList<>(path));
      for(int i = index ; i < nums.length ; i++){
        if(i > index && nums[i-1] == nums[i]) continue;
        path.add(nums[i]);
        recursion(nums,i + 1,path,result);
        path.remove(path.size()-1);
      }
  }

  public static void main(String args[]){
    int[] nums = {4,4,4,1,4};
    System.out.println(subsetsWithDup(nums));
  }

}
