package geektime.structure.chapter12Sort2;

public class MergeSortYu {

  private static void merge_sort(int[] nums,int p,int r){
    if(p >= r){
      return;
    }
    int q = (p+r)/2;
    merge_sort(nums,p,q);
    merge_sort(nums,q+1,r);
    merge(nums,p,r,q);
  }

  private static void merge(int[] nums,int p,int r,int q){
    int[] tmp = new int[r-p+1];
    int i = p;
    int j = q+1;
    int k = 0;
    while( i <= q && j <= r){
      if(nums[i] <= nums[j]){
        tmp[k] = nums[i];
        i++;
      }else{
        tmp[k] = nums[j];
        j++;
      }
      k++;
    }

    if( j > r ){
      for(; k < tmp.length && i <= q; k++){
        tmp[k] = nums[i];
        i++;
      }
    }else{
      for(; k < tmp.length && j <= r; k++){
        tmp[k] = nums[j];
        j++;
      }
    }

    for(k = 0 ; k < tmp.length ; k++){
      nums[p+k] = tmp[k];
    }
  }

  public static void main(String[] args){
    int[] a = {1,23,5,3,8,9,42,2,6};
    merge_sort(a,0,8);
    for(int j = 0 ; j < a.length ; j++){
      System.out.print(a[j] + " ");
    }
  }
}
