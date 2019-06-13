package leet.hard;

/**
 * No 58
 * Code median-of-two-sorted-arrays
 * Url https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * Status Nope
 * Answer https://leetcode-cn.com/articles/median-of-two-sorted-arrays/
 * <p>
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class No4MedianOfTwoSortedArrays {

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int res = 0;
    for (int i = 0, j = 0; ; ) {
      if ((nums1.length + nums2.length) % 2 == 0) {
        if ((double) i + j + 2 == (double) (nums1.length + nums2.length) + 1) {
          return (nums1[i] + nums2[j]) / 2;
        }
      } else if ((double) i + j + 2 > (double) (nums1.length + nums2.length) / 2) {
        return Math.max(nums1[i], nums2[j]);
      }
      if (nums1[i] >= nums2[j]) {
        res = nums1[i];
        if (j < nums2.length - 1) {
          j++;
        } else {
          i++;
        }
      } else {
        res = nums2[j];
        if (i < nums1.length - 1) {
          i++;
        } else {
          j++;
        }
      }
    }
  }

  public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
    int num = 0;
    double length1 = nums1.length;
    double length2 = nums2.length;

    int pre = 0;
    int now = 0;
    double mid = (length1 + length2) / 2;
    if (length1 == 0) {
      if(mid != (int)mid){
        return nums2[(int)mid];
      }
      else return ((double)nums2[(int)mid-1]+(double)nums2[(int)mid])/2;
    }
    if (length2 == 0) {
      if(mid != (int)mid){
        return nums1[(int)mid];
      }
      else return ((double)nums1[(int)mid-1]+(double)nums1[(int)mid])/2;
    }

    for (int i = 0, j = 0; ; ) {
      if ((double) num == mid) {
        return ((double) pre + (double) now) / 2;
      }
      if (num == (int) mid + 1) {
        return pre;
      }
      if(num==0){
        now = Math.max(nums1[0],nums2[0]);
        pre = Math.min(nums1[0],nums2[0]);
      }
      if (nums1[i] >= nums2[j]) {
        if(num==0){
          now = Math.max(nums1[0],nums2[0]);
          pre = Math.min(nums1[0],nums2[0]);
        }
        else{
          pre = now;
          now = nums2[j];
        }
        if (j < nums2.length - 1) {
          j++;
        } else {
          i++;
        }
      } else {
        if(num==0){
          now = Math.max(nums1[0],nums2[0]);
          pre = Math.min(nums1[0],nums2[0]);
        }else{
          pre = now;
          now = nums1[i];
        }
        if (i < nums1.length - 1) {
          i++;
        } else {
          j++;
        }
      }
      num++;
    }
  }

  public static void main(String args[]) {
    int[] nums1 = {1,2};
    int[] nums2 = {-1,3};
    System.out.println(findMedianSortedArrays2(nums1, nums2));
  }

}
