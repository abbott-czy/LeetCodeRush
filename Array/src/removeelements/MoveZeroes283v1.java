package removeelements;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * 进阶：你能尽量减少完成的操作次数吗？
 *
 * Related Topics
 * 数组
 * 双指针
 *
 */

public class MoveZeroes283v1 {

    public static void moveZeroes(int[] nums) {
        int cur = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                nums[cur++] = nums[i];
            }
        }
        for(int i = cur;i< nums.length; i++){
            nums[i] = 0;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

//            * 输入: nums = [0,1,0,3,12]
//            * 输出: [1,3,12,0,0]
//            * 示例 2:
//            *
//            * 输入: nums = [0]
//            * 输出: [0]

    public static void main(String[] args) {
//        int[] nums = {0,1,0,3,12};
//        int[] nums = {1,0};
        int[] nums = {2,1};
        moveZeroes(nums);
    }
}
