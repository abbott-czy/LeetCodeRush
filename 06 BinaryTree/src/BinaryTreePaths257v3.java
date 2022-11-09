import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths257v3 {

// 递归回溯
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
            List<String> ans = new ArrayList<>();
            preOrder(root,"",ans);

            return ans;
        }
// 要用前序遍历

        public void preOrder(TreeNode root, String temp,List<String> ans){

            if (root == null) return;

            temp += root.val;

            if (root.left == null && root.right == null){
                ans.add(temp);
            }
            preOrder(root.left,temp + "->",ans);
            preOrder(root.left, temp + "->", ans);
        }




    }
//leetcode submit region end(Prohibit modification and deletion)

}
