public class FindNumberOfLIS673v1 {
    //给定一个未排序的整数数组
// nums ， 返回最长递增子序列的个数 。
//
// 注意 这个数列必须是 严格 递增的。
//
//
//
// 示例 1:
//
//
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
//
//
// 示例 2:
//
//
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
//
//
//
//
// 提示:
//
//
//
//
//
// 1 <= nums.length <= 2000
// -10⁶ <= nums[i] <= 10⁶
//
//
// Related Topics 树状数组 线段树 数组 动态规划 👍 705 👎 0

// 1. 确定dp数组以及下标的含义： dp[i]表示i之前最长递归子序列的长度为dp[i] count[i]表示以nums[i]为结尾的字符串，最长递归子序列的
// 个数
// 2. 确定递归公式：以nums[i]为结尾的字符串，最长递增子序列的个数为count[i]。 如果在i之前j找到了dp[j] + 1 > dp[i]，则认为找到了
//    一个更长的递归子序列count[i] = count[j]。如果如果在[0, i-1]的范围内，找到了j，使得dp[j] + 1 == dp[i]，说明找到了两个相同
//    长度的递增子序列。count[i] += count[j];
// 3. dp数组初始化：count[i]记录了以nums[i]为结尾的字符串，最长递增子序列的个数，则至少为1，dp记录了i之前最长的长度也至少为1.
// 4. 确定遍历顺序：dp[i] 是由0到i-1各个位置的最长升序子序列 推导而来，那么遍历i一定是从前向后遍历。
//      j其实就是0到i-1，遍历i的循环里外层，遍历j则在内层。最后还有再遍历一遍dp[i]，把最长递增序列长度对应的count[i]累计下来就是结果了。
// 5. 举例推导dp数组

    class Solution {
        public int findNumberOfLIS(int[] nums) {
            // 1.递归子序列要求严格递增 a[i] < a[i+1]
            if (nums.length<=1)
                return nums.length;
            int[] dp = new int[nums.length];
            for (int i = 0; i < dp.length; i++) {
                dp[i] = 1;
            }
            int[] count = new int[nums.length];
            for (int i = 0; i < count.length; i++) {
                count[i]=1;
            }

            int maxCunt = 0;
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i]> nums[j]){
                        if (dp[j]+1 > dp[i]){
                            dp[i] = dp[j] + 1;
                            count[i] = count[j];
                        }else if (dp[j] + 1 == dp[i]){
                            count[i] += count[j];
                        }
                    }
                    maxCunt = Math.max(dp[i],maxCunt);
                }
            }
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                if (dp[i] == maxCunt){
                    res += count[i];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

