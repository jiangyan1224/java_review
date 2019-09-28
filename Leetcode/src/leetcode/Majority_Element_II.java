package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Majority_Element_II {
    public List<Integer> majorityElement(int[] nums){
        List<Integer> res=new ArrayList<Integer>();
        if (nums==null) return res;
        int[] count=new int[2];
        //因为满足条件的数,一个数组最多可以有两个
        int[] x=new int[2];
        for (int num:
             nums) {
            if (x[0]==num){
                count[0]++;
            }else if (x[1]==num){
                count[1]++;
            }else if (count[0]==0){
                x[0]=num;count[0]=1;
            }else if (count[1]==0){
                x[1]=num;count[1]=1;
            }else {
                count[0]--;
                count[1]--;
            }
        }
        for (int i=0;i<2;i++){
            System.out.println(x[i]);
        }
        Arrays.fill(count,0);
        for (int i:
             nums) {
            if (i==x[0]){count[0]++;}
            else if (i==x[1]){count[1]++;}
            //这里!res.contains(x[0])要有，否则已经存入res的元素会被重复判断并重复存入res
            if (count[0]>nums.length/3&&!res.contains(x[0])) {res.add(x[0]);}
            if (count[1]>nums.length/3&&!res.contains(x[1])) {res.add(x[1]);}
        }
        return res;
    }
}
