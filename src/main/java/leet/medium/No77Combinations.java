package leet.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * No 77
 * Code combinations
 * Url https://leetcode-cn.com/problems/combinations/
 * Status pass
 * Answer https://leetcode-cn.com/articles/combinations/
 * Comments search combination
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 */
public class No77Combinations {

  private static List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    recursionSum(n,k,1,path,result);
    return result;
  }

  private static void recursionSum(int n, int k,int index ,ArrayList<Integer> path,List<List<Integer>> result){
    System.out.println("index:" + index + " temp:" + new ArrayList<>(path));
    if(path.size() == k){
      result.add(new ArrayList<>(path));
      return;
    }
    for(int i = index ; i <= n ; ++i){
      path.add(i);
      recursionSum(n,k,i + 1,path,result);
      path.remove(path.size() -1);
    }
  }

  public static void main(String args[]){
    System.out.println(combine(4,2));
  }

}
