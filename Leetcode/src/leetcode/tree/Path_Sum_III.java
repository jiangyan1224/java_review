package leetcode.tree;
//给定一个二叉树，它的每个结点都存放着一个整数值。
//        找出路径和等于给定数值的路径总数。
//        路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
//        二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
//
//        示例：
//        root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//        10
//        /  \
//        5   -3
//        / \    \
//        3   2   11
//        / \   \
//        3  -2   1
//
//        返回 3。和等于 8 的路径有:
//        1.  5 -> 3
//        2.  5 -> 2 -> 1
//        3.  -3 -> 11
/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private int count=0;
    public int pathSum(TreeNode root, int sum){
        if(root==null) return 0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        help(root,0,sum,map);
        return count;
    }
    private void help(TreeNode root, int currSum, int target, HashMap<Integer, Integer> map){
        if(root==null) return;
        currSum+=root.val;
        if(map.containsKey(currSum-target)){
            count+=map.get(currSum-target);
        }
        if(!map.containsKey(currSum)){
            map.put(currSum,1);
        }
        else{
            map.put(currSum,map.get(currSum)+1);
        }
        help(root.left,currSum,target,map);
        help(root.right,currSum,target,map);
        //在某个节点及以下遍历完之后，要把该节点currSum对应路径数-1，
        map.put(currSum,map.get(currSum)-1);
    }
}

//class MainClass {
//    public static TreeNode stringToTreeNode(String input) {
//        //[10,5,-3,3,2,null,11,3,-2,null,1]
//        //trim去掉首尾空格
//        input = input.trim();
//        //substring左闭右开
//        input = input.substring(1, input.length() - 1);
//        if (input.length() == 0) {
//            return null;
//        }
////        10,5,-3,3,2,null,11,3,-2,null,1
////        System.out.println(input);
//
//        String[] parts = input.split(",");
//        String item = parts[0];
//        //parseInt转为整数类型
//        TreeNode root = new TreeNode(Integer.parseInt(item));
//        Queue<TreeNode> nodeQueue = new LinkedList<>();
//        nodeQueue.add(root);
//
//        int index = 1;
//        while(!nodeQueue.isEmpty()) {
//            TreeNode node = nodeQueue.remove();
//
//            if (index == parts.length) {
//                break;
//            }
//
//            item = parts[index++];
////            trim去掉首尾空格
//            item = item.trim();
//            if (!item.equals("null")) {
//                int leftNumber = Integer.parseInt(item);
//                node.left = new TreeNode(leftNumber);
//                nodeQueue.add(node.left);
//            }
//
//            if (index == parts.length) {
//                break;
//            }
//
//            item = parts[index++];
//            item = item.trim();
//            if (!item.equals("null")) {
//                int rightNumber = Integer.parseInt(item);
//                node.right = new TreeNode(rightNumber);
//                nodeQueue.add(node.right);
//            }
//        }
//        return root;
//    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        System.out.println("input lines:");
//        while ((line = in.readLine()) != null) {
//            //[10,5,-3,3,2,null,11,3,-2,null,1]
//            System.out.println(line);
//            TreeNode root = stringToTreeNode(line);
//            //读取下一行的sum
//            line = in.readLine();
//            //转换为整数类型
//            int sum = Integer.parseInt(line);
//
//            int ret = new Solution().pathSum(root, sum);
//
//            String out = String.valueOf(ret);
//            System.out.print("answer:");
//            System.out.print(out);
//        }
//    }
//}
