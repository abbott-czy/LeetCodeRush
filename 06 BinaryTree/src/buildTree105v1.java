import java.util.HashMap;
import java.util.Map;

public class buildTree105v1 {
    //给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。
//
//
//
// 示例 1:
//
//
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
//
//
// 示例 2:
//
//
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
//
//
//
//
// 提示:
//
//
// 1 <= preorder.length <= 3000
// inorder.length == preorder.length
// -3000 <= preorder[i], inorder[i] <= 3000
// preorder 和 inorder 均 无重复 元素
// inorder 均出现在 preorder
// preorder 保证 为二叉树的前序遍历序列
// inorder 保证 为二叉树的中序遍历序列
//
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1788 👎 0


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

        public Map<Integer,Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0)
                return null;

            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i],i);
            }
            return  consruct(preorder,0,preorder.length,inorder,0,inorder.length);

        }

        public TreeNode consruct(int[] preorder,int preBegin,int preEnd,int[] inorder,int inBegin,int inEnd){
            if (preBegin >= preEnd || inBegin >= inEnd)
                return null;

            TreeNode root = new TreeNode(preorder[preBegin]);
            int index = map.get(preorder[preBegin]);
            int len = index - inBegin;

            root.left = consruct(preorder,preBegin + 1, preBegin + 1 + len, inorder, inBegin,index);
            root.right = consruct(preorder,preBegin +1 + len, preEnd, inorder,index+1, inEnd);

            return root;



        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
