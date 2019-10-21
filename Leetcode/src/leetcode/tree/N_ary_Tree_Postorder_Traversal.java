package leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//Given an n-ary tree, return the postorder traversal of its nodes' values.
//
//        For example, given a 3-ary tree:
//
//        Return its postorder traversal as: [5,6,3,2,4,1].
//
//        Note:
//        Recursive solution is trivial, could you do it iteratively?
public class N_ary_Tree_Postorder_Traversal {
    //递归
    // public List<Integer> postorder(Node root) {
    //     List<Integer> list=new ArrayList<>();
    //     postlist(root,list);
    //     return list;
    // }
    // private void postlist(Node root,List<Integer> list){
    //     if(root==null) return;
    //     for(Node node:root.children) postlist(node,list);
    //     list.add(root.val);
    // }
    //迭代
    //先用栈实现类似于先序遍历（其中左右子节点入栈顺序不一样），依次把出栈节点入list，最后反转list
//    public List<Integer> postorder(Node root){
//        Stack<Node> stack=new Stack<>();
//        List<Integer> list=new ArrayList<>();
//        if(root==null) return list;
//        stack.push(root);
//        while(!stack.empty()){
//            Node node=stack.pop();
//            list.add(node.val);
//            for(Node temp:node.children) stack.push(temp);
//        }
//        Collections.reverse(list);
//        return list;
//    }
}
