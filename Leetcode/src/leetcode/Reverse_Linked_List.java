package leetcode;
//反转一个单链表。
//        示例:
//        输入: 1->2->3->4->5->NULL
//        输出: 5->4->3->2->1->NULL
//        进阶:
//        你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
public class Reverse_Linked_List {
    //递归：
//    时间复杂度：O(n)，假设 nn 是列表的长度，那么时间复杂度为 O(n)。
//    空间复杂度：O(n)，由于使用递归，将会使用隐式栈空间。递归深度可能会达到n层。
//    public ListNode reverseList(ListNode head){
//        if (head==null||head.next==null) return head;
//        ListNode p=reverseList(head.next);
//        head.next.next=head;
//        head.next=null;
//        return p;
//    }
    //迭代：
//    时间复杂度：O(n)，空间复杂度：O(1)。
    public ListNode reverseList(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        while (curr!=null){
            ListNode nextTemp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextTemp;
        }
        return prev;
    }
}
