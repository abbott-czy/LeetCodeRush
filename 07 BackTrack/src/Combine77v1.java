
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine77v1 {
    //给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
// 你可以按 任何顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
//
// 示例 2：
//
//
//输入：n = 1, k = 1
//输出：[[1]]
//
//
//
// 提示：
//
//
// 1 <= n <= 20
// 1 <= k <= n
//
//
// Related Topics 回溯 👍 1196 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        LinkedList<Integer> path = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            if (n == 0)
                return res;
            rollback(n,k,1);
            return res;
        }

        public void rollback(int n, int k, int indx){
            if ( path.size() == k){
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = indx; i <= n ; i++) {
                path.add(i);
                rollback(n,k,i+1);
                path.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
