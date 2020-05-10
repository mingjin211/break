package practice;

import java.time.LocalDate;
import java.util.Arrays;

public class Choucai {

    public static void main(String args[]){
        int n = 46;
        int[] number = new int[n];
        for(int i = 0 ; i < n ; i++){
            number[i] = i+1;
        }
        int[] result = new int[6];
        for(int i = 0 ; i < 6 ; i++){
            int r = (int) (Math.random() * n);
            result[i] = number[r];
            number[r] = number[n-1];
            n--;
        }
        System.out.println(Arrays.toString(result));
    }
}
