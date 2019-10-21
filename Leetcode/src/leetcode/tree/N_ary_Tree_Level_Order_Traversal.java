package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

//Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//        For example, given a 3-ary tree:
//
//        We should return its level order traversal:
//
//        [
//        [1],
//        [3,2,4],
//        [5,6]
//        ]
//
//        Note:
//        The depth of the tree is at most 1000.
//        The total number of nodes is at most 5000.
public class N_ary_Tree_Level_Order_Traversal {
    //迭代
    // public List<List<Integer>> levelOrder(Node root) {
    //     Queue<Node> q=new LinkedList<>();
    //     List<List<Integer>> outlist=new ArrayList<>();
    //     if(root==null) return outlist;
    //     q.add(root);
    //     int fu=1,zi;
    //     while(!q.isEmpty()){
    //         List<Integer> templist=new ArrayList<>();
    //         zi=0;
    //         while(fu>0){
    //             Node temp=q.remove();
    //             templist.add(temp.val);
    //             zi+=temp.children.size();
    //             for(Node node:temp.children) q.add(node);
    //             fu--;
    //         }
    //         fu=zi;
    //         outlist.add(templist);
    //     }
    //     return outlist;
    // }
    //迭代2 BFS
    // public List<List<Integer>> levelOrder(Node root){
    //     List<List<Integer>> outlist=new ArrayList<>();
    //     if(root==null) return outlist;
    //     Queue<Node> q=new LinkedList<>();
    //     q.add(root);
    //     while(!q.isEmpty()){
    //         List<Integer> templist=new ArrayList<>();
    //         int len=q.size();
    //         for(int i=0;i<len;i++){
    //             Node temp=q.remove();
    //             templist.add(temp.val);
    //             for(Node node:temp.children) q.add(node);
    //         }
    //         outlist.add(templist);
    //     }
    //    return outlist;
    // }
    //递归 DFS
    //如果想在递归里面依次访问某一层所有的兄弟节点时，可以用DFS实现，而不是一直考虑BFS
    public List<List<Integer>> levelOrder(Node root){
        List<List<Integer>> outlist=new ArrayList<>();
        levelOrder(root,0,outlist);
        return outlist;
    }
    private void levelOrder(Node node,int level,List<List<Integer>> outlist){
        if(node==null) return;
        List<Integer> templist= level>=outlist.size() ? new ArrayList<>():outlist.get(level);
        templist.add(node.val);
        if(level>=outlist.size()) outlist.add(templist);
        for(Node temp:node.children) levelOrder(temp,level+1,outlist);
    }
}
