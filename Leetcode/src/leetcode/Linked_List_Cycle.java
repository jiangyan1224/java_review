package leetcode;
//Given a linked list, determine if it has a cycle in it.
//        To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
//
//        Example 1:
//        Input: head = [3,2,0,-4], pos = 1
//        Output: true
//        Explanation: There is a cycle in the linked list, where tail connects to the second node.
//
//        Example 2:
//        Input: head = [1,2], pos = 0
//        Output: true
//        Explanation: There is a cycle in the linked list, where tail connects to the first node.
//
//        Example 3:
//        Input: head = [1], pos = -1
//        Output: false
//        Explanation: There is no cycle in the linked list.

import java.util.HashMap;

public class Linked_List_Cycle {
    //我自己的解法1：遍历链表，并用hashMap存储节点，遍历到某一个节点时，判断它的下一个节点是否已经存到了hashMap里面，
    // 如果已经有了，说明这个“下一个节点”就是题目所给的pos的位置，即该链表有环
    //时间复杂度O(n)空间复杂度O(n)
//    public boolean hasCycle(ListNode head) {
//        //这里head==null要放在前面判断，不然如果是空链表，就会报空指针异常，NullPointerException
//        if (head==null||head.next==null) return false;
//        HashMap<ListNode,Integer> map=new HashMap<>();
//        int pos=0,flag=0;
//        ListNode node=head;
//        map.put(node,pos);
//        //如果能遍历到null地址，说明一定没有环
//        while (node.next!=null){
//            if (map.containsKey(node.next)){flag=1;break;}
//            else {
//                pos++;
//                node=node.next;
//                map.put(node,pos);
//            }
//        }
//        if (flag==1) return true;
//        return false;
//    }
    //高赞答案1：通过p q两个指针，初始化都指向头节点，之后每次p走一步，q走两步，pq之间距离拉大，
    //然后q跑到p的后面（靠头节点方向为后），qp距离逐渐缩小，直到qp再次相遇
    //但是如果有环，q会先到null，不会出现上述情况
    //空间复杂度为O(1)时间复杂度取决于链表中环的大小，环最大为n，所以时间复杂度为O(n)
    public boolean hasCycle(ListNode head){
        if (head==null||head.next==null) return false;
        ListNode p=head,q=head;
        //如果无环，q为空或者q指向最后一个节点就结束循环，这一点取决于链表长度为奇数还是偶数
        while (q!=null&&q.next!=null){
            p=p.next;
            q=q.next.next;
            if (p==q) break;
        }
        //跳出循环，要么是因为没有环，qp指向相同节点，要么是因为无环，q为空或者q指向最后一个节点
        if (q==null||q.next==null) return false;
        return true;
    }
}
