package leet.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * No 78
 * Code subsets
 * Url https://leetcode-cn.com/problems/subsets/
 * Status working
 * Answer https://leetcode-cn.com/articles/subsets/
 * Comments search combination
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 */
public class No78Subsets {


  private static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
//    for(int j = 0 ; j <= nums.length ; j++){
//      recursionSum(nums,0,path,result,j);
//    }
    backtrack(nums,0,path,result);
    return result;
  }

  private static void recursionSum(int[] nums,int index ,ArrayList<Integer> path,List<List<Integer>> result,int size){
      if(path.size() == size){
        result.add(new ArrayList<>(path));
        return;
      }
      for(int i = index ; i < nums.length ; ++i){
        path.add(nums[i]);
        recursionSum(nums,i + 1,path,result,size);
        path.remove(path.size() -1);
    }
  }

  private static void backtrack(int[] nums,int index ,ArrayList<Integer> tmp,List<List<Integer>> res){
    System.out.println("temp:" + new ArrayList<>(tmp));
    res.add(new ArrayList<>(tmp));
    for (int j = index; j < nums.length; j++) {
      tmp.add(nums[j]);
      backtrack(nums,j + 1,tmp,res);
      tmp.remove(tmp.size() - 1);
    }
  }


  public static void main(String args[]){
    int[] nums = {1,2,3};
    System.out.println(subsets(nums));
  }

}


/*
 *
 * 迭代解法
 *
 * 假定输入集合为nums（1, 2, 3），不重复的全部子集集合为subsets，流程如下：
 *
 * 没添加任何数字时，因为空集合是所有集合的子集，所以默认包含空子集。subsets = {[]}，
 *
 * 添加数字1时，因为subsets中的空子集和1拼接形成集合[1]，再添加进subsets 。subsets = {[], [1]}
 *
 * 添加数字2时，空子集与2拼接形成[2]，子集[1]与2拼接形成[1, 2]，再添加进subsets。subsets = {[], [1], [2], [1, 2]}
 *
 * 添加数字3流程同上。subsets = {[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]}
 *
 * 作者：18211010139
 * 链接：https://leetcode-cn.com/problems/two-sum/solution/die-dai-jie-fa-shi-jian-fu-za-du-o2nkong-jian-fu-z/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 *
 */
