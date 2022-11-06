import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValues515v1 {

    //给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
//
//
//
// 示例1：
//
//
//
//
//输入: root = [1,3,2,5,3,null,9]
//输出: [1,3,9]
//
//
// 示例2：
//
//
//输入: root = [1,2,3]
//输出: [1,3]
//
//
//
//
// 提示：
//
//
// 二叉树的节点个数的范围是 [0,10⁴]
//
// -2³¹ <= Node.val <= 2³¹ - 1
//
//
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 284 👎 0


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
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            if (root == null)
                return res;

            TreeNode curNode;
            int size;
            int curMax;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                size = queue.size();
                curMax = queue.peek().val;
                while (size>0){
                    curNode = queue.poll();
                    if (curNode.val > curMax)
                        curMax = curNode.val;
                    if (curNode.left != null)
                        queue.add(curNode.left);
                    if (curNode.right != null)
                        queue.add(curNode.right);
                    size--;
                }
                res.add(curMax);

            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
