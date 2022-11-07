import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxNtreeDepth559v2 {

    //给定一个 N 叉树，找到其最大深度。
//
// 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
//
// N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
//
//
//
// 示例 1：
//
//
//
//
//输入：root = [1,null,3,2,4,null,5,6]
//输出：3
//
//
// 示例 2：
//
//
//
//
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：5
//
//
//
//
// 提示：
//
//
// 树的深度不会超过 1000 。
// 树的节点数目位于 [0, 10⁴] 之间。
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 👍 319 👎 0

// v2 递归法
//    执行耗时:0 ms,击败了100.00% 的Java用户
//    内存消耗:41.4 MB,击败了76.39% 的Java用户
//leetcode submit region begin(Prohibit modification and deletion)

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


    class Solution {
        public int maxDepth(Node root) {
            return depth(root);
        }

        public int depth(Node root){
            if (root == null)
                return 0;
            int size = root.children.size();
            int[] res = new int[size];
            for (int i = 0; i < size; i++) {
                res[i] = depth(root.children.get(i));
            }

            int dept = 1 + max(res);
            return dept;
        }

        public  int max(int[] res){
            if (res.length == 0)
                return 0;
            int maxNum = res[0];
            for (int i = 0; i < res.length; i++) {
                if (res[i] > maxNum)
                    maxNum = res[i];
            }
            return maxNum;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
