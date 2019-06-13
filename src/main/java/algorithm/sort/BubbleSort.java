package algorithm.sort;

/**
 *
 *  冒泡排序
 * 对冒泡排序常见的改进方法是加入标志性变量exchange，用于标志某一趟排序过程中是否有数据交换。
 *
 * 如果进行某一趟排序时并没有进行数据交换，则说明所有数据已经有序，可立即结束排序，避免不必要的比较过程。
 */
public class BubbleSort {

  private static void bubbleSort(int[] nums){

    for(int i = 0 ; i < nums.length -1; i++){
      for(int j = 0 ; j < nums.length -1; j++){
        if(nums[j] > nums[j+1]){
          nums[j] = nums[j] + nums[j+1];
          nums[j+1] = nums[j] - nums[j+1];
          nums[j] = nums[j] - nums[j+1];
        }
      }
    }

  }

  public static void main(String[] args){
    int[] a = {1,23,5,3,8,9,42,2,6};
    bubbleSort(a);
    for(int j = 0 ; j < a.length ; j++){
      System.out.print(a[j] + " ");
    }
  }
}
