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

// 使用滑动窗口，只用一个for循环解决
// 不断调节子序列的起始位置和终止位置，而滑动窗口的长度应该是最大子序列长度
//  这也是一种双指针的方法，
//    窗口就是 满足其和 ≥ s 的长度最小的 连续 子数组。
//
//窗口的起始位置如何移动：如果当前窗口的值大于s了，窗口就要向前移动了（也就是该缩小了）。
//
//窗口的结束位置如何移动：窗口的结束位置就是遍历数组的指针，也就是for循环里的索引。

//    不要以为for里放一个while就以为是O(n^2)啊， 主要是看每一个元素被操作的次数，每个元素在滑动窗后进来操作一次，
//    出去操作一次，每个元素都是被操作两次，所以时间复杂度是 2 × n 也就是O(n)。
public class minSubArrayLen209v2 {

    public static int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++){
            sum += nums[right];
            while (sum >= target){
                result = Math.min(result,right - left + 1);
                sum -= nums[left++];
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
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
//        int target =11;
//        int[] nums = {1,1,1,1,1,1,1,1};
        int target = 11;
        int[] nums = {3,4,5};   // 答案是3，测试结果是2.
        int i = minSubArrayLen(target, nums);
        System.out.println(i);
    }

}
