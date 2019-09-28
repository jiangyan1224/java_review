package leetcode;

import java.util.HashMap;
import java.util.Map;

//给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//可以假设数组是非空的，并且给定的数组总是存在众数。
public class Majority_Element {
    //我的解法1：如果一个数是众数，一定可以把其他数都抵消掉而且自己最后还剩至少一个
    //时间复杂度O(n)空间复杂度O(1)
//    public int majorityElement(int[] nums) {
//        int val=nums[0],cnt=1,i;
//        int n=nums.length;
//        for (i=0;i<n;i++){
//            if (nums[i]==val)cnt++;
//            else cnt--;
//            if (cnt<=0){val=nums[i];cnt=1;}
//        }
//        return val;
////        cnt=0;
////        for (i=0;i<n;i++){
////            if (nums[i]==val) cnt++;
////        }
////        if (cnt>n/2) return val;
//    }
    //我的解法2：用hashmap存储每个元素的值以及对应的出现次数
    //时间复杂度O(n)空间复杂度O(n)
//    public int majorityElement(int[] nums){
//        HashMap<Integer,Integer> map=new HashMap<>();
//        int i,n=nums.length,value;
//        for (i=0;i<n;i++){
//            //如果map里面没有当前数组值，添加
//            if (!map.containsKey(nums[i])){
//                map.put(nums[i],1);
//            }
//            else {
////                //如果已经有当前数组值，
////                a.先取出该元素和对应value值，value+1，再存入map
////                value=map.get(nums[i]);
////                map.remove(nums[i]);
////                map.put(nums[i],1+value);
////                b.不用先取出再放入，可以直接put，可以直接覆盖之值对键值对
//                map.put(nums[i],1+map.get(nums[i]));
//            }
    //其实这里可以做一个判断，判断此时num[i]对应出现次数是否已经超过n/2,如果成立直接return，就不需要再次遍历hashmap
//        }
//        for (int key:map.keySet()){
//            if (map.get(key)>n/2) return key;
//        }
//        return 0;
//    }
    //高赞答案1：也是HashMap实现，原理和我的解法2类似，但是代码更加简洁，后面hashmap的遍历方法也不一样:
//Map.Entry是Map的一个内部接口,此接口为泛型，定义为Entry。它表示Map中的一个实体（一个key-value对）。接口中有getKey(),getValue方法。
//Map提供了一些常用方法，如keySet()、entrySet()等方法。
//keySet()方法返回值是Map中key值的集合；entrySet()的返回值也是返回一个Set集合，此集合的类型为Map.Entry。
    //时间复杂度O(n)空间复杂度O(n)
//       private Map<Integer,Integer> countNums(int[] nums){
//           Map<Integer,Integer> map=new HashMap<Integer, Integer>();
//           for (int num:nums){
//               if (!map.containsKey(num)){
//                   map.put(num,1);
//               }else {
//                   map.put(num,1+map.get(num));
//               }
    //其实这里可以做一个判断，判断此时num对应出现次数是否已经超过n/2,如果成立直接return，就不需要再次遍历hashmap
//           }
//           return map;
//       }
//       public int majorityElement(int[] nums){
//           Map<Integer,Integer> map=countNums(nums);
//           Map.Entry<Integer,Integer> majorityEntry=null;
//           for (Map.Entry<Integer,Integer> entry:
//                map.entrySet()) {
//               if (majorityEntry==null||entry.getValue()>majorityEntry.getValue()){
//                   majorityEntry=entry;
//               }
//           }
//           return majorityEntry.getKey();
//       }
    //高赞答案2：分治法：如果数组长度为1，那么众数就是这个元素；把数组分为左右两半，递归进行
    //时间复杂度O(nlogn)空间复杂度O(logn)
//    private int countInRange(int []nums,int num,int low,int high){
//        int count=0;
//        for(int i=low;i<=high;i++){
//            if (nums[i]==num) count++;
//        }
//        return count;
//    }
//    private int majorityElementRec(int[] nums,int low,int high){
//        if (low==high) return nums[low];
//        int mid=low+(high-low)/2;
//        int leftm=majorityElementRec(nums,low,mid);
//        int rightm=majorityElementRec(nums,mid+1,high);
//        if (leftm==rightm) return leftm;
//        int leftCount=countInRange(nums,leftm,low,high);
//        int rightCount=countInRange(nums,rightm,low,high);
//
//        return leftCount>=rightCount?leftm:rightm;
//    }
//    public int majorityElement(int[] nums){
//        return majorityElementRec(nums,0,nums.length-1);
//    }
    //高赞答案3：多数投票算法(Boyer-Moore Algorithm)，其实和我的解法1是相同的解法,不过遍历中，这种解法是先判断，我是后判断：
//    public int majorityElement(int[] nums){
//        int count=0;
//        Integer candidate=null;
//        for (int num:
//             nums) {
//            if (count==0){
//                candidate=num;
//            }
//            count+=(candidate==num)?1:-1;
//        }
//        return candidate;
//    }

}
