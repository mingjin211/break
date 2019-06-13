package algorithm.sort;

/**
 * 简单选择排序是一种选择排序。
 *
 * 选择排序：每趟从待排序的记录中选出关键字最小的记录，顺序放在已排序的记录序列末尾，直到全部排序结束为止
 *
 * 简单排序很简单，它的大致处理流程为：
 *
 * (1)从待排序序列中，找到关键字最小的元素；
 * (2)如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换；
 * (3)从余下的 N - 1 个元素中，找出关键字最小的元素，重复(1)、(2)步，直到排序结束。
 *
 */
public class SelectSort {

  private static void selectSort(int[] nums){

    for(int i = 0 ; i < nums.length ; i++){
      int minIndex = i;
      for(int j = i + 1 ; j < nums.length ; j++){
          if(nums[j] < nums[minIndex]){
            minIndex = j;
          }
      }
      if(minIndex == i){
        continue;
      }
      nums[minIndex] = nums[i] + nums[minIndex];
      nums[i] = nums[minIndex] - nums[i];
      nums[minIndex] = nums[minIndex] - nums[i];

      System.out.print("第" + i + "次:");
      for(int j = 0 ; j < nums.length ; j++){
        System.out.print(nums[j] + " ");
      }
      System.out.println();
    }

  }

  public static void main(String[] args){
    int[] a = {6,4,8,9,2,3,1};
    selectSort(a);
  }


}
