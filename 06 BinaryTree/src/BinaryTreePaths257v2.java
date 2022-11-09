import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths257v2 {

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
            List<String> res = new ArrayList<>();
            if (root == null)
                return res;
            List<Integer> path = new ArrayList<>();

            pathList(root, path,  res);

            return res;

        }
        // 要用前序遍历
        public void pathList(TreeNode root,List<Integer> path, List<String> res){
            System.out.println(root.val);
            path.add(root.val);
            System.out.println("此次递归的path.size()" + path.size());

            if (root.left == null && root.right == null){
                StringBuilder sb = new StringBuilder();
                System.out.println("path.size"+ path.size());
                for (int i = 0; i < path.size() - 1; i++) {
                    sb.append(path.get(i)).append("->");
                }
                sb.append(path.get(path.size()-1));
                res.add(sb.toString());
                return;
            }
            if (root.left != null){
                pathList(root.left,path,res);
                path.remove(path.size() - 1); // 回溯
            }
            if (root.right != null){
                pathList(root.right,path,res);
                path.remove(path.size() - 1); // 回溯
            }


        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
