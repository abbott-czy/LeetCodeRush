import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths257v1 {
    //给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
//
// 叶子节点 是指没有子节点的节点。
//
// 示例 1：
//
//
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
//
//
// 示例 2：
//
//
//输入：root = [1]
//输出：["1"]
//
//
//
//
// 提示：
//
//
// 树中节点的数目在范围 [1, 100] 内
// -100 <= Node.val <= 100
//
//
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 844 👎 0


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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res  = new ArrayList<>();
            if (root == null)
                return res;
            Stack<Object> stack = new Stack<>();
            stack.push(root);
            stack.push(root.val + "");
            TreeNode curNode;
            String path;
            while (!stack.isEmpty()){
                path = (String) stack.pop();
                curNode =(TreeNode) stack.pop();
                if (curNode.left == null && curNode.right == null)
                    res.add(path);

                if (curNode.right != null){
                    stack.push(curNode.right);
                    stack.push(path + "->" + curNode.right.val);
                }

                if (curNode.left != null){
                    stack.push(curNode.left);
                    stack.push(path + "->" + curNode.left.val);
                }
            }
            return res;



        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
