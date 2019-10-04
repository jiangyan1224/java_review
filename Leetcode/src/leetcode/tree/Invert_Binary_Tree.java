package leetcode.tree;

import java.util.Stack;

//翻转一棵二叉树。
//        示例：
//        输入：
//
//        4
//        /   \
//        2     7
//        / \   / \
//        1   3 6   9
//        输出：
//
//        4
//        /   \
//        7     2
//        / \   / \
//        9   6 3   1
public class Invert_Binary_Tree {
    //1 递归
//    public TreeNode invertTree(TreeNode root) {
//        if (root==null) return null;
//        TreeNode tleft=invertTree(root.left);
////        TreeNode tright=invertTree(root.right);
//        root.left= invertTree(root.right);
//        root.right=tleft;
//        return root;
//    }
    //2迭代，近似BFS
//    public TreeNode invertTree(TreeNode root){
//        if (root==null) return null;
//        Queue<TreeNode> q=new LinkedList<>();
//        q.add(root);
//        while (!q.isEmpty()){
//            TreeNode curr=q.remove();
//            TreeNode temp=curr.left;
//            curr.left=curr.right;
//            curr.right=temp;
//            if (curr.left!=null) q.add(curr.left);
//            if (curr.right!=null) q.add(curr.right);
//        }
//        return root;
//    }
    //3 和2类似，但是用栈实现
    public TreeNode invertTree(TreeNode root){
        if (root==null) return null;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.empty()){
            TreeNode curr=stack.pop();
            TreeNode temp=curr.left;
            curr.left=curr.right;
            curr.right=temp;
            if (curr.left!=null) stack.push(curr.left);
            if (curr.right!=null) stack.push(curr.right);
        }
        return root;
    }

}
