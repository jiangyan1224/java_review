package contests;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
//如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
//        示例 1：
//        输入：arr = [1,2,2,1,1,3]
//        输出：true
//        解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
//
//        示例 2：
//        输入：arr = [1,2]
//        输出：false
//
//        示例 3：
//        输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
//        输出：true
//
//        提示：
//        1 <= arr.length <= 1000
//        -1000 <= arr[i] <= 1000
public class Unique_Number_of_Occurrences {
    public boolean uniqueOccurrences(int[] arr){
        Map<Integer,Integer> map=new HashMap<>();
        int i,n=arr.length;
        //遍历数组，把元素和对应出现次数存入map
        for (int num:
             arr) {
            map.computeIfAbsent(num,(dummy)-> 1);
            int val=1+ map.get(num);
            map.put(num,val);
        }

        Set<Integer> set=new HashSet<>();
        for (int num:
             map.values()) {
            set.add(num);
        }
        if (set.size()==map.values().size()) return true;//次数没有重复
        return false;

    }
}
