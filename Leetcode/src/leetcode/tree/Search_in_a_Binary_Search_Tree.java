package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

//给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
//例如，
//        给定二叉搜索树:
//
//        4
//        / \
//        2   7
//        / \
//        1   3
//        和值: 2
//
//        你应该返回如下子树:
//
//        2
//        / \
//        1   3
//        在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
public class Search_in_a_Binary_Search_Tree {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return null;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp=q.remove();
            if(temp.val==val) return temp;
            else if(temp.val>val){
                if(temp.left!=null) q.add(temp.left);
            }
            else{
                if(temp.right!=null) q.add(temp.right);
            }
        }
        return null;
    }
}
