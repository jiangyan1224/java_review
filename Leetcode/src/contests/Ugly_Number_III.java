package contests;
//Write a program to find the n-th ugly number.
//        Ugly numbers are positive integers which are divisible by a or b or c.
//
//        Example 1:
//        Input: n = 3, a = 2, b = 3, c = 5
//        Output: 4
//        Explanation: The ugly numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3rd is 4.
//
//        Example 2:
//        Input: n = 4, a = 2, b = 3, c = 4
//        Output: 6
//        Explanation: The ugly numbers are 2, 3, 4, 6, 8, 9, 12... The 4th is 6.
//
//        Example 4:
//        Input: n = 1000000000, a = 2, b = 217983653, c = 336916467
//        Output: 1999999984
//取自155周leetcode竞赛的第二题，题目搞不懂什么意思了，告辞
//我这里写的是可以被a或b或c整除的第n个整数
public class Ugly_Number_III {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int[] ugly=new int[n+1];
        int ma=0,mb=0,mc=0,next;
        ugly[0]=1;
        for(int i=1;i<n+1;i++){
            next=min(ugly[ma]*a,ugly[mb]*b,ugly[mc]*c);
            ugly[i]=next;
            if(ugly[i]==ugly[ma]*a) ma++;
            if(ugly[i]==ugly[mb]*b) mb++;
            if(ugly[i]==ugly[mc]*c) mc++;
        }
        return ugly[n];
    }
    public int min(int a,int b,int c){
        if(a<=b&&a<=c) return a;
        else if(b<=a&&b<=c) return b;
        return c;
    }
}
