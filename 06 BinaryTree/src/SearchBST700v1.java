import java.util.LinkedList;
import java.util.Queue;

public class SearchBST700v1 {
    //给定二叉搜索树（BST）的根节点
// root 和一个整数值
// val。
//
// 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回
// null 。
//
//
//
// 示例 1:
//
//
//
//
//
//输入：root = [4,2,7,1,3], val = 2
//输出：[2,1,3]
//
//
// 示例 2:
//
//
//输入：root = [4,2,7,1,3], val = 5
//输出：[]
//
//
//
//
// 提示：
//
//
// 数中节点数在 [1, 5000] 范围内
// 1 <= Node.val <= 10⁷
// root 是二叉搜索树
// 1 <= val <= 10⁷
//
//
// Related Topics 树 二叉搜索树 二叉树 👍 336 👎 0


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
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null)
                return null;
            Queue<TreeNode> queue =  new LinkedList<>();
            int size;
            TreeNode currentNode;
            queue.add(root);
            while (!queue.isEmpty()){
                size = queue.size();
                while (size-- > 0){
                    currentNode = queue.poll();
                    if (currentNode.val == val)
                        return currentNode;

                    if (currentNode.left != null) queue.add(currentNode.left);
                    if (currentNode.right != null) queue.add(currentNode.right);
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
