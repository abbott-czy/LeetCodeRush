import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves404v1 {
    //给定二叉树的根节点 root ，返回所有左叶子之和。
//
//
//
// 示例 1：
//
//
//
//
//输入: root = [3,9,20,null,null,15,7]
//输出: 24
//解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
//
//
// 示例 2:
//
//
//输入: root = [1]
//输出: 0
//
//
//
//
// 提示:
//
//
// 节点数在 [1, 1000] 范围内
// -1000 <= Node.val <= 1000
//
//
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 521 👎 0


//leetcode submit region begin(Prohibit modification and deletion)



      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
             this.left = left;
              this.right = right;
          }
      }

    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            if ( root == null)
                return 0;
            if (root.left == null && root.right == null)
                return 0;
            Queue<TreeNode> queue = new LinkedList<>();
            int res = 0;
            int size;
            TreeNode curNode;
            queue.add(root);
            while (!queue.isEmpty()){
                size = queue.size();

                while (size-- > 0){
                    curNode = queue.poll();

                    if (curNode.left != null && curNode.left.left == null && curNode.left.right == null)
                        res += curNode.left.val;

                    if (curNode.left != null)
                        queue.add(curNode.left);
                    if (curNode.right != null)
                        queue.add(curNode.right);

                }
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
