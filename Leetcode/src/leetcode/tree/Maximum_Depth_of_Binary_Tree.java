package leetcode.tree;
//Given a binary tree, find its maximum depth.
//        The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//        Note: A leaf is a node with no children.
//
//        Example:
//        Given binary tree [3,9,20,null,null,15,7],
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        return its depth = 3.

import java.util.LinkedList;
import java.util.Queue;

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}
public class Maximum_Depth_of_Binary_Tree {
    //高赞答案1：迭代法：时间复杂度O(n)空间复杂度O(n)
//    public int maxDepth(TreeNode root) {
//        if (root==null) return 0;
//        int ldepth=1+maxDepth(root.left);
//        int rdepth=1+maxDepth(root.right);
//        return ldepth>=rdepth?ldepth:rdepth;
//    }
    //高赞答案2：两个栈实现，类似于dst
    //时间复杂度O(n)空间复杂度O(n)
//    public int maxDepth(TreeNode root){
//        if(root==null) return 0;
//        //ds记录当前遍历的节点
//        Stack<TreeNode> ds=new Stack<>();
//        //ns记录ds对应层的节点深度
//        Stack<Integer> ns=new Stack<>();
//        ds.push(root);ns.push(1);
//        int max=1,depth;
//        while(!ds.empty()){
//            depth=ns.pop();
//            TreeNode t=ds.pop();
//            max=Math.max(max,depth);
//            if(t.left!=null){
//                ds.push(t.left);
//                ns.push(1+depth);
//            }
//            if(t.right!=null){
//                ds.push(t.right);
//                ns.push(1+depth);
//            }
//        }
//        return max;
//    }
    //刘永志的解法：用队列层次遍历：
    public int maxDepth(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null) return 0;
        //depth记录当前结点深度，old记录当前层还未遍历的节点个数，neww记录下一层的子节点数
        int depth=0,old=1,neww=0;
        q.add(root);
        while (!q.isEmpty()){
            TreeNode t=q.remove();
            old--;
            if (t.left!=null){neww++;q.add(t.left);}
            if (t.right!=null){neww++;q.add(t.right);}
            //当old减为0，说明当前层已经遍历完毕
            if (old==0) {old=neww;neww=0;depth++;}
        }
        return depth;
    }
}
