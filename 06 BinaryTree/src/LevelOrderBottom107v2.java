import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom107v2 {

    //给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：[[15,7],[9,20],[3]]
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
// Related Topics 树 广度优先搜索 二叉树 👍 630 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        LevelOrder102v1.TreeNode left;
        LevelOrder102v1.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, LevelOrder102v1.TreeNode left, LevelOrder102v1.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if (root == null){
                return res;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                List<Integer> oneLevel = new ArrayList<>();
                int count = queue.size();
                for (int i = 0; i < count; i++) {
                    TreeNode node = queue.poll();
                    oneLevel.add(node.val);
                    if (node.left != null)
//                        queue.add(node.left);
                    if (node.right != null){
//                        queue.add(node.right);
                    }
//
                }
                // 每次都往队头塞
               res.add(0,oneLevel);
            }

            return res;
        }
    }
}
