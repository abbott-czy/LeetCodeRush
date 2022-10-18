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

//那么数组平方的最大值就在数组的两端，不是最左边就是最右边，不可能是中间。
//
//        此时可以考虑双指针法了，i指向起始位置，j指向终止位置。
//
//        定义一个新数组result，和A数组一样的大小，让k指向result数组终止位置。
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
