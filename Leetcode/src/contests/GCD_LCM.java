package contests;
//GCD最大公约数
//LCM最小公倍数
public class GCD_LCM {
    public static long gcd(long num1,long num2){
        long r;
        if(num1<num2){
            //交换num1和num2，保证前一个数大于后一个数
            r=num1;num1=num2;num2=r;
        }
        while (num2!=0){
            r=num1;num1=num2;
            num2=r%num2;
        }
        //num1为最大公约数
        return num1;
    }
    public static long lcm(long a,long b){
        return a*b/gcd(a,b);
    }
//    public static void main(String[] args){
//        int num1=72,num2=729;
//        int gcd=gcd(num1,num2);
//        int lcm=num1*num2/gcd;
//        System.out.println(gcd);
//        System.out.println(lcm);
//    }
}
