package removeelements;

import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。

 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 * 进阶：
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 * Related Topics
 * 数组
 * 双指针
 * 排序
 */

// 绝对值排序问题，最大值是从左右两端产生的，所以对左右两端的数进选择最大值排序，
//  双指针分别指向左右两端，从两端逐渐排序。
// 时间复杂度为O(n)
public class SortedSquares977v2 {
    public static int[] sortedSquares(int[] nums) {

        int right = nums.length -1 ;
        int left = 0;
        int[] result = new int[nums.length];
        int index = result.length - 1;
        while(left <= right){
            if(nums[left] * nums[left] > nums[right] * nums[right]){
               result[index--] = nums[left] * nums[left];
               ++left;
            }else {
                result[index--] = nums[right] * nums[right];
                --right;
            }
        }

        for(int i :result){
            System.out.println(i);
        }


        return result;
    }

//            * 输入：nums = [-4,-1,0,3,10]
//            * 输出：[0,1,9,16,100]
//            * 解释：平方后，数组变为 [16,1,0,9,100]
//            * 排序后，数组变为 [0,1,9,16,100]
//            * 输入：nums = [-7,-3,2,3,11]
//            * 输出：[4,9,9,49,121]

    public static void main(String[] args) {
//        int[] nums = {-4,-1,0,3,10};
        int[] nums = {-7,-3,2,3,11};
        int[] ints = sortedSquares(nums);
        System.out.println(Arrays.toString(ints));
    }
}
