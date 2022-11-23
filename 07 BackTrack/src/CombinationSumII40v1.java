import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII40v1 {
    //给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用 一次 。
//
// 注意：解集不能包含重复的组合。
//
//
//
// 示例 1:
//
//
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
//
// 示例 2:
//
//
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//]
//
//
//
// 提示:
//
//
// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30
//
//
// Related Topics 数组 回溯 👍 1168 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> res = new ArrayList<>();
        public LinkedList<Integer> list = new LinkedList<>();
        public int sum = 0;
        boolean[] used;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            used = new boolean[candidates.length];
            Arrays.fill(used,false);
            Arrays.sort(candidates);
            backTracking(candidates,target,0);
            return res;
        }

        public void backTracking(int[] candidates, int target,int indx){

            if (sum == target)
            {
                res.add(new ArrayList<>(list));
                return;
            }

            for (int i = indx; i < candidates.length ; i++) {
                if (i > 0 && (candidates[i] == candidates[i - 1] &&  !used[i - 1])){
                    continue;
                }
                if (sum +candidates[i] > target)
                    break;
                used[i] = true;
                sum += candidates[i];
                list.add(candidates[i]);
                backTracking(candidates,target, i +1);
                used[i] = false;
                sum -= candidates[i];
                list.removeLast();
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
