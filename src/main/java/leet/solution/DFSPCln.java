package leet.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS
 * 取排序和组合通用代码
 */
public class DFSPCln {

    /**
     *
     * @param candidates 入参数组
     * @param d 深度
     * @param n 要求的深度
     * @param used 标记数组 标记是否访问到
     * @param curr 当前数组
     * @param ans 结果数组
     */
    public void searchForP(int[] candidates,int d,int n,int[] used,List<String> curr,List<List<String>> ans){
        if(d == n){
            List<String> tmp  = new ArrayList<>(curr);
            ans.add(tmp);
            return;
        }else{
            for(int i = 0 ; i < candidates.length; i ++){
                if(used[i] == 1){
                    continue;
                }
                used[i] = 1;
                curr.add(candidates[i]+"");
                searchForP(candidates,d+1,n,used,curr,ans);
                curr.remove(curr.size()-1);
                used[i] = 0;
            }
        }
    }

    /**
     *
     * @param candidates 入参数组
     * @param d 深度
     * @param n 要求的深度
     * @param s 循环开始的下标
     * @param curr 当前数组
     * @param ans 结果数组
     */
    public void searchForC(int[] candidates,int d,int n,int s,List<String> curr,List<List<String>> ans){
        if(d == n){
            List<String> tmp  = new ArrayList<>(curr);
            ans.add(tmp);
            return;
        }else{
            for(int i = s ; i < candidates.length; i ++){
                curr.add(candidates[i]+"");
                searchForC(candidates,d+1,n,i+1,curr,ans);
                curr.remove(curr.size()-1);
            }
        }
    }

    public List<List<String>> pln(int[] candidates){
        List<List<String>> ans = new ArrayList<>();
        if(candidates.length == 0){
            return ans;
        }
        List<String> curr = new ArrayList<>();
        int[] used = new int[candidates.length];
        searchForP(candidates,0,candidates.length-1,used,curr,ans);
        return ans;
    }

    public List<List<String>> cln(int[] candidates){
        List<List<String>> ans = new ArrayList<>();
        if(candidates.length == 0){
            return ans;
        }
        List<String> curr = new ArrayList<>();
        int[] used = new int[candidates.length];
        searchForC(candidates,0,candidates.length-1,0,curr,ans);
        return ans;
    }

    public static void main(String[] args) {
        DFSPCln dfspCln = new DFSPCln();
        System.out.println("取排列：" + dfspCln.pln(new int[]{1,2,3}));
        System.out.println("取组合：" + dfspCln.cln(new int[]{1,2,3}));
    }
}
