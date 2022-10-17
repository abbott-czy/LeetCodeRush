package binarysearch;


import java.util.Arrays;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 * Related Topics
 * 数组
 * 二分查找
 */

public class SearchRange34v1 {
    public static int[] searchRange(int[] nums, int target) {
        int[] Interval = {-1,-1};
        int leftBorder = getLeftBorder(nums, target);
        int rightBorder = getRightBorder(nums, target);
        // 情况一：target在nums范围外
        if (leftBorder == -2 || rightBorder == -2)
            return Interval;
        // 情况二:target在num范围内，且找的到
        if (rightBorder - leftBorder >=1){
            Interval[0] = leftBorder;
            Interval[1] = rightBorder - 1;
            return Interval;
        }
        // 情况三：target在num范围内，找不到
        return Interval;
    }

    static int getLeftBorder(int[] nums, int target){
        int left = 0;
        int right = nums.length;
        int leftBorder = -2;
        while(left < right){
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target){
                right = mid;
                leftBorder = right;
            }else {
                left = mid+1;
            }
        }
        return leftBorder;
    }

    static int getRightBorder(int[] nums,int target){
        int left = 0;
        int right = nums.length;
        int rightBorder = -2;
        while(left < right){
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target){
                right = mid;

            }else {
                left = mid+1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }



    public static void main(String[] args) {
        int[] nums = {5,5,8,8,8,8,10};
        int target = 10;
        int[] ints = searchRange(nums, target);
        System.out.println(Arrays.toString(ints));
    }


}

/**
 *  * 输入：nums = [5,7,7,8,8,10], target = 8
 *  * 输出：[3,4]
 *  * 输入：nums = [5,7,7,8,8,10], target = 6
 *  * 输出：[-1,-1]
 *  * 输入：nums = [], target = 0
 *  * 输出：[-1,-1]
 *
 *  情况一：target在数组的范围左边或者右边边界外，返回{-1,-1}
 *  情况二：target在数组的范围内，但是找不到target，返回{-1,-1}
 *  情况三：target在数组范围内，且存在target，此时寻找左边界和右边界。
 */
