package twonumsum;

/*
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。
提示：
2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
只会存在一个有效答案
进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？

Related Topics
数组
哈希表
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum01v1 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> record = new HashMap<>();
        int[] res = new int[2];
        int lastnum = 0;
        int currentIndex = -1;
        for (int i = 0; i < nums.length; i++){
            currentIndex = i;
            lastnum = target - nums[i];
            if (record.containsKey(lastnum)){
                res[1] = currentIndex;
                res[0] = record.get(lastnum);
                return res;
            }else {
                record.put(nums[i],record.getOrDefault(nums[i],currentIndex));
            }
        }
        return res;
    }

/*
示例 1：
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
示例 2：
输入：nums = [3,2,4], target = 6
输出：[1,2]
示例 3：
输入：nums = [3,3], target = 6
输出：[0,1]
 */
    public static void main(String[] args) {
//        int[] nums = {2,7,11,15};
//        int target = 9
        int[] nums = {3,2,4};
        int target = 6;
        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }
}
