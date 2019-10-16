package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
//你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
//        示例 1:
//        输入:
//        Tree 1                     Tree 2
//        1                         2
//        / \                       / \
//        3   2                     1   3
//        /                           \   \
//        5                             4   7
//        输出:
//        合并后的树:
//        3
//        / \
//        4   5
//        / \   \
//        5   4   7
//        注意: 合并必须从两个树的根节点开始。
public class Merge_Two_Binary_Trees {
    //递归1
    // public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    //     if(t1==null&&t2==null) return null;
    //     int val=(t1==null?0:t1.val)+(t2==null?0:t2.val);
    //     TreeNode root=new TreeNode(val);
    //     root.left=mergeTrees((t1==null?null:t1.left),(t2==null?null:t2.left));
    //     root.right=mergeTrees((t1==null?null:t1.right),(t2==null?null:t2.right));
    //     return root;
    // }

    //递归2
    // public TreeNode mergeTrees(TreeNode t1, TreeNode t2){
    //     if(t1==null) return t2;
    //     if(t2!=null){
    //         t1.val+=t2.val;
    //         t1.left=mergeTrees(t1.left,t2.left);
    //         t1.right=mergeTrees(t1.right,t2.right);
    //     }
    //     return t1;
    // }
    //迭代 队列实现 BFS
     public TreeNode mergeTrees(TreeNode t1, TreeNode t2){
         if(t1==null) return t2;
         if(t2==null) return t1;
         Queue<TreeNode[]> queue=new LinkedList<>();
         //队列每次同时读入t1 t2的根元素/左孩子/右孩子，同时遍历两个树
         queue.offer(new TreeNode[]{t1,t2});
         while(!queue.isEmpty()){
             TreeNode[] nodes=queue.remove();
             if(nodes[1]==null) continue;
             //nodes[0]不会为空，如果nodes第一个元素为空，直接处理就不会放到队列中
             nodes[0].val+=nodes[1].val;

             if(nodes[0].left==null) nodes[0].left=nodes[1].left;
             else queue.offer(new TreeNode[]{nodes[0].left,nodes[1].left});

                 if(nodes[0].right==null) nodes[0].right=nodes[1].right;
             else queue.offer(new TreeNode[]{nodes[0].right,nodes[1].right});
         }
         return t1;
     }
    //迭代 栈实现 DFS
//    public TreeNode mergeTrees(TreeNode t1, TreeNode t2){
//        if(t1==null) return t2;
//        if(t2==null) return t1;
//        Stack<TreeNode[]> stack=new Stack<>();
//        stack.push(new TreeNode[]{t1,t2});
//        while(!stack.empty()){
//            TreeNode[] nodes=stack.pop();
//            if(nodes[1]==null) continue;
//            nodes[0].val+=nodes[1].val;
//
//            if(nodes[0].right==null) nodes[0].right=nodes[1].right;
//            else stack.push(new TreeNode[]{nodes[0].right,nodes[1].right});
//
//            if(nodes[0].left==null) nodes[0].left=nodes[1].left;
//            else stack.push(new TreeNode[]{nodes[0].left,nodes[1].left});
//        }
//        return t1;
//    }

}
