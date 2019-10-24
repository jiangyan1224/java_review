package contests;

import javax.management.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
//假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
//给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
//你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
//请返回待替换子串的最小可能长度。
//如果原字符串自身就是一个平衡字符串，则返回 0。
//        示例 1：
//        输入：s = "QWER"
//        输出：0
//        解释：s 已经是平衡的了。
//
//        示例 2：
//        输入：s = "QQWE"
//        输出：1
//        解释：我们需要把一个 'Q' 替换成 'R'，这样得到的 "RQWE" (或 "QRWE") 是平衡的。
//
//        示例 3：
//        输入：s = "QQQW"
//        输出：2
//        解释：我们可以把前面的 "QQ" 替换成 "ER"。
//
//        示例 4：
//        输入：s = "QQQQ"
//        输出：3
//        解释：我们可以替换后 3 个 'Q'，使 s = "QWER"。
//         
//        提示：
//        1 <= s.length <= 10^5
//        s.length 是 4 的倍数
//        s 中只含有 'Q', 'W', 'E', 'R' 四种字符
public class replace_the_substring_for_balanced_string {
//    public int balancedString(String s) {
//        int n=s.length();
//        int len1=n/4;
//        int len=0;
//        // System.out.println(len1);
//        int Q[]=new int[n];int W[] =new int[n];int E[]=new int[n];int R[]=new int[n];
//        System.out.println(s);
//        System.out.println(s.charAt(0));
//        switch(s.charAt(0)){
//            case 'Q':Q[0]=1;break;
//            case 'W':W[0]=1;break;
//            case 'E':E[0]=1;break;
//            default:R[0]=1;break;
//        }
//        for(int i=1;i<n;i++){
//            char ch=s.charAt(i);
//            Q[i]=(ch=='Q')?Q[i-1]+1:Q[i-1];
//            W[i]=(ch=='W')?W[i-1]+1:W[i-1];
//            E[i]=(ch=='E')?E[i-1]+1:E[i-1];
//            R[i]=(ch=='R')?R[i-1]+1:R[i-1];
//        }
//        // System.out.println(Arrays.toString());
//        int q=(Q[n-1]>len1)?Q[n-1]-len1:0;
//        int r=(R[n-1]>len1)?R[n-1]-len1:0;
//        int e=(E[n-1]>len1)?E[n-1]-len1:0;
//        int w=(W[n-1]>len1)?W[n-1]-len1:0;
//        len=q+r+e+w;
//        // System.out.println(len);  len=4
//        if(len==0) return len;
//
//        len=5;
//        // for(;len<n;len++){
//        for( int i=1;i<=n-len;i++){
//            int j=i+len-1;
//            System.out.print("Q[j]-Q[i-1]  "); System.out.println(Q[j]-Q[i-1]);
//            System.out.print("W[j]-W[i-1]  "); System.out.println(W[j]-W[i-1]);
//            System.out.print("R[j]-R[i-1]  "); System.out.println(R[j]-R[i-1]);
//            System.out.print("E[j]-E[i-1]  "); System.out.println(E[j]-E[i-1]);
//            if((Q[j]-Q[i-1]>=q)&&(W[j]-W[i-1]>=w)&&(R[j]-R[i-1]>=r)&&(E[j]-E[i-1]>=e))
//                return len;
//        }
//        // }
//        return len;
//    }
    public int balancedString(String s) {
        int n=s.length();
        int len1=n/4;
        int len=0;
        //QRWE数组的值表示第s中第i个元素及之前一共有多少个QRWE字母
        int Q[]=new int[n+1];int W[] =new int[n+1];int E[]=new int[n+1];int R[]=new int[n+1];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            Q[i+1]=(ch=='Q')?Q[i]+1:Q[i];
            W[i+1]=(ch=='W')?W[i]+1:W[i];
            E[i+1]=(ch=='E')?E[i]+1:E[i];
            R[i+1]=(ch=='R')?R[i]+1:R[i];
        }

        int q=(Q[n]>len1)?Q[n]-len1:0;
        int r=(R[n]>len1)?R[n]-len1:0;
        int e=(E[n]>len1)?E[n]-len1:0;
        int w=(W[n]>len1)?W[n]-len1:0;
        len=q+r+e+w;
        if(len==0) return len;

        for(;len<n;len++){
            for( int i=1;i<=n+1-len;i++){
                int j=i+len-1;
                if((Q[j]-Q[i-1]>=q)&&(W[j]-W[i-1]>=w)&&(R[j]-R[i-1]>=r)&&(E[j]-E[i-1]>=e))
                    return len;
            }
        }
        return len;
    }
}
class MainClass {
    private static Query Json;

    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return Json.value(input).toString();
    }

    public static void main(String[] args) throws IOException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(line);//不带引号
//            System.out.println(line.toString());//不带引号
            String s = stringToString(line);//带引号
            System.out.println(s);

            int ret = new replace_the_substring_for_balanced_string().balancedString(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
