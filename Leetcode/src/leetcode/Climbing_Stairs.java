package leetcode;
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
//        每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
//        注意：给定 n 是一个正整数。
//
//        示例 1：
//        输入： 2
//        输出： 2
//        解释： 有两种方法可以爬到楼顶。
//        1.  1 阶 + 1 阶
//        2.  2 阶
//
//        示例 2：
//        输入： 3
//        输出： 3
//        解释： 有三种方法可以爬到楼顶。
//        1.  1 阶 + 1 阶 + 1 阶
//        2.  1 阶 + 2 阶
//        3.  2 阶 + 1 阶
public class Climbing_Stairs {
    //我的做法一：迭代法，但是leetcode显示超过时间限制，当n=44的时候，时间就太长了(自上而下)
    //时间复杂度O(2^n）:画二叉树，每个结点的值都要求出值，n阶楼梯构成树高为n的二叉树，一共要算2^n-1次，所以时间复杂度
    //空间复杂度O（n）：因为递归函数的调用，Java要使用栈来存储上一次函数的值，二叉树高为n，所以空间复杂度为n
//    public int climbStairs(int n) {
//        if(n==1) return 1;
//        if(n==2) return 2;
//        else return climbStairs(n-1)+climbStairs(n-2);
//    }
    //我的做法二：不用迭代，用另一种方法实现：（自下而上）
    //因为数列正好是斐波那契，所以这样实现：时间复杂度O(n）空间复杂度O（1）
//    public int climbStairs(int n){
//        int min=1,max=2;
//        int sum=0;
//        for (int i=2;i<n;i++){
//            sum=min+max;
//            min=max;
//            max=sum;
//        }
//        if (n==1) return min;
//        return max;
//    }
    //高赞答案1：动态规划：dp[i]表示上i阶楼梯的方法个数，则dp[i+1]=dp[i]+dp[i-1]
    //时间复杂度和空间复杂度均为O（n）
    //这里要注意的是数组的初始化和遍历边界：数组长度至少要到dp[2]，也就是长度至少为3，才能装得下两个初始值；如果不处理会报ArrayIndexOutOfBoundsException
    //如果输入的是1或者2，直接new int[n]长度不够，所以用new int[n+1]，n=2也可以满足，而n=1的情况单独返回即可
    //遍历边界要代个数进去试一试，看边界到底在哪，遍历到哪个数结束
    //时间复杂度O（n） 空间复杂度O（n）
//    public int climbStairs(int n){
//        if (n==1) return 1;
//        int dp[]=new int[n+1];
//        dp[0]=0;dp[1]=1;dp[2]=2;
//        for (int i=3;i<=n;i++){
//            dp[i]=dp[i-1]+dp[i-2];
//        }
//        return dp[n];
//    }
    //高赞答案2：记忆性递归：它和递归类似，
    // 但是在这一过程中，记忆性递归把已经算出来的值存储到数组里，下次再要算同样的值就不用重复计算，减少冗余计算量
    //climb（i,n,memo[])中，i是指已经走了多少阶楼梯，n是指一共多少阶楼梯
    //memo[i]=climb(i+1,n,memo)+climb(i+2,n,memo);已经走了i阶，再走一阶的情况加上再走两阶的情况，构成所有情况
    //memo[i]为已经走了i阶楼梯，上完所有楼梯的总方法数
    //时间复杂度O（n） 空间复杂度O（n）
//    public int climbStairs(int n){
//        int []memo=new int[n+1];
//        int sum=climb(0,n,memo);
//        return sum;
//    }
//    public int climb(int i,int n,int memo[]){
//        if (i>n) return 0;
//        if (i==n) return 1;
//        if (memo[i]>0) return memo[i];
//        memo[i]=climb(i+1,n,memo)+climb(i+2,n,memo);
//        return memo[i];
//    }
    //高赞答案3：斐波那契公式：
//    public int climbStairs(int n){
//        double sqr5=Math.sqrt(5);//根号5
//        double fibn=Math.pow((sqr5+1)/2,n+1)-Math.pow((1-sqr5)/2,n+1);
//        return (int)(fibn/sqr5);
//    }

}
