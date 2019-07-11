package geektime.structure.chapter11Sort1;

public class BubbleSortYu {

  private static void sort(int[] nums){
    boolean flag = false;
    for(int i = 0 ; i < nums.length ; i++){
      for(int j = 1 ; j < nums.length ; j++){
        if(nums[j-1] > nums[j]){
          int tmp = nums[j];
          nums[j] = nums[j-1];
          nums[j-1] = tmp;
          flag = true;
        }
      }
      if(!flag){
        System.out.println("提前结束");
        break;
      }
      flag = false;
      for(int j = 0 ; j < nums.length ; j++){
        System.out.print(nums[j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args){
    int[] a = {1,23,5,3,8,9,42,2,6};
    sort(a);
    for(int j = 0 ; j < a.length ; j++){
      System.out.print(a[j] + " ");
    }
  }
}
