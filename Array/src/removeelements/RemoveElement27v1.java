package removeelements;


/**
 * 快慢指针方式，慢指针指向val，快指针向前遍历
 *
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 说明:
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 * Related Topics
 * 数组
 * 双指针
 *
 */
public class RemoveElement27v1 {

    public static int removeElement(int[] nums, int val) {
        int numsLength = nums.length;
        int slowPointer = nums.length -1;
        int quickPointer = nums.length -1;
        for (int i = numsLength -1; i >=0; i--) {
            if (nums[i] == val){
                int tem = nums[slowPointer];
                nums[slowPointer] = nums[i];
                nums[i] = tem;
                numsLength--;
                slowPointer--;
            }
            quickPointer -=1;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+",");
        }
        System.out.println("");
        return numsLength;
    }


//    输入：nums = [3,2,2,3], val = 3
//    输出：2, nums = [2,2]
//    解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
//    输入：nums = [0,1,2,2,3,0,4,2], val = 2
//    输出：5, nums = [0,1,4,0,3]

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
//        int[] nums = {3,2,2,3};
//        int val = 3;
        int i = removeElement(nums, val);
        System.out.println(i);
    }


}
