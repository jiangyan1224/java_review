package leetcode.tree;
//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//        For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
//        1
//        / \
//        2   2
//        / \ / \
//        3  4 4  3
//
//        But the following [1,2,2,null,3,null,3] is not:
//        1
//        / \
//        2   2
//        \   \
//        3    3

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Symmetric_Tree {
    //高赞答案1：迭代法：设n为树的节点数；时间复杂度O(n) 空间复杂度O(n)
//    public boolean isSymmetric(TreeNode root) {
//        return isMirror(root,root);
//    }
//    public boolean isMirror(TreeNode t1,TreeNode t2){
//        //这里对t1 t2为不为空 几个为空的判断方法要注意一下
//        if(t1==null&&t2==null) return true;
//        if(t1==null||t2==null) return false;
//        if(t1.val!=t2.val) return false;
//        return isMirror(t1.left,t2.right)&&isMirror(t1.right,t2.left);
//    }

    //高赞答案2：用队列实现，类似于bst
    //时间复杂度O(n) 空间复杂度O(n)
    public boolean isSymmetric(TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()){
            TreeNode t1=q.poll();
            TreeNode t2=q.poll();
            if(t1==null&&t2==null) continue;
            if(t1==null||t2==null) return false;
            if(t1.val!=t2.val) return false;
            q.add(t1.left);q.add(t2.right);
            q.add(t1.right);q.add(t2.left);
        }
        return true;
    }
}
