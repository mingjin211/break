package leet.easy;


/**
 * No 53
 * Code maximum-subarray
 * Url https://leetcode-cn.com/problems/maximum-subarray/
 * Status pass
 * Answer https://leetcode-cn.com/articles/maximum-subarray/
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class No53MaximumSubarray {

  public static int maxSubArray(int[] nums) {

    int maxsum=nums[0],maxhere=nums[0];

    for(int i = 1 ; i < nums.length ; i++){
      if (maxhere <= 0)
        maxhere = nums[i];  //如果前面位置最大连续子序列和小于等于0，则以当前位置i结尾的最大连续子序列和为a[i]
      else
        maxhere += nums[i]; //如果前面位置最大连续子序列和大于0，则以当前位置i结尾的最大连续子序列和为它们两者之和
      if (maxhere > maxsum) {
        maxsum = maxhere;  //更新最大连续子序列和
      }
    }
    return maxsum;
  }

  public static void main(String args[]){
    int[] nums = {1};
    System.out.println(maxSubArray(nums));
  }

}
