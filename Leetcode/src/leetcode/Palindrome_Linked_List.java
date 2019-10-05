package leetcode;

import java.util.*;

//请判断一个链表是否为回文链表。
//        示例 1:
//        输入: 1->2
//        输出: false
//
//        示例 2:
//        输入: 1->2->2->1
//        输出: true
//        进阶：
//        你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
public class Palindrome_Linked_List {
    //我自己的解法：遍历链表，标志后半部分的开头，用栈保存前半部分链表
    //将前后部分比较遍历，如果有值不相同的，说明不是回文
    //时间复杂度O(n) 空间复杂度O(n),遍历了三遍链表
//    public boolean isPalindrome(ListNode head) {
//        if (head==null||head.next==null) return true;
//        ListNode front=head,back=head;
//        //n记录链表长度
//        int n=1,half;
//        for (ListNode p=head;p.next!=null;p=p.next,n++);
//        //back标志链表后半部分
//        half=(n+1)/2;
//        for (;half!=0;back=back.next,half--);
//
//        //栈保存链表的前半部分
//        half=n/2-1;
    //peek()如果栈为空，会直接报异常
//        Stack<ListNode> s=new Stack<>();
//        s.push(front);
//        while (half>0){
//            front=front.next;
//            s.push(front);
//            half--;
//        }
//        //将前半部分和后半部分相比较，这里可以保证栈的长度和后半部分长度相等
//        while (!s.isEmpty()){
//            if (s.pop().val!=back.val) return false;
//            back=back.next;
//        }
//        return true;
//
//    }
    //用java里面的动态数组，ArrayList
    //时间复杂度O(n) 空间复杂度O(n)
//    public boolean isPalindrome(ListNode head){
//        if (head==null||head.next==null) return true;
//        //ArrayList存储整个链表，方便反向遍历
//        List<Integer> list=new ArrayList<>();
//        ListNode p=head;
//        int i,j;//用于正向 反向遍历ArrayList
//        while (p!=null){
//            list.add(p.val);
//            p=p.next;
//        }
//        i=0;j=list.size()-1;
//        while (i<j){
//            //这里不能用！=判断是否相等，==要返回true，必须要求两个对象是同一个对象
//            //而equals方法要返回true，只要两个对象的内容相同即可，不一定是同一个对象
//            //get方法返回的是元素类型，这里也就是Integer对象
//            //给Integer赋值的时候，调用的是valueOf方法，如果这个值在-128~127，第一次创建新对象返回，第二次返回上一个对象的引用；
//            //如果不在这个范围，一律新建对象，返回新对象
//            if (!list.get(i).equals(list.get(j))) return false;
//            i++;j--;
//        }
//        return true;
//    }
    //时间复杂度O(n) 空间复杂度O(1)的方法：
    //用指针指到链表的后半部分首位，然后将后半部分反转，
    // 就可以分别从原链表的首位末尾，正向反向遍历
    public boolean isPalindrome(ListNode head){
        ListNode slow=head,fast=head;
        //当链表长度为 奇数，fast走了(n-1)/2次；偶数，fast走了n/2次，
        //循环结束，slow分别在正中间的那个；或者在后半部分的第一个
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        if (fast!=null) slow= slow.next;//当链表长度为奇数,保证slow在后半部分的第一个位置

        //后半链表反转
        slow=reverse(slow);
        fast=head;
        while (slow!=null){
            if (slow.val!=fast.val) return false;
            slow=slow.next;
            fast=fast.next;
        }
        return true;

    }
//    private ListNode reverse(ListNode head){
//        if (head==null||head.next==null) return head;
//        ListNode p=reverse(head.next);//最后(head.next).next==null，head.next是最后一个节点，但是返回的是(head.next)
//        //所以最后p指向最后一个节点，而head是倒数第二个节点
//        head.next.next=head;
//        head.next=null;
//        return p;
//    }
    private ListNode reverse(ListNode head){
        if (head==null||head.next==null) return head;
        ListNode curr=head,prev=null;
        while (curr!=null){
            ListNode nextTemp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextTemp;
        }
        return prev;
    }
}
