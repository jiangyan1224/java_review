package leetcode;
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

import java.util.Stack;

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
    public int maxDepth(TreeNode root){
        if(root==null) return 0;
        //ds记录当前遍历的节点
        Stack<TreeNode> ds=new Stack<>();
        //ns记录ds对应层的节点深度
        Stack<Integer> ns=new Stack<>();
        ds.push(root);ns.push(1);
        int max=1,depth;
        while(!ds.empty()){
            depth=ns.pop();
            TreeNode t=ds.pop();
            max=Math.max(max,depth);
            if(t.left!=null){
                ds.push(t.left);
                ns.push(1+depth);
            }
            if(t.right!=null){
                ds.push(t.right);
                ns.push(1+depth);
            }
        }
        return max;
    }
}
