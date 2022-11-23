import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SusetsWithDup90v1 {
    //给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
//
//
//
//
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
//
//
// 示例 2：
//
//
//输入：nums = [0]
//输出：[[],[0]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
//
//
// Related Topics 位运算 数组 回溯 👍 972 👎 0



    //leetcode submit region begin(Prohibit modification and deletion)
        public static List<List<Integer>> res = new ArrayList<>();
        public static LinkedList<Integer> path = new LinkedList<>();
        public static List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            backTracking(nums,0);
            return res;

        }

        public static void backTracking(int[] nums, int idx){
            res.add(new ArrayList<>(path));

            if (idx >= nums.length)
                return;

            for (int i = idx; i < nums.length; i++) {
                // 层剪枝
            if (i > idx && nums[i-1] == nums[i]){
                continue;
            }
                path.add(nums[i]);
                backTracking(nums,i+1);
                path.removeLast();

            }
        }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        List<List<Integer>> lists = subsetsWithDup(nums);
    }
    }


//leetcode submit region end(Prohibit modification and deletion)
