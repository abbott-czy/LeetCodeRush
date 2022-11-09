import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftValue513v1 {

    //给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
//
// 假设二叉树中至少有一个节点。
//
//
//
// 示例 1:
//
//
//
//
//输入: root = [2,1,3]
//输出: 1
//
//
// 示例 2:
//
//
//
//
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
//
//
//
//
// 提示:
//
//
// 二叉树的节点个数的范围是 [1,10⁴]
//
// -2³¹ <= Node.val <= 2³¹ - 1
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 399 👎 0


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
        public int findBottomLeftValue(TreeNode root) {
            if (root == null)
                return 0;
            Queue<TreeNode> queue = new LinkedList<>();
            int size;
            int res=0;
            TreeNode curNode;
            queue.add(root);
            while (!queue.isEmpty()){
                size = queue.size();
                res = queue.peek().val;
                while (size-- > 0){
                    curNode = queue.poll();
                    if (curNode.left != null)  queue.add(curNode.left);
                    if (curNode.right != null) queue.add(curNode.right);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
