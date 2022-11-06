import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder102v1 {

    //给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
//
//
// 示例 2：
//
//
//输入：root = [1]
//输出：[[1]]
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
// 树中节点数目在范围 [0, 2000] 内
// -1000 <= Node.val <= 1000
//
//
// Related Topics 树 广度优先搜索 二叉树 👍 1500 👎 0


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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if (root == null)
                return res;
            Queue<TreeNode> queue = new LinkedList();
            queue.add(root);
            int size;
            TreeNode curNode;
            while(!queue.isEmpty()){
                size = queue.size();
                List<Integer> level = new ArrayList<>();
                while (size>0){
                    curNode = queue.poll();
                    level.add(curNode.val);
                    if (curNode.left != null){
                        queue.add(curNode.left);
                    }
                    if (curNode.right != null){
                        queue.add(curNode.right);
                    }
                    size--;
                }
                res.add(level);
            }

            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
