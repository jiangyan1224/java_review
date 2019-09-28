package leetcode;

import java.util.Stack;

//设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
//        push(x) -- 将元素 x 推入栈中。
//        pop() -- 删除栈顶的元素。
//        top() -- 获取栈顶元素。
//        getMin() -- 检索栈中的最小元素。
//MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        minStack.getMin();   --> 返回 -3.
//        minStack.pop();
//        minStack.top();      --> 返回 0.
//        minStack.getMin();   --> 返回 -2.
public class Min_Stack {
    Stack<Integer> stack=new Stack<Integer>();
    int min=Integer.MAX_VALUE;
    public Min_Stack(){
    }
    public void push(int x) {
        if (x<=min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop()==min){
            //如果出栈操作改变了min值,要记得更改min值
            min=stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
