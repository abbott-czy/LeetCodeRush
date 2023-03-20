package binarysearch;


public class SearchInsertLocation35v1 {

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 请必须使用时间复杂度为 O(log n) 的算法。
     * 提示
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 为 无重复元素 的 升序 排列数组
     * -104 <= target <= 104
     */
    public static int  searchInsert(int[] nums, int target) {
        if (target < nums[0]){
            return 0;
        }
        if (target > nums[nums.length -1]){
            return nums.length;
        }
        int left = 0;
        int right = nums.length;
        int midInsert = -1;
        while(left < right){
            int mid = left + ((right - left) >> 1);
            midInsert = mid;
            if(nums[mid] == target){
                return mid;
            }
            if(target < nums[mid]){
                right = mid;
                midInsert = mid;
            }
            if (target > nums[mid]){
                left = mid + 1;
                midInsert = mid + 1;
            }
        }
        return midInsert;

    }

    public static void main(String[] args) {
//        int[] nums = {1,3,5,6};
//        int target = 5;
        int[] nums = {1,3,5,6};
        int target = 7;
        int i = searchInsert(nums, target);
        System.out.println(i);
//                * 输入: nums = [1,3,5,6], target = 5
//                * 输出: 2
//                * 输入: nums = [1,3,5,6], target = 2
//                * 输出: 1
//                * 输入: nums = [1,3,5,6], target = 7
//                * 输出: 4
    }

}
