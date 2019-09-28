package leetcode;

import javafx.scene.effect.SepiaTone;

import java.util.HashSet;
import java.util.Set;

//编写一个程序，找到两个单链表相交的起始节点。
public class Intersection_of_Two_Linked_Lists {
    //我的解法：先求出两个链表的长度差，再用指针对长链表遍历，直到剩下的部分一样长，再两个指针一起遍历直到指向相同节点
    //时间复杂度O(m+n)空间复杂度O(1)
//    public int getlen1(ListNode head){
//        ListNode p=head;
//        int n=0;
//        while (p!=null){
//            n++;p=p.next;
//        }
//        return n;
//    }
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        int len1=getlen1(headA),len2=getlen1(headB);
//        int diff;
//        ListNode max=null,min=null;
//        diff=len2-len1;
//        max=headB;
//        min=headA;
//        if(len1>=len2){
//            diff=len1-len2;
//            max=headA;
//            min=headB;
//        }
//        for (;diff>0;max=max.next,diff--);
//        for (;max!=min;max=max.next,min=min.next);
//        return max;
//    }
    //高赞答案：用hashset存储某一个链表全部节点，再遍历另一条链表，依次加入set,如果加入不成功，说明这个节点重复了
    //时间复杂度O(m+n)空间复杂度O(m)或者O(n)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        Set<ListNode> set=new HashSet<>();
        ListNode p=headA;
        while (p!=null){
            set.add(p);p=p.next;
        }
        set.add(p);
        p=headB;
        while (p!=null){
            if(!set.add(p)) break;
            p=p.next;
        }
        return p;
    }
}
