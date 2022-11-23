import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute46v1 {

    //给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
// 示例 2：
//
//
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// nums 中的所有整数 互不相同
//
//
// Related Topics 数组 回溯 👍 2308 👎 0



    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> res = new ArrayList<>();
        public LinkedList<Integer> path = new LinkedList<>();
        public boolean[]  isUsed;
        public List<List<Integer>> permute(int[] nums) {
            isUsed = new boolean[nums.length];
            for (int i = 0; i < isUsed.length; i++) {
                isUsed[i] = false;
            }
            backTracking(nums, 0);
            return res;
        }

        public void backTracking(int[] nums, int idx){

            if (path.size() == nums.length){
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < nums.length ; i++) {
                if (isUsed[i] ==false){
                    isUsed[i] = true;
                    path.add(nums[i]);
                    backTracking(nums,i+1);
                    path.removeLast();
                    isUsed[i] = false;
                }else {
                    continue;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
