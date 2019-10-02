package contests;

import java.util.*;

//给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
//你可以 任意多次交换 在 pairs 中任意一对索引处的字符。返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
//        输入：s = "dcab", pairs = [[0,3],[1,2]]
//        输出："bacd"
//        解释：
//        交换 s[0] 和 s[3], s = "bcad"
//        交换 s[1] 和 s[2], s = "bacd"
//
//        示例 2：
//        输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
//        输出："abcd"
//        解释：
//        交换 s[0] 和 s[3], s = "bcad"
//        交换 s[0] 和 s[2], s = "acbd"
//        交换 s[1] 和 s[2], s = "abcd"
//
//        示例 3：
//        输入：s = "cba", pairs = [[0,1],[1,2]]
//        输出："abc"
//        解释：
//        交换 s[0] 和 s[1], s = "bca"
//        交换 s[1] 和 s[2], s = "bac"
//        交换 s[0] 和 s[1], s = "abc"
//提示：
//
//        1 <= s.length <= 10^5
//        0 <= pairs.length <= 10^5
//        0 <= pairs[i][0], pairs[i][1] < s.length
//        s 中只含有小写英文字母
public class Smallest_String_With_Swaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int N=s.length();
        UnionFind uf=new UnionFind(N);
        //遍历所有list，把size和par表格填一遍
        for (List<Integer> swap:
             pairs) {
            uf.union(swap.get(0),swap.get(1));
        }
        //用hashmap把不同的树，对应的树根和所有树节点存到键值对中
        Map<Integer,List<Character>> map=new HashMap<>();
        for (int i = 0; i <N ; i++) {
            int head=uf.find(i);
            //dummy可以理解为虚拟，https://www.1point3acres.com/bbs/thread-135566-1-1.html
            //computeIfAbsent：如果key不存在或为空，执行后面的函数返回对象，
            // 并以这个函数第一个参数为key，后面那个为value作键值对存入map
            // https://www.cnblogs.com/inspirationBoom/p/9994932.html
            List<Character> characters=map.computeIfAbsent(head,(dummy)->new ArrayList<>());
            characters.add(s.charAt(i));
        }
        //把每棵树的节点进行排序，实现每棵树内部有序
        for (List<Character> characters:
             map.values()) {
            Collections.sort(characters);
        }
        //按下标从0到N-1，每个下标找到对应树，存入当前最小元素
        //StringBuilder方便字符串的连接、特定位置的替换 删除 插入字符/字符串
        StringBuilder sb=new StringBuilder(N);
        for (int i = 0; i <N ; i++) {
            //找到这个下标对应元素的树
            List<Character> characters=map.get(uf.find(i));
            //取出第一个元素给currentMin
            char currentMin=characters.remove(0);
            sb.append(currentMin);
        }
        return sb.toString();
    }
}
