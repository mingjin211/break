package geektime.structure.chapter12Sort2;

public class QuickSortYu {

  private static void quick_sort(int[] nums,int p,int r){
      System.out.print(p + "->" + r + " ");
      if(p >= r){
        System.out.println();
        return;
      }
      int q = partition(nums,p,r);
      for(int k = 0 ; k < nums.length ; k++){
        System.out.print(nums[k] + ",");
      }
      System.out.println();
      quick_sort(nums,p,q-1);
      quick_sort(nums,q+1,r);
  }

  private static int partition(int[] nums,int p,int r){
    int pivot = nums[r];
    int i = p;
    for(int j = p ; j < r ; j++){
      if(nums[j] < pivot){
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
        i++;
      }
    }
    nums[r] = nums[i];
    nums[i] = pivot;

    return i;
  }

  public static void main(String[] args){
    int[] a = {1,23,5,3,8,9,42,2,6};
    quick_sort(a,0,8);
    for(int j = 0 ; j < a.length ; j++){
      System.out.print(a[j] + " ");
    }
  }

}
