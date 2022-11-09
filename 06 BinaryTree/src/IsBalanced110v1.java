public class IsBalanced110v1 {

    //给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为：
//
//
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
//
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
//
//
// 示例 3：
//
//
//输入：root = []
//输出：true
//
//
//
//
// 提示：
//
//
// 树中的节点数在范围 [0, 5000] 内
// -10⁴ <= Node.val <= 10⁴
//
//
// Related Topics 树 深度优先搜索 二叉树 👍 1177 👎 0


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


/*
解答成功:
	执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:40.7 MB,击败了97.63% 的Java用户
 */
    class Solution {
        public boolean isBalanced(TreeNode root) {
            int is = balance(root);
            if (is == -1)
                return false;
            else
                return true;
        }

        public int balance(TreeNode root){
            int res;
            if (root == null)
                return 0;

            int leftBalance  = balance(root.left);
            if (leftBalance == -1) return -1;

            int rightBalance = balance(root.right);
            if (rightBalance == -1) return  -1;

            if (Math.abs(leftBalance - rightBalance) > 1){
                res  = -1;
            }else {
                res = 1 + Math.max(leftBalance,rightBalance);
            }

            return  res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
