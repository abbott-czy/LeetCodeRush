import java.util.ArrayList;

public class LowestCommonAncestor236v1 {

    //给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。”
//
//
//
// 示例 1：
//
//
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
//
//
// 示例 2：
//
//
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
//
//
// 示例 3：
//
//
//输入：root = [1,2], p = 1, q = 2
//输出：1
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [2, 10⁵] 内。
// -10⁹ <= Node.val <= 10⁹
// 所有 Node.val 互不相同 。
// p != q
// p 和 q 均存在于给定的二叉树中。
//
//
// Related Topics 树 深度优先搜索 二叉树 👍 2042 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


//解答成功:
//	执行耗时:9 ms,击败了16.35% 的Java用户
//	内存消耗:43.5 MB,击败了5.81% 的Java用户
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    class Solution {

        ArrayList<TreeNode> pList;
        ArrayList<TreeNode> qList;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if ( root == null)
                return null;
            pList = new ArrayList<TreeNode>();
            qList = new ArrayList<TreeNode>();
            trave(root,p,new ArrayList<TreeNode>(),pList);
            trave(root,q,new ArrayList<TreeNode>(),qList);
            for (int i = pList.size() -1 ; i >= 0; i--) {
                if (qList.contains(pList.get(i))){
                    return qList.get(i);
                }
            }

            return null;

        }

        public void trave(TreeNode root,TreeNode target,ArrayList<TreeNode> list,ArrayList<TreeNode> res){
            if (root == null)
                return;

            list.add(root);
            if (root.val == target.val){
                for (int i = 0; i < list.size() ; i++) {
                    res.add(list.get(i));
                }
                return;
            }

            if(root.left != null)
            {
                trave(root.left,target,list,res);
                list.remove(list.size() - 1);
            }
            if (root.right != null){
                trave(root.right,target,list,res);
                list.remove(list.size() - 1);
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
