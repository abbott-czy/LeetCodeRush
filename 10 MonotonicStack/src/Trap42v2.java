public class Trap42v2 {
    //给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 示例 1：
//
//
//
//
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
//
// 示例 2：
//
//
//输入：height = [4,2,0,3,2,5]
//输出：9
//
//
//
//
// 提示：
//
//
// n == height.length
// 1 <= n <= 2 * 10⁴
// 0 <= height[i] <= 10⁵
//
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 4014 👎 0



    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            // 2 动态规划
            int length = height.length;
            if (length <= 2)
                return 0;
            int[] maxLeft = new int[length];
            int[] maxRight = new int[length];

            // 记录每个柱子左边的最高高度
            maxLeft[0] = height[0];
            for (int i = 1; i < length ; i++) {
                maxLeft[i] = Math.max(height[i],maxLeft[i-1]);
            }

            maxRight[length-1] = height[length-1];
            for (int i = length-2; i >=0 ; i--) {
                maxRight[i] = Math.max(height[i],maxRight[i+1]);
            }
            int sum = 0;
            for (int i = 0; i < length; i++) {
                sum += Math.min(maxLeft[i],maxRight[i]) - height[i];
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
