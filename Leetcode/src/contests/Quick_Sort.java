package contests;

import java.util.Arrays;

//快速排序https://blog.csdn.net/shujuelin/article/details/82423852
public class Quick_Sort {
    public static void quickSort(int[] arr,int low,int high){
        //注意！！！对low high下标的判断一定要放在最前面，否则会报下表越界异常
        if (low>=high) return;
        int i,j,flag=arr[low];//以第一个元素为基准
        int temp;
        i=low;j=high;
        while (i<j){
            //因为选定的基准在最左边，所以要先从最右边判断https://blog.csdn.net/lkp1603645756/article/details/85008715
            while (arr[j]>=flag&&i<j) j--;
            while (arr[i]<=flag&&i<j) i++;
            if (i<j){//减少了i==j时的交换操作
                temp=arr[i];arr[i]=arr[j];arr[j]=temp;
            }
        }
        arr[low]=arr[i];
        arr[i]=flag;
        //至此，快排一趟结束
        quickSort(arr,low,i-1);
        quickSort(arr,i+1,high);
    }
    public static void main(String[] args){
        int[] arr={10,7,2,4,7,62,3,4,2,1,8,9,19};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
