import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermuteUniqueII47v1 {

    //给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10
//
//
// Related Topics 数组 回溯 👍 1239 👎 0



    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> res =new ArrayList<>();
        public LinkedList<Integer> path = new LinkedList<>();
        public boolean[] isUsed;
        public List<List<Integer>> permuteUnique(int[] nums) {
            isUsed = new boolean[nums.length];
            for (int i = 0; i < nums.length; i++) {
                isUsed[i] = false;
            }
            Arrays.sort(nums);
            backTracking(nums);
            return res;
        }

        public void backTracking(int[] nums){
            if (path.size() == nums.length){
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < nums.length ; i++) {
                if (isUsed[i] == true ){
                    continue;
                }
                if ((i > 0 && nums[i] == nums[i-1]) && isUsed[i - 1] == false){
                    continue;
                }
                else {
                    isUsed[i] = true;
                    path.add(nums[i]);
                    backTracking(nums);
                    path.removeLast();
                    isUsed[i] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
