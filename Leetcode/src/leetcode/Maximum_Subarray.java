package leetcode;
//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//        示例:
//
//        输入: [-2,1,-3,4,-1,2,1,-5,4],
//        输出: 6
//        解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
public class Maximum_Subarray {
    //动态规划法（DP）：dp[i]存放的是以i为末尾，最大的连续子序列和，dp[i]=（dp[i-1]+A[i]）或者（A[i]）
//    public int maxSubArray(int[] nums){
//        int n=nums.length;
//        int dp[]=new int[n];dp[0]=nums[0];
//        //sum存放dp数组中的最大值
//        int sum=dp[0];
//        for (int i=1;i<n;i++){
//            dp[i]=nums[i]+(dp[i-1]>0?dp[i-1]:0);
//            if (sum<dp[i]) sum=dp[i];
//        }
//        return sum;
//    }
    //分治法：最大连续子序列只有三种情况：在数组左边或在数组右边或者贯穿数组中间元素；
    // 左边右边可以用递归实现；中间部分可以分成两个部分：mid开始向右连续最大加上mid开始向左开始最大，然后加起来得到结果
    //最后把左右中三个最大值比较，返回其中的最大值
//    public int maxSubArray(int[] nums) {
//        int maxsum=subArray(nums,0,nums.length-1);
//        System.out.println(maxsum);
//        return maxsum;
//    }
//    public int subArray(int[] A,int left,int right){
    //注意递归一定要设置出口
//        if(left==right) return A[left];
//        int mid=left+(right-left)/2;
//        int lmaxsum=subArray(A,left,mid);
//        int rmaxsum=subArray(A,mid+1,right);
//        int mmaxsum=midArray(A,mid,left,right);
////        System.out.print("rmaxsum:"); System.out.println(rmaxsum);
////        System.out.print("lmaxsum:"); System.out.println(lmaxsum);
////        System.out.print("mmaxsum:"); System.out.println(mmaxsum);
//        if(mmaxsum>=rmaxsum&&mmaxsum>=lmaxsum) return mmaxsum;
//        if(rmaxsum>=lmaxsum&&rmaxsum>=mmaxsum) return rmaxsum;
//        else return lmaxsum;
//    }
//    public int midArray(int[] A,int mid,int left,int right){
//        int sum=0;
//        int rsum=Integer.MIN_VALUE,lsum=Integer.MIN_VALUE;
//        int maxsum;
//        for(int i=mid+1;i<=right;i++){
//            sum+=A[i];
//            if(rsum<sum) rsum=sum;
//        }
//        sum=0;
//        for(int i=mid;i>=left;i--){
//            sum+=A[i];
//            if(lsum<sum) lsum=sum;
//        }
//        maxsum=rsum+lsum;
////        System.out.print("rsum:"); System.out.println(rsum);
////        System.out.print("lsum:"); System.out.println(lsum);
//        return maxsum;
//    }
}
