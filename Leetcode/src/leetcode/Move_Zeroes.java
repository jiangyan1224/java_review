package leetcode;

public class Move_Zeroes {
    //1自己的解法：两个指针，i指向下一个0，j从i开始，往后找到第一个非0，i和j交换
    //i++，一直循环到j指向最后一个元素并交换
//    public void moveZeroes(int[] a) {
//        int i=0,j=0;
//        int n=a.length;
//        while(j<n-1){
//            while(i<n-1&&a[i]!=0) i++;
//            j=i;
//            while(j<n-1&&a[j]==0) j++;
//            int temp=a[i];a[i]=a[j];a[j]=temp;
//            i++;
//        }
//    }
    public void moveZeroes(int[] a){
        //但是其实i是不需要特地再定位的，只定位j就可以，这样不仅免掉了避免两个指针超出范围的麻饭，也让时间复杂度下降
        //j直接循环到下一个非0元素，i如果非0，i一定==j；i如果为0，ij交换再i++
        int i=0,j=0;
        int n=a.length;
        for(;j<n;j++){
            if (a[j]!=0){
                int temp=a[i];a[i]=a[j];a[j]=temp;
                i++;
            }
        }
    }
}
