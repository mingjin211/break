package algorithm.sort;

/**
 *
 *  直接插入排序
 *  假设有一组无序序列 R0, R1, ... , RN-1。
 *
 * (1) 我们先将这个序列中下标为 0 的元素视为元素个数为 1 的有序序列。
 *
 * (2) 然后，我们要依次把 R1, R2, ... , RN-1 插入到这个有序序列中。所以，我们需要一个外部循环，从下标 1 扫描到 N-1 。
 *
 * (3) 接下来描述插入过程。假设这是要将 Ri 插入到前面有序的序列中。由前面所述，我们可知，插入Ri时，前 i-1 个数肯定已经是有序了。
 *
 * 所以我们需要将Ri 和R0 ~ Ri-1 进行比较，确定要插入的合适位置。这就需要一个内部循环，我们一般是从后往前比较，即从下标 i-1 开始向 0 进行扫描。
 */
public class InsertionSort {

  private static void insertionSort(int[] nums){

    for(int i = 1 ; i < nums.length ; i++){
      int temp = nums[i];
      int j = i -1;
      for(; j >= 0 && nums[j] > temp ; j --){
          nums[j+1] = nums[j];
      }
      nums[j+1] = temp;
    }

  }

  public static void main(String[] args){
    int[] a = {1,23,5,3,8,9,42,2,6};
    insertionSort(a);
    for(int j = 0 ; j < a.length ; j++){
      System.out.print(a[j] + " ");
    }
  }

}
