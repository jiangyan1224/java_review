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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    //做法1 递归，思想类似于DFS
//    public int pathSum(TreeNode root, int sum){
//        if (root==null) return 0;
//        //从根节点开始的路径
//        return help(root,sum)
//                //左子树中的路径
//                +pathSum(root.left,sum)
//                //右子树的路径
//                +pathSum(root.right,sum);
//        //以下这个是错误的，只有从根节点开始的 左节点开始的和右节点开始的，没有包含更下面节点起始的路径
//        //return help(root,sum)+help(root.left,sum)+help(root.right,sum);
//    }
//    //help返回从传入节点root开始的路径，有哪些路径和能有sum
//    private int help(TreeNode root,int sum){
//        if (root==null) return 0;
//        int isMe=(root.val==sum)?1:0;
//        int leftpath=help(root.left,sum-root.val);
//        int rightpath=help(root.right,sum-root.val);
//        return isMe+leftpath+rightpath;
//    }

    //做法2 Hash Map
    //这里的static没有问题，运行也没错，但是leetcode上因为所有的测试用例是一次全部运行的，static变量会随着用例不断增加，报错
    private static int count=0;
    public int pathSum(TreeNode root, int sum){
        if (root==null) return 0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        help(root,sum,0,map);
        return count;//count=3
    }
    //这里map形参要写好<Integer,Integer>，不然对map的操作会报错
    private void help(TreeNode root,int target,int currsum,HashMap<Integer,Integer> map){
        if (root==null) return;
        currsum+=root.val;
        //要先对路径count判断，再把currsum存入map,否则当sum=0会有误判
        //而且不是count++,而是count+=map.get(currsum-target)，因为(currsum-target)的value可能已经减为0了
        if (map.containsKey(currsum-target)) count+=map.get(currsum-target);

        if (!map.containsKey(currsum)) map.put(currsum,1);
        else map.put(currsum,map.get(currsum)+1);

        help(root.left,target,currsum,map);
        help(root.right,target,currsum,map);

        //如果当前root的左右子树都已经遍历完了，就要把map中对应value-1，减掉当前root的路径，避免后面其他节点也算出相同路径时，把这个root再算进去了
        map.put(currsum,map.get(currsum)-1);

    }
}

class MainClass {
    public static TreeNode stringToTreeNode(String input) {
        //[10,5,-3,3,2,null,11,3,-2,null,1]
        //trim去掉首尾空格
        input = input.trim();
        //substring左闭右开
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }
//        10,5,-3,3,2,null,11,3,-2,null,1
//        System.out.println(input);

        String[] parts = input.split(",");
        String item = parts[0];
        //parseInt转为整数类型
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
//            trim去掉首尾空格
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        System.out.println("input lines:");
        while ((line = in.readLine()) != null) {
            //[10,5,-3,3,2,null,11,3,-2,null,1]
            System.out.println(line);
            TreeNode root = stringToTreeNode(line);
            //读取下一行的sum
            line = in.readLine();
            //转换为整数类型
            int sum = Integer.parseInt(line);

            int ret = new Solution().pathSum(root, sum);

            String out = String.valueOf(ret);
            System.out.print("answer:");
            System.out.print(out);
        }
    }
}
