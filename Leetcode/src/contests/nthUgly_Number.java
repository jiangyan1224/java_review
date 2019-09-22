package contests;
//题目：丑数
//        * 我们把只包含因子2，3，5的数称为丑数（Ugly Number).
//        * 求按从小到大的顺序的第1500个丑数。
//
//        * 例如6，8都是丑数，但14不是，因为它含有因子7.习惯上我们把1当作第一个丑数
//给定a b c，找到第n个丑数 https://blog.csdn.net/jsqfengbao/article/details/47375263(博客答案跟这个有区别)
//Ps:要判断一个整数是不是丑数，目前认为只有暴力法（2019.9.22）
public class nthUgly_Number {
    public int nthUglyNumber(int n, int a, int b, int c) {
        int[] ugly=new int[10000];
        int ma=0,mb=0,mc=0,next;
        ugly[0]=1;
        for(int i=1;i<n+1;i++){
            next=min(ugly[ma]*a,ugly[mb]*b,ugly[mc]*c);
            ugly[i]=next;
            if(ugly[i]==ugly[ma]*a) ma++;
            if(ugly[i]==ugly[mb]*b) mb++;
            if(ugly[i]==ugly[mc]*c) mc++;
        }
        for (int i=0;i<n+1;i++){System.out.println(ugly[i]);}
        return ugly[n];
    }
    public int min(int a,int b,int c){
        if(a<=b&&a<=c) return a;
        else if(b<=a&&b<=c) return b;
        return c;
    }
}
