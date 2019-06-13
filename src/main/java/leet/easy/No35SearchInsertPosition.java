package leet.easy;

/**
 * No 35
 * Code search-insert-position
 * Url https://leetcode-cn.com/problems/search-insert-position/
 * Status pass
 * Answer https://leetcode-cn.com/articles/search-insert-position/
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class No35SearchInsertPosition {

  public static int searchInsert(int[] nums, int val) {
    int i = 0;
    while(i < nums.length && nums[i] < val){
      i++;
    }
//    if(i==nums.length-1 && nums[i]<val)return nums.length;
    return i;
  }


  public static void main(String args[]){
    int[] nums = {1,3,5,6};
    System.out.println(searchInsert(nums,7));
  }
}
