package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
//Given an n-ary tree, return the preorder traversal of its nodes' values.
//
//        For example, given a 3-ary tree:
//
//        Return its preorder traversal as: [1,3,5,6,2,4].
//
//
//
//        Note:
//
//        Recursive solution is trivial, could you do it iteratively?
public class N_ary_Tree_Preorder_Traversal {
    //stack先序遍历
    // public List<Integer> preorder(Node root) {
    //     List<Integer> list=new ArrayList<>();
    //     if(root==null) return list;
    //     Stack<Node> s=new Stack<>();
    //     s.push(root);
    //     while(!s.empty()){
    //         Node temp=s.pop();
    //         list.add(temp.val);
    //         if(temp.children!=null){
    //             for(int i=temp.children.size()-1;i>=0;i--) s.push(temp.children.get(i));
    //         }
    //     }
    //     return list;
    // }
    //还可以递归
     public List<Integer> preorder(Node root){
         List<Integer> list=new ArrayList<>();
         prelist(root,list);
         return list;
     }
     private void prelist(Node root,List<Integer> list){
         if(root==null) return;
         list.add(root.val);
         for(Node node:root.children) prelist(node,list);
     }
}
