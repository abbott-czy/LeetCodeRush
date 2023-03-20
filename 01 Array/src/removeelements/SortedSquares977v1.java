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

// 解决方案是基于冒泡排序，执行时间打5%，内存消耗打败5%。
// 时间复杂度为O(n^2)
public class SortedSquares977v1 {
    public static int[] sortedSquares(int[] nums) {
        if (nums.length == 1){
            nums[0] = nums[0] * nums[0];
            return nums;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        for (int i = 0; i < nums.length;i++){
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]){
                    int tem = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tem;
                }
            }
        }


//        int slowPoint = 0;
//        int  temNum = nums[0] * nums[0];
//        for(int fastPoint = 1; fastPoint< nums.length; fastPoint++){
//            int currentNum = nums[fastPoint] * nums[fastPoint];
//            if (currentNum < temNum ){
//                int tem = 0;
//
//            }
//        }

        return nums;
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
