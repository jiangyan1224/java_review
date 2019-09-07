import java.util.Scanner;
public class Scannertest {
    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        sc.nextInt();
//        int a=sc.nextInt();
//        System.out.println(a);
//          String input=null;
//          boolean hasnext=sc.hasNext();
//          System.out.println(hasnext);
//          while(sc.hasNext()){
//              System.out.println("请输入");
//              input=sc.nextLine();
//              System.out.println(input);
//          }

//        input=sc.next();
//        System.out.println(input.length());
//        System.out.println(sc.nextLine().length());//输出回车,长度为0

        //需要读取了整数后，接着读取字符串
//        int a=sc.nextInt();
//        System.out.println(a);
//        sc.nextLine();
//        input=sc.nextLine();
//        System.out.println(input);

        //借助Scanner获取控制台输入的两个任意数字，然后使用
        //> 大于
        //>= 大于或等于
        //< 小于
        //<= 小于或等于
        //== 是否相等
        //!= 是否不等
        //
        //判断两个值之间的关系
//        int a=sc.nextInt();
//        System.out.println(a);
//        int b=sc.nextInt();
//        System.out.println(b);
//        System.out.println("a>b="+(a>b));
//          sc.close();

        //运算符，异或相异为真；高到低：括号 一元！ 算数 关系 逻辑 三元赋值
        //false 3
//        int i = 1;
//        boolean b = !(i++ == 3) ^ (i++ ==2) && (++i==3);//短路与
//        System.out.println(b);
//        System.out.println(i);

        //2
//        int i = 3; // 二进制是11
//        int j = 2; // 二进制是10
//        int c = ((i | j) ^ (i & j)) << 2 >>> 1;
//        System.out.println(c);

        //3
//        int i = 1;
//        i+=++i;
//        System.out.println(i);

//        通过Scanner输入一个1-7之间的整数，使用三元操作符判断是工作日还是周末？
//        Scanner sc=new Scanner(System.in);
//        int flag,input;
//        input=sc.nextInt();
//        flag=input>5?1:0;
//        if(flag==1) System.out.println("周末");
//        else System.out.println("工作日");

        //尝试调试
//        int moneyEachDay = 0;
//        int day = 10;
//        int sum=0;
//        for (int i = 1; i <= day; i++) {
//            if(0==moneyEachDay)
//                moneyEachDay = 1;
//            else
//                moneyEachDay *= 2;
//
//            sum+=moneyEachDay;
//
//            System.out.println(i + " 天之后，洪帮主手中的钱总数是: " + sum );
//        }

        //寻找某两个数相除，其结果 离黄金分割点 0.618最近
        //分母和分子不能同时为偶数
        //分母和分子 取值范围在[1-20]
//        int i,j;
//        int fenzi=1,fenmu=1;
//        double result=1;//保存相除产生的结果
//        double fianlres=1;//保存最后满足条件的相除结果
//        double cha;//保存result和0.618相差多少
//        double diff=1;//和cha功能类似
//        String answer="%d/%d=%f";  //double用%f就可以
//        for(i=1;i<=20;i++){
//            for(j=i+1;j<=20;j++){
//                if(i%2==0&&j%2==0) continue;
//                result=(double)i/j;
//                cha=Math.abs(result-0.618);
//                if(cha<diff){
//                    fenzi=i;fenmu=j;
//                    diff=cha;
//                    fianlres=result;
//                }
//            }
//        }
//        System.out.println("答案："+String.format(answer,fenzi,fenmu,fianlres));

        //水仙花数定义：
        //1. 一定是3位数
        //2. 每一位的立方，加起来恰好是这个数本身，比如153=1*1*1+5*5*5+3*3*3
        //寻找所有的水仙花数
//        int i,j,k;
//        int n,temp;
//        for(n=100;n<1000;n++){
//            i=n%10;
//            k=n/100;
//            j=(n/10)%10;
//            temp=(int)(Math.pow(i,3)+Math.pow(j,3)+Math.pow(k,3));
//            if(n==temp) System.out.println(n);
//        }

    }
}
