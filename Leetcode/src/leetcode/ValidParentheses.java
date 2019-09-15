package leetcode;
import java.util.HashMap;
import java.util.Stack;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//        有效字符串需满足：
//
//        左括号必须用相同类型的右括号闭合。
//        左括号必须以正确的顺序闭合。
//        注意空字符串可被认为是有效字符串。
//
//        示例 2:
//        输入: "()[]{}"
//        输出: true
//
//        示例 3:
//        输入: "(]"
//        输出: false
public class ValidParentheses {
    //自己做的：用stack实现括号判断，左括号一律入栈，右括号进行判断，相符合则出栈，否则返回false；时间复杂度O(n),空间复杂度O(n)
    //但是因为题目说明字符串只有括号，所以可以一开始就判断字符串长度，为奇数则判false
    //stack的定义，string的charAt方法，stack的判空方法
    //数组长度用length属性；字符串长度用length()方法
//    public boolean isValid(String s) {
//        Stack<Character> stack=new Stack<>();
//        for(int i=0;i<s.length();i++){
//            char temp,ch=s.charAt(i);
//            switch (ch){
//                case '(':
//                case '[':
//                case '{':
//                    stack.push(ch);break;
//                case ')':
//                    temp=stack.pop();
//                    if(temp!='(') return false;
//                    break;
//                case ']':
//                    temp=stack.pop();
//                    if (temp!='[') return false;
//                    break;
//                case '}':
//                    temp=stack.pop();
//                    if(temp!='}') break;
//                    break;
//
//            }
//        }
//        if (stack.empty()) return true;
//        else return false;
//    }
    //高热答案：HashMap和栈：时间复杂度O(n)空间复杂度O(n)
    HashMap<Character,Character> hashMap=new HashMap<>();
    ValidParentheses(){
        //因为hashmap的get containsKey方法都是从key访问到value，且字符串访问到右括号的情况需要匹配，左括号直接入栈即可
        //所以key是右括号，value是左括号
        hashMap.put(')','(');
        hashMap.put(']','[');
        hashMap.put('}','{');
    }
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        //通过hashmap查询免掉了switch/if的判断语句繁琐
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            //这里的this最好加上，因为hashMap是类的对象属性，用对象调用
            if(this.hashMap.containsKey(ch)){
                //很重要！这里的topElement，是为了防止此时栈为空，直接执行pop方法会报EmptyStackException，比如字符串为“]”就会抛出异常
                char topElement=stack.empty()?'#':stack.pop();
                if(topElement!=this.hashMap.get(ch)) return false;
            }
            else stack.push(ch);
        }
        return stack.empty();
    }

}
