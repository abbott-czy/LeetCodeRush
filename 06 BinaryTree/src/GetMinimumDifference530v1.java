public class GetMinimumDifference530v1 {

    //给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
//
// 差值是一个正数，其数值等于两值之差的绝对值。
//
//
//
// 示例 1：
//
//
//输入：root = [4,2,6,1,3]
//输出：1
//
//
// 示例 2：
//
//
//输入：root = [1,0,48,null,null,12,49]
//输出：1
//
//
//
//
// 提示：
//
//
// 树中节点的数目范围是 [2, 10⁴]
// 0 <= Node.val <= 10⁵
//
//
//
//
// 注意：本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-
//nodes/ 相同
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 二叉树 👍 395 👎 0


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
//    解答成功:
//    执行耗时:0 ms,击败了100.00% 的Java用户
//    内存消耗:40.9 MB,击败了82.09% 的Java用户

    class Solution {
        // 最小误差 应该是相邻两个元素之间产生
        public int minRSE = Integer.MAX_VALUE;
        public TreeNode preNode;
        public int getMinimumDifference(TreeNode root) {
            if (root == null)
                return 0;
            mininumRSE(root);
            return minRSE;
        }

        public void mininumRSE(TreeNode root){
            if (root == null)
                return;

            mininumRSE(root.left);
            if (preNode != null){
                int tem = Math.abs(root.val - preNode.val);
                minRSE = Math.min(tem, minRSE);
            }
            preNode = root;
            mininumRSE(root.right);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
