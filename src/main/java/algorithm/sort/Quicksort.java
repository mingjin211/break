package algorithm.sort;

/**
 *
 * 快速排序
 *
 * 不稳定的算法。
 *
 */
public class Quicksort {


  private static void quicksort(int[] nums, int left , int right){
    // 左下标一定小于右下标，否则就越界了
    if (left < right) {
      // 对数组进行分割，取出下次分割的基准标号
      int base = division(nums, left, right);

      // 对“基准标号“左侧的一组数值进行递归的切割，以至于将这些数值完整的排序
      quicksort(nums, left, base - 1);

      // 对“基准标号“右侧的一组数值进行递归的切割，以至于将这些数值完整的排序
      quicksort(nums, base + 1 , right);
    }
  }

  private static int division(int[] nums, int left , int right){
    // 以最左边的数(left)为基准
    int base = nums[left];
    while(left < right){
      // 从序列右端开始，向左遍历，直到找到小于base的数
      while(left < right && nums[right] > base){
        right--;
      }
      // 找到了比base小的元素，将这个元素放到最左边的位置
      nums[left] = nums[right];
      // 从序列左端开始，向右遍历，直到找到大于base的数
      while(left < right && nums[left] < base){
        left++;
      }
      // 找到了比base大的元素，将这个元素放到最右边的位置
      nums[right] = nums[left];
    }
    // 最后将base放到left位置。此时，left位置的左侧数值应该都比left小；
    // 而left位置的右侧数值应该都比left大。
    nums[left] = base;
    return left;
  }

  public static void main(String[] args){
    int[] a = {1,23,5,3,8,9,42,2,6};
    quicksort(a,0,a.length -1);
    for(int j = 0 ; j < a.length ; j++){
      System.out.print(a[j] + " ");
    }
  }
}
