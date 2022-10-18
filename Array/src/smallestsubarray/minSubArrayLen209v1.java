package smallestsubarray;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 提示：
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * 进阶：
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 * Related Topics
 * 数组
 * 二分查找
 * 前缀和
 * 滑动窗口
 */

//使用暴利解法， 该方式属于暴利解法已经超时
public class minSubArrayLen209v1 {

    public static int minSubArrayLen(int target, int[] nums) {
        int currentSum = 0;
        int currentLen = 0;
        int subLen = 999;
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i; j < nums.length; j++) {
                if (currentSum + nums[j] <target){
                    currentLen +=1;
                    currentSum += nums[j];
                }else {
                    currentLen += 1;
                    if (currentLen < subLen){
                        subLen = currentLen;
                    }
                    break;
                }

//                if ( j == nums.length -1 && currentSum < target ){
//                    return 0;
//                }
            }
            currentSum = 0;
            currentLen = 0;

        }
        if (subLen == 999)
            return 0;
        return subLen;
//        int current = 0;
//        int subLen = 0;
//        int left = 0;
//        int right = nums.length;
//        while (left < right){
//            int mid = left + ((right - left) >> 2);
//            if (mid == target){
//                return 1;
//            }
//            if (mid < target){
//                subLen +=1;
//                current += mid;
//                left = mid + 1;
//            }
//            if (mid > target){
//                current = 0;
//                right = mid;
//            }
//        }

    }

/*
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 */
    public static void main(String[] args) {
//        int target = 7;
//        int[] nums = {2,3,1,2,4,3};
//        int target = 4;
//        int[] nums = {1,4,4};
        int target =11;
        int[] nums = {1,1,1,1,1,1,1,1};
//        int target = 11;
//        int[] nums = {3,4,5};   // 答案是3，测试结果是2.
        int i = minSubArrayLen(target, nums);
        System.out.println(i);
    }

}
