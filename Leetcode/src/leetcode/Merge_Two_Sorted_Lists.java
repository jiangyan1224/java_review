package leetcode;
//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
//        示例：
//
//        输入：1->2->4, 1->3->4
//        输出：1->1->2->3->4->4
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
//自己的做法：用p指针从头到尾遍历l1和l2，依次连接到l上，空间复杂度O(1) 时间复杂度O(m+n)
//但是这样做代码冗余多，重复的部分多，不简洁
public class Merge_Two_Sorted_Lists {
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode l=null,p;
//        p=l;
//        while (l1!=null&&l2!=null){
//            if(l1.val<l2.val){
//                if(l==null) {l=l1;p=l;}
//                else {p.next=l1; p=p.next;}
//                l1=l1.next;
//            }else{
//                if(l==null) {l=l2; p=l;}
//                else {p.next=l2; p=p.next;}
//                l2=l2.next;
//            }
//        }
//        //这里要做一次判断，是因为有可能l1 l2中有一个为空，导致p为空也就不存在p.next，会报NullPointerException
//        if(l==null) l=l1==null?l2:l1;
//        else{
//            if (l1!=null) p.next=l1;
//            if (l2!=null) p.next=l2;
//        }
//        return l;
//    }

    //高赞答案1；递归：递归地定义在两个链表间的merge操作：
    //l1.next=merge(l1.1,l2);或者l2.next=merge(l1,l2.1)
    //代码更加简洁，时间复杂度O(m+n)空间复杂度：因为要遍历m+n个链表节点，需要m+n个栈帧存储，所以空间复杂度为O(m+n)
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
//      if (l1==null) return l2;
//      else if (l2==null) return l1;
//      else if (l1.val<l2.val){
//          l1.next=mergeTwoLists(l1.next,l2);
//          return l1;
//      }
//      else {
//          l2.next=mergeTwoLists(l1,l2.next);
//          return l2;
//      }
//    }

    //高赞答案2：迭代
    //其实思路和我自己的做法类似，依次遍历两个链表，但是答案中，设置了一个类似头节点，后续链表的操作更简单，省去了一些判断操作
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode pre=new ListNode(-1);
        ListNode prev=pre;
        while (l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                prev.next=l1;l1=l1.next;
            }else{
                prev.next=l2;l2=l2.next;
            }
            prev=prev.next;
        }
        prev.next=l1==null?l2:l1;
        return pre.next;
    }
}
