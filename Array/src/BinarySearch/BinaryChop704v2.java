package BinarySearch;


public class BinaryChop704v2 {
    /**
     * 二分查找
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，
     * 如果目标值存在返回下标，否则返回 -1。
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {

        if (target < nums[0] || target > nums[nums.length - 1]){
            return  -1;
        }

        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target){
                return mid;
            }
            else if (target < nums[mid]){
                right = mid ;
            }
            else if (target > nums[mid]){
                left = mid + 1;
            }
        }
        return -1;

    }


    public static void main(String[] args) {
//        int[] nums = {-1,0,3,5,9,12,17};
//        int[] nums = {-1,0,5};
        int[] nums = {5};
        int target = 5;
        int search = search(nums, target);
        System.out.println(search);
    }
}

