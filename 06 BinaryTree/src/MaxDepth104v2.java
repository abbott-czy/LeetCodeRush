import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth104v2 {
    //给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例： 给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最大深度 3 。
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1421 👎 0


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
        public int maxDepth(TreeNode root) {
            return  getDepth(root);
        }

        public int getDepth(TreeNode root){
            if (root == null)
                return 0;
            int left = getDepth(root.left);
            int right = getDepth(root.right);
            int depth = 1 + max(left,right);
            return depth;
        }

        public int max(int left, int right){
            return left > right ? left : right;
        }
    }

}
