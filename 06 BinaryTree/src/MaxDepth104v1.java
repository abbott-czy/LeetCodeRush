import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth104v1 {
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
            int deep = 0;
            if (root == null)
                return deep;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            TreeNode curNode;
            int size;
            while (!queue.isEmpty()){
                deep +=1;
                size = queue.size();
                while (size>0){
                    curNode =queue.poll();
                    if (curNode.left != null)
                        queue.add(curNode.left);
                    if (curNode.right != null)
                        queue.add(curNode.right);
                    size--;
                }
            }
            return deep;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
