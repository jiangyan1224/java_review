package leetcode;
//Say you have an array for which the ith element is the price of a given stock on day i.
//If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
//        design an algorithm to find the maximum profit.
//        Note that you cannot sell a stock before you buy one.
//
//        Example 1:
//        Input: [7,1,5,3,6,4]
//        Output: 5
//        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//        Not 7-1 = 6, as selling price needs to be larger than buying price.
//
//        Example 2:
//        Input: [7,6,4,3,1]
//        Output: 0
//        Explanation: In this case, no transaction is done, i.e. max profit = 0.
public class Best_Time_to_Buy_and_Sell_Stock {
    //自己的解法1：暴力法，时间复杂度O(n^2)空间复杂度O(1)
//    public int maxProfit(int[] prices) {
//         int maxdiff=0,diff;
//         int n=prices.length;
//         for(int i=0;i<n-1;i++){
//             for(int j=i+1;j<n;j++){
//                 diff=prices[j]-prices[i];
//                 if(diff>maxdiff) maxdiff=diff;
//             }
//         }
//         return maxdiff;
//    }
    //自己的解法2：分治法，和最大子串的分治法思路类似：
    //时间复杂度O(nlogn)空间复杂度O(n)
    public int maxProfit(int[] prices) {
        int maxdiff=maxDiff(prices,0,prices.length-1);
        return maxdiff;

    }
    public int maxDiff(int[] a,int left,int right){
        if(right==left+1){
            if(a[right]-a[left]>0) return (a[right]-a[left]);
            else return 0;
        }
        if((right-left)<1) return 0;
        int mid=left+(right-left)/2;
        int diff1=maxDiff(a,left,mid);
        int diff2=maxDiff(a,mid+1,right);
        int diff3=midDiff(a,left,mid,right);
        if(diff1>=diff2&&diff1>=diff3) return diff1;
        if(diff2>=diff1&&diff2>=diff3) return diff2;
        return diff3;
    }
    public int midDiff(int[] a,int left,int mid,int right){
        int min=a[left],max=a[mid];
        for(int i=left;i<=mid;i++){
            if(a[i]<min) min=a[i];
        }
        for(int i=mid;i<=right;i++){
            if(a[i]>max) max=a[i];
        }
        return (max-min);
    }
}
