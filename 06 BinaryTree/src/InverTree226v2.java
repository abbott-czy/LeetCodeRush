import java.util.LinkedList;
import java.util.Queue;

public class InverTree226v2 {

    //给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
//
//
//
// 示例 1：
//
//
//
//
//输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
//
//
// 示例 2：
//
//
//
//
//输入：root = [2,1,3]
//输出：[2,3,1]
//
//
// 示例 3：
//
//
//输入：root = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 树中节点数目范围在 [0, 100] 内
// -100 <= Node.val <= 100
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1380 👎 0


//leetcode submit region begin(Prohibit modification and deletion)



/*
迭代法，队列
 */

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
        public TreeNode invertTree(TreeNode root) {
            if (root == null)
                return root;

            Queue<TreeNode> queue = new LinkedList<>();
            int size;
            TreeNode curNode;
            queue.add(root);
            while (!queue.isEmpty()){
                size = queue.size();
                while (size-- > 0){
                    curNode = queue.poll();
                    swap(curNode);
                    if (curNode.left != null)
                        queue.add(curNode.left);
                    if (curNode.right != null)
                        queue.add(curNode.right);

                }
            }
            return root;
        }

        public void swap(TreeNode root){
            TreeNode tem = root.left;
            root.left = root.right;
            root.right = tem;
        }



    }
//leetcode submit region end(Prohibit modification and deletion)

}
