import java.util.ArrayList;
import java.util.List;

public class IsValidBST98v1 {

    //给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//
// 有效 二叉搜索树定义如下：
//
//
// 节点的左子树只包含 小于 当前节点的数。
// 节点的右子树只包含 大于 当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树。
//
//
//
//
// 示例 1：
//
//
//输入：root = [2,1,3]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
//
//
//
//
// 提示：
//
//
// 树中节点数目范围在[1, 10⁴] 内
// -2³¹ <= Node.val <= 2³¹ - 1
//
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 1810 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

// 中序遍历，树就是有序的；
//    解答成功:
//    执行耗时:2 ms,击败了18.95% 的Java用户
//    内存消耗:40.6 MB,击败了97.05% 的Java用户
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
        public List<Integer> res= new ArrayList<>();
        public boolean isValidBST(TreeNode root) {

            travel(root);
            int guard = res.get(0);
            for (int i = 1; i < res.size(); i++) {
                if (res.get(i) > guard)
                    guard = res.get(i);
                else
                    return false;
            }
            return true;

        }

        public void travel(TreeNode root){
            if (root == null)
                return;

            if (root.left != null)
                travel(root.left);
            res.add(root.val);

            if (root.right != null)
                travel(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
