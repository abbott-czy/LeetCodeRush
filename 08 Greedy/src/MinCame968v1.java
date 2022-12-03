public class MinCame968v1 {
    //给定一个二叉树，我们在树的节点上安装摄像头。
//
// 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
//
// 计算监控树的所有节点所需的最小摄像头数量。
//
//
//
// 示例 1：
//
//
//
// 输入：[0,0,null,0,0]
//输出：1
//解释：如图所示，一台摄像头足以监控所有节点。
//
//
// 示例 2：
//
//
//
// 输入：[0,0,null,0,null,0,null,null,0]
//输出：2
//解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
//
//
// 提示：
//
//
// 给定树的节点数的范围是 [1, 1000]。
// 每个节点的值都是 0。
//
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 514 👎 0


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
        int res = 0;
        public int minCameraCover(TreeNode root) {
            if (minCame(root) == 0)
                res++;
            return res;

        }

        public int minCame(TreeNode root){
            if (root == null){
                // 空节点默认为有覆盖状态，避免在叶子节点上放摄像头
                return 2;
            }
            int left = minCame(root.left);
            int right = minCame(root.right);

            // 如果左右结点都覆盖了，那么本节点的状态应该是无覆盖，没有摄像头
            if (left == 2 && right == 2) {
                return 0;
            }else if (left == 0 || right == 0){
                // 如果左右都有没有被覆盖的结点，则该节点设置为监控结点
                res++;
                return 1;
            }else{
                // 左或者右结点有一个监控
                return 2;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
