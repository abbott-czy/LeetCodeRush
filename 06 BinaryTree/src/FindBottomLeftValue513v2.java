import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftValue513v2 {

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
    private int  Deep = -1;
    private int value = 0;

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
            value = root.val;
            findLeftVale(root,0);
            return value;
        }

        public void findLeftVale(TreeNode root, int deep){
            if (root == null) return;
            if (root.left == null && root.right == null){
                if (deep > Deep){
                    value = root.val;
                    Deep = deep;
                }
            }
            if (root.left != null) findLeftVale(root.left,deep + 1);
            if (root.right != null) findLeftVale(root.right,deep + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
