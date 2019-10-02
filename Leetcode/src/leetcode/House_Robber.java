package leetcode;

import java.util.Arrays;

//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
//影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
//给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
//
//        示例 1:
//        输入: [1,2,3,1]
//        输出: 4
//        解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//             偷窃到的最高金额 = 1 + 3 = 4 。
//
//        示例 2:
//        输入: [2,7,9,3,1]
//        输出: 12
//        解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//             偷窃到的最高金额 = 2 + 9 + 1 = 12 。
public class House_Robber {
    //第一步，式子要想明白
    //rob(i)=MAX(rob(i-1),nums[i]+rob(i-2))
    //1递归，自上而下
    //时间复杂度O(2^n）:画二叉树，每个结点的值都要求出值，n阶楼梯构成树高为n的二叉树，一共要算2^n-1次，所以时间复杂度
    //空间复杂度O（n）：因为递归函数的调用，Java要使用栈来存储上一次函数的值，二叉树高为n，所以空间复杂度为n
//    public int rob(int[] nums) {
//        return rob(nums,nums.length-1);
//    }
//    private int rob(int[] nums,int i){
//        if (i<0) return 0;
//        return Math.max(rob(nums,i-1),rob(nums,i-2)+nums[i]);
//    }
    //2记忆形递归，自上而下,记忆性递归把已经算出来的值存储到数组里，下次再要算同样的值就不用重复计算，减少冗余计算量
//    时间复杂度O(n) 空间复杂度O(n)
//    public int rob(int[] nums) {
//        int[] memo=new int[nums.length];
//        Arrays.fill(memo,-1);
//        int sum=rob(nums,memo,nums.length-1);
//        return sum;
//    }
//    private int rob(int[] nums,int[] memo,int i){
//        if (i<0) return 0;
//        if (memo[i]>=0) return memo[i];
////        memo[i]=Math.max(memo[i-1],nums[i]+memo[i-2]);
//        memo[i]=Math.max(rob(nums,memo,i-1),rob(nums,memo,i-2)+nums[i]);
//        return memo[i];
//    }
    //3需要记忆数组的动态规划，自下而上
//    public int rob(int[] nums){
//        //这里的判断是为了防止memo[1]=nums[0];抛出下标越界异常
//        if (nums.length==0) return 0;
//        int[] memo=new int[nums.length+1];
//        memo[0]=0;
//        memo[1]=nums[0];
//        for(int i=1;i<nums.length;i++){
//            memo[i+1]=Math.max(memo[i],nums[i]+memo[i-1]);
//        }
//        return memo[nums.length];
//    }
    //4只需要两个变量的动态规划，自下而上
    public int rob(int[] nums){
        if (nums.length==0) return 0;
        int min=0,max=0;
        int temp;
        for (int num : nums) {
            temp = Math.max(min + num, max);
            min = max;
            max = temp;
        }
        return max;
    }
}
