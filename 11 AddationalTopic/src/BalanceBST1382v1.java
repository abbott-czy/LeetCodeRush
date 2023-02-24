import java.util.ArrayList;

public class BalanceBST1382v1 {
    //给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。如果有多种构造方法，请你返回任意一种。
//
// 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
//
//
//
// 示例 1：
//
//
//
//
//输入：root = [1,null,2,null,3,null,4,null,null]
//输出：[2,1,3,null,null,null,4]
//解释：这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。
//
//
// 示例 2：
//
//
//
//
//输入: root = [2,1,3]
//输出: [2,1,3]
//
//
//
//
// 提示：
//
//
// 树节点的数目在 [1, 10⁴] 范围内。
// 1 <= Node.val <= 10⁵
//
//
// Related Topics 贪心 树 深度优先搜索 二叉搜索树 分治 二叉树 👍 157 👎 0


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
        ArrayList<Integer> res = new ArrayList<>();

        public TreeNode balanceBST(TreeNode root) {
            if (root == null)
                return root;
            vers(root);
            return getTree(res,0,res.size()-1);

        }

        public void vers(TreeNode root){
            if(root == null)return;
            vers(root.left);
            res.add(root.val);
            vers(root.right);
        }

        public TreeNode getTree(ArrayList<Integer> res, int left, int right){
            if (left > right) return  null;
            int mid = left + (right - left)/ 2;
            TreeNode root = new TreeNode(res.get(mid));
            root.left = getTree(res,left,mid-1);
            root.right = getTree(res,mid+1,right);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
