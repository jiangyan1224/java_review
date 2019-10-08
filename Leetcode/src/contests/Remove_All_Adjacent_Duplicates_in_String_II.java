package contests;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Deque;

//给你一个字符串 s，k 倍重复项删除操作,将会从 s 中选择 k 个相邻且相等的字母，并删除它们，
//使被删去的字符串的左侧和右侧连在一起。你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。
//在执行完所有删除操作后，返回最终得到的字符串。
//本题答案保证唯一。
//        示例 1：
//        输入：s = "abcd", k = 2
//        输出："abcd"
//        解释：没有要删除的内容。
//
//        示例 2：
//        输入：s = "deeedbbcccbdaa", k = 3
//        输出："aa"
//        解释：
//        先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
//        再删除 "bbb"，得到 "dddaa"
//        最后删除 "ddd"，得到 "aa"
//
//        示例 3：
//        输入：s = "pbbcggttciiippooaais", k = 2
//        输出："ps"
//
//        提示：
//        1 <= s.length <= 10^5
//        2 <= k <= 10^4
//        s 中只含有小写英文字母。
public class Remove_All_Adjacent_Duplicates_in_String_II {
//    public String removeDuplicates(String s, int k) {
//        //1两个指针：
//        int i = 0,j,n=s.length();
//        int[] count=new int[n];
//        char[] stack=s.toCharArray();
//        for (j=0;j<n;j++,i++){
//            stack[i]=stack[j];
//            count[i]=i>0&&stack[i]==stack[i-1]?count[i-1]+1:1;
//            if (count[i]==k) i-=k;
//        }
//        return new String(stack,0,i);
//    }

    public String removeDuplicates(String s, int k){
        //2栈解决
        Deque<Pair<Integer,Character>> stack=new ArrayDeque<>();
        stack.push(new Pair<>(0,'#'));
        for (char c:
             s.toCharArray()) {
            //assert [boolean 表达式]
            //如果[boolean表达式]为true，则程序继续执行。
            //如果为false，则程序抛出AssertionError，并终止执行。
            assert stack.peek() != null;
            if (c!=stack.peek().getValue()) stack.push(new Pair<>(1,c));
            else {
                int count=stack.pop().getKey()+1;
                if (count!=k) stack.push(new Pair<>(count,c));
            }
        }
        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty()){
            for (int i=0;i<stack.peek().getKey();i++){
                sb.append(stack.peek().getValue());
            }
            stack.pop();
        }
        return sb.reverse().toString();

    }
}
