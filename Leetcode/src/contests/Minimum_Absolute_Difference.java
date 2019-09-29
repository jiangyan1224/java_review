package contests;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//给你个整数数组 arr，其中每个元素都不相同。
//请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回
//        示例 1：
//
//        输入：arr = [4,2,1,3]
//        输出：[[1,2],[2,3],[3,4]]
//        示例 2：
//
//        输入：arr = [1,3,6,10,15]
//        输出：[[1,3]]
//        示例 3：
//
//        输入：arr = [3,8,-10,23,19,-4,-14,27]
//        输出：[[-14,-10],[19,23],[23,27]]
//我的思路：先快排给数组排序，再遍历数组，得到最小绝对差值；再次遍历数组，如果相邻的一对之差满足最小绝对差值，加入列表
//要注意这里的List<List<Integer>>返回值和构造方法！！！！！！！！！！
//另一种构造方法：
//  List<List<Integer>> result = new ArrayList<>();
//        List<Integer> list = new ArrayList<>();
//        list.add(arr[i - 1]);
//        list.add(arr[i]);
//        result.add(list);
public class Minimum_Absolute_Difference {
    private void quickSort(int[] a,int low,int high){
        if (low>=high) return;
        int i=low,j=high,flag=a[low];
        int temp;
        while (i<j){
            while (a[j]>=flag&&i<j) j--;
            while (a[i]<=flag&&i<j) i++;
            if (i<j){
                temp=a[i];a[i]=a[j];a[j]=temp;
            }
        }
        a[low]=a[i];
        a[i]=flag;

        quickSort(a,low,i-1);
        quickSort(a,i+1,high);
    }
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> lists=new LinkedList<>();
        quickSort(arr,0,arr.length-1);
        int mindiff=Integer.MAX_VALUE;
        //找到最小绝对差值
        for (int i=0;i<arr.length-1;i++){
            if ((arr[i+1]-arr[i])<mindiff) mindiff=arr[i+1]-arr[i];
        }
        for (int i=0;i<arr.length-1;i++){
            if ((arr[i+1]-arr[i])==mindiff){
                lists.add(new LinkedList<>(Arrays.asList(arr[i],arr[i+1])));
            }
        }
        return lists;
    }
}
