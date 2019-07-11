package geektime.structure.chapter11Sort1;

public class SeclectSortYu {

  private static void sort(int[] nums){
    for(int i = 0 ; i < nums.length - 1; i++){
      int minIndex = i;
      for(int j = i + 1 ; j < nums.length ; j++){
        if(nums[j] < nums[minIndex]){
          minIndex = j;
        }
      }
      int temp = nums[i];
      nums[i] = nums[minIndex];
      nums[minIndex] = temp;
      for(int k = 0 ; k < nums.length ; k++){
        System.out.print(nums[k] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args){
//    int[] a = {1,23,5,3,8,9,42,2,6};
    int[] a = {1};
    sort(a);
  }

}
