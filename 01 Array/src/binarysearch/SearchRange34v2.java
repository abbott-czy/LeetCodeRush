package binarysearch;

import java.util.Arrays;

/**
 * 一个函数来寻找左右边界
 *
 */


public class SearchRange34v2 {

    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[] {-1,-1};
        res[0] = binarySearch(nums,target,true);
        res[1] = binarySearch(nums,target,false);
        return res;
    }

    public static int binarySearch(int[] nums,int target,Boolean leftOrRight){
        int res = -1;
        int left = 0;
        int right = nums.length;
        while(left < right){
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target){
                right = mid;
            }
            else if (nums[mid] < target){
                left = mid +1;
            }
            else {
                res = mid;
                if (leftOrRight){
                    right = mid;
                    }
                else
                    left = mid +1;
                }
            }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {5,5,8,8,8,8,10};
        int target = 5;
        int[] ints = searchRange(nums, target);
        System.out.println(Arrays.toString(ints));
    }
}
