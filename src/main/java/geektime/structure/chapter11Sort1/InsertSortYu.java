package geektime.structure.chapter11Sort1;

public class InsertSortYu {

  private static void sort(int[] nums){
    for(int i = 1 ; i < nums.length ; i++){
      int tmp = nums[i];
      int j = i - 1;
      for(; j > 0 ; j--){
        if(nums[j] > tmp ){
          nums[j+1] = nums[j];
        }else break;
      }
      nums[j+1]= tmp;
      for(int k = 0 ; k < nums.length ; k++){
        System.out.print(nums[k] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args){
    int[] a = {1,23,5,3,8,9,42,2,6};
    sort(a);
//    for(int j = 0 ; j < a.length ; j++){
//      System.out.print(a[j] + " ");
//    }
  }
}
