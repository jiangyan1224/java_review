package leetcode.tree;
//给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
// 二叉搜索树保证具有唯一的值。
//        示例 1：
//        输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
//        输出：32
//
//        示例 2：
//        输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
//        输出：23
//         
//        提示：
//        树中的结点数量最多为 10000 个。
//        最终的答案保证小于 2^31。

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Range_Sum_of_BST {
    //做法1 用队列，层次遍历，类似于BST
//    public int rangeSumBST(TreeNode root, int L, int R) {
//        int sum=0;
//        if(root==null) return sum;
//        Queue<TreeNode> q=new LinkedList<>();
//        q.add(root);
//        // sum+=root.val;
//        while(!q.isEmpty()){
//            TreeNode temp=q.remove();
//            if(temp.val>=L&&temp.val<=R)
//                sum+=temp.val;
//            if(temp.left!=null) q.add(temp.left);
//            if(temp.right!=null) q.add(temp.right);
//        }
//        return sum;
//    }

    //做法2 用栈，先序遍历，类似于DST
    public int rangeSumBST(TreeNode root, int L, int R){
        int sum=0;
        if(root==null) return sum;
        Stack<TreeNode> s=new Stack<>();
        s.push(root);
        while(!s.empty()){
            TreeNode temp=s.pop();
            if(temp.val>=L&&temp.val<=R)
                sum+=temp.val;
            if(temp.right!=null) s.push(temp.right);
            if(temp.left!=null) s.push(temp.left);

        }
        return sum;
    }

}
