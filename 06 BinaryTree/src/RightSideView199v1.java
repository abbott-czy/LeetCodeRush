import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView199v1 {

    //给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
//
//
// 示例 1:
//
//
//
//
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
//
//
// 示例 2:
//
//
//输入: [1,null,3]
//输出: [1,3]
//
//
// 示例 3:
//
//
//输入: []
//输出: []
//
//
//
//
// 提示:
//
//
// 二叉树的节点个数的范围是 [0,100]
//
// -100 <= Node.val <= 100
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 777 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

    public class TreeNode {
        int val;
        PreorderTraversal145v1.TreeNode left;
        PreorderTraversal145v1.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, PreorderTraversal145v1.TreeNode left, PreorderTraversal145v1.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            if (root == null)
                return res;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int size;
            TreeNode curNode;
            while (!queue.isEmpty()){
                size = queue.size();
                while (size>0){
                    curNode = queue.poll();
                    if (size == 1)
                        res.add(curNode.val);
                    if (curNode.left !=null)
//                        queue.add(curNode.left);
                    if (curNode.right != null)
//                        queue.add(curNode.right);
                    size--;
                }
            }
            return res;

        }
    }
}
