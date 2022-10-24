package threenumsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
你返回所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。

提示：
3 <= nums.length <= 3000
-105 <= nums[i] <= 105
Related Topics
数组
双指针
排序
 */
public class ThreeSum15v1 {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] > 0)
                return res;

            if (i>0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0){
                    right--;
                }else  if (sum < 0){
                    left++;
                }else {
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (right > left && nums[right] == nums[right -1]) right--;
                    while (right > left && nums[left] == nums[left+1]) left++;

                    right --;
                    left++;

                }
            }
        }

        return  res;
    }

/*
例 1：

输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
解释：
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。
示例 2：
输入：nums = [0,1,1]
输出：[]
解释：唯一可能的三元组和不为 0 。
示例 3：
输入：nums = [0,0,0]
输出：[[0,0,0]]
解释：唯一可能的三元组和为 0 。
 */
    public static void main(String[] args) {
//        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {0,0,0,0};
        List<List<Integer>> listList = threeSum(nums);
        for(List<Integer> i : listList){
            System.out.println(i.toString());
        }
    }
}
