package contests;

import java.util.Arrays;

//给你两个长度相同的字符串，s 和 t。将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），
//也就是两个字符的 ASCII 码值的差的绝对值。
//用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
//如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
//如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
//        示例 1：
//        输入：s = "abcd", t = "bcdf", cost = 3
//        输出：3
//        解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
//
//        示例 2：
//        输入：s = "abcd", t = "cdef", cost = 3
//        输出：1
//        解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
//
//        示例 3：
//        输入：s = "abcd", t = "acde", cost = 0
//        输出：1
//        解释：你无法作出任何改动，所以最大长度为 1。
//
//        提示：
//        1 <= s.length, t.length <= 10^5
//        0 <= maxCost <= 10^6
//        s 和 t 都只含小写英文字母。
public class Get_Equal_Substrings_Within_Budget {
    //错误答案：设arr数组存储s t对应元素之间的绝对值差
    // 设dp[i]是arr[i]往前的最长子序列，val[i]为对应子序列之和
//        public int equalSubstring(String s, String t, int maxCost) {
//         int n=s.length();
//         int[] arr=new int[n];
//         for (int i = 0; i <n ; i++) {
//             arr[i]=Math.abs(s.charAt(i)-t.charAt(i));
//         }

//         int[] dp=new int[n];
//         int[] val=new int[n];
//         dp[0]=arr[0]>maxCost?0:1;
//         val[0]=arr[0]>maxCost?0:arr[0];

//         for (int i = 0; i <n-1 ; i++) {
//             if (arr[i+1]>maxCost){
//                 dp[i+1]=0;val[i+1]=0;
//             }
//             else {
    //错误原因：当上一个val+下一个arr之和超过cost，不能直接判断这里的dp就是1，
    // 因为有可能当前元素往前求和，可以获得限定条件下的更长序列
//                 int temp = val[i] + arr[i + 1];
//                 if ( temp>maxCost){
//                     dp[i+1]=1;val[i+1]=arr[i+1];
//                 }
//                 else {
//                     dp[i+1]=dp[i]+1;
//                     val[i+1]= temp;
//                 }
//             }
//         }

    //         int max=dp[0];
//         for (int num:
//              dp) {
//             if (max<=num) max=num;
//         }
//         return max;
//     }


//    public int equalSubstring(String s, String t, int maxCost) {
//        //改正上个代码的错误，我的答案，但是时间复杂度最高能有O(n^2)
//        int n=s.length();
//        int[] arr=new int[n];
//        for (int i = 0; i <n ; i++) {
//            arr[i]=Math.abs(s.charAt(i)-t.charAt(i));
//        }
//        System.out.println(Arrays.toString(arr));
//
//        int[] dp=new int[n];
//        int[] val=new int[n];
//        dp[0]=arr[0]>maxCost?0:1;
//        val[0]=arr[0]>maxCost?0:arr[0];
//
//        for (int i = 0; i <n-1 ; i++) {
//            int temp = val[i] + arr[i + 1];
//            if ( temp>maxCost){
//                //改正上个代码的错误
//                int dpp=0,sum=0;
//                while (true){
//                    sum+=arr[i+1-dpp];
//                    if (sum>maxCost) break;
//                    dpp++;
//                }
//                dp[i+1]=dpp;val[i+1]=sum-arr[i+1-dpp];
//            }
//            else {
//                dp[i+1]=dp[i]+1;
//                val[i+1]= temp;
//            }
//        }
//        System.out.println(Arrays.toString(dp));
//
//        int max=dp[0];
//        for (int num:
//                dp) {
//            if (max<=num) max=num;
//        }
//        return max;
//    }

    //这个问题可以转化为滑动窗口问题，时间复杂度就可以降为O(n)
//    public int equalSubstring(String s, String t, int maxCost){
//        int n=s.length();
//        int[] arr=new int[n];
//        for (int i = 0; i <n ; i++) {
//            arr[i]=Math.abs(s.charAt(i)-t.charAt(i));
//        }
//
//        //滑动窗口
//        int len=0,start=0,curCost=0;
//        for (int end=0;end<n;end++){
//            curCost+=arr[end];
//            while (curCost>maxCost){
//                curCost-=arr[start];
//                start++;
//            }
//            len=Math.max(len,end-start+1);
//        }
//        return len;
//    }
    //还是用上一个滑动窗口的思想，但是把arr数组取消掉，就可以让时间复杂度保持O(n)，空间复杂度降为O(1)
    public int equalSubstring(String s, String t, int maxCost){
        int len=0,start=0,curCost=0;
        for (int end=0;end<s.length();end++){
            curCost+=Math.abs(s.charAt(end)-t.charAt(end));
            while (curCost>maxCost){
                curCost-=Math.abs(s.charAt(start)-t.charAt(start));
                start++;
            }
            len=Math.max(len,end-start+1);
        }
        return len;
    }
}
