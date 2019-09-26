package leetcode;
//Given a non-empty array of integers, every element appears twice except for one. Find that single one.
//        Note:
//        Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//
//        Example 1:
//        Input: [2,2,1]
//        Output: 1
//
//        Example 2:
//        Input: [4,1,2,1,2]
//        Output: 4

import java.util.HashSet;
import java.util.Set;

public class Single_Number {
    //我自己的方法1：暴力，先给数组排序，再找到single number
    //时间复杂度O(n^2)空间复杂度O(1)
//    public int singleNumber(int[] nums) {
//        int n=nums.length,i,j,temp;
//        for(i=0;i<n-1;i++){
//            for(j=0;j<n-1;j++){
//                if(nums[j]>nums[j+1]){
//                    temp=nums[j];nums[j]=nums[j+1];nums[j+1]=temp;
//                }
//            }
//        }
//        for(i=0;i<n-1;){
//            if(nums[i]==nums[i+1]) i+=2;
//            else break;
//        }
//        //single number可能是第一个或者最后一个或者在数组中间
//        return nums[i];
//    }
    //高赞方法1：异或：将所有数按位异或，相同的数结果为0，剩下一个单独的数，即为结果
//    public int singleNumber(int[] nums){
//        int x=0;
//        for(int num:nums){
//            x^=num;
//        }
//        return x;
//    }
    //高赞方法2：HashSet：存放元素没有顺序且不允许重复元素，若要加入的元素有重复，返回false，集合不动
    public int singleNumber(int[] nums){
       Set<Integer> s=new HashSet<Integer>();
        for (int num:nums){
            if (!s.add(num)){
                s.remove(num);
            }
        }
        //HashSet没有get方法，只能用迭代器：迭代器用于遍历容器对象，且不会暴露对象的内部细节
        // hasNext()判断容器是否有下一个元素，返回true或false； next()方法返回容器下一个元素
        return s.iterator().next();
    }
}
