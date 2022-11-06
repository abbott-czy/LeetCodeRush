import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom107v1 {

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
            List<List<Integer>> res = new ArrayList<>();
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
//                        queue.add(curNode.right);
                    }
                    if (curNode.right != null){
//                        queue.add(curNode.right);
                    }
                    size--;
                }
                res.add(level);
            }

            if (res.size()==1)
                return res;

            int left = 0;
            int right = res.size()-1;
            List<Integer> tem = new ArrayList<>();
            while (left<right){
                tem = res.get(left);
                res.set(left,res.get(right));
                res.set(right,tem);
                left++;
                right--;
            }
            return  res;

        }
    }
}
