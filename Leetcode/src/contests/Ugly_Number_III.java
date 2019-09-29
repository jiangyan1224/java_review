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

public class Ugly_Number_III {
    //这里写的是可以被a或b或c整除的第n个整数,但是复杂度过高，没有通过
//    public int nthUglyNumber(int n, int a, int b, int c) {
//        int[] ugly=new int[n+1];
//        int ma=0,mb=0,mc=0,next;
//        ugly[0]=1;
//        for(int i=1;i<n+1;i++){
//            next=min(ugly[ma]*a,ugly[mb]*b,ugly[mc]*c);
//            ugly[i]=next;
//            if(ugly[i]==ugly[ma]*a) ma++;
//            if(ugly[i]==ugly[mb]*b) mb++;
//            if(ugly[i]==ugly[mc]*c) mc++;
//        }
//        return ugly[n];
//    }
//    public int min(int a,int b,int c){
//        if(a<=b&&a<=c) return a;
//        else if(b<=a&&b<=c) return b;
//        return c;
//    }
    //解法2:1~n中，能被a整除的数有n/a个，先看1~n中有多少个丑数，如果不够n个，再往后增大范围，直到找到第n个
    //时间复杂度小于上面的方法，但是还可以二分查找，再降低时间复杂度
//    private boolean ifUgly(int n,int a,int b,int c){
//        if(n%a==0||n%b==0||n%c==0) return true;
//        return false;
//    }
//    public int nthUglyNumber(int n,int a,int b,int c){
//        //这里一定要把最小公倍数类型设置为long，否则可能会出现相乘之后超过Int上限(2^31-1)，导致算出来的lcm是负数
//        long lcm1= GCD_LCM.lcm(a,b);
//        long lcm2= GCD_LCM.lcm(b,c);
//        long lcm3= GCD_LCM.lcm(a,c);
//        long lcm4= GCD_LCM.lcm(a,lcm2);
////        System.out.println(lcm1);
////        System.out.println(lcm2);
////        System.out.println(lcm3);
////        System.out.println(lcm4);
////        System.out.println("--------------------\n");
//        long tempn=n;//暂存n的值
//        long temp;
//        while(true){
//            //1~tempn之间有temp个丑数
//            temp=tempn/a+tempn/b+tempn/c-tempn/lcm1-tempn/lcm2-tempn/lcm3+tempn/lcm4;
////            System.out.println(temp);
//            long diff=n-temp;
//            //事实上，假设还差diff个丑数，tempn就再往后加diff个数，新增的部分最多也只会有diff个丑数，这样下去，diff一定会直接等于0，
//            //最后新增的那个数，即最后tempn的值，一定是第n个丑数
//            if (diff<=0) break;
//            tempn+=diff;
//        }
//        return (int)tempn;
//
//    }
    //解法3：题目给了第n个丑数的最大值为2*10^9(这个数已经超过了int的上限2^31-1),最小值是a b c较小值，范围已知
//    也有方法求出小于给定整数 的范围内的丑数个数，可以设置左右下标，初值为0和2*10^9，找到mid,
//    如果mid中没有那么多丑数，left=mid+1;反之right=mid-1:
//    像这种left=mid+1/right=mid-1缩小范围的，最后一定会出现left==right的情况
//    而且根据left right取值的情况，1~mid<n时，left=mid+1,那么1~left<n+1<=n
//                                  1~mid>=n时，right=mid-1,那么1~right>=n-1
//                                  1~result>=n
//    当left==right,如果为nth,right=mid-1,result=mid;
//    当left==right==(n-1)th，left=mid+1,但是因为result>=n,result=right+1,所以result一定是nth

    int MAX_ANS = 2 * 1000000000; // 2*10^9
    //求最大公倍数和最小公约数：
    public long gcd(long a,long b){
        long r;
        if (a<b){r=a;a=b;b=r;}
        while (b!=0){
            r=a;a=b;
            b=r%b;
        }
        return a;
    }
    public long lcm(long a,long b){
        return a*b/gcd(a,b);
    }
    //计算1~num之间有多少个丑数，因为最后的结果可能会超过int上限，用long
    public long count(long num,long a,long b,long c){
        return (num/a+num/b+num/c
                -num/lcm(a,b)-num/lcm(a,c)-num/lcm(b,c)
                +num/lcm(a,lcm(b,c)));
    }
    public int nthUglyNumber(int n, int a, int b, int c) {
        int left=0,right=MAX_ANS,mid,result=0;
        while (left<=right){
            mid=left+(right-left)/2;
            if (count(mid,a,b,c)>=mid){
                result=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return result;
    }
}
