public class Trap42v1 {

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
            //  1 双指针法
            int sum = 0;

            for (int i = 0; i < height.length ; i++) {
                if ( i == 0 || i == height.length - 1)
                    continue;

                int rHeight = height[i]; // 记录右边柱子的最高高度
                int lHeight = height[i]; // 记录左边柱子的最高高度

                for (int r = i+1; r < height.length ; r++) {
                    if (height[r] > rHeight) rHeight = height[r];
                }

                for (int l = i-1; l >= 0 ; l--) {
                    if (height[l] > lHeight) lHeight = height[l];
                }
                int h = Math.min(lHeight,rHeight) - height[i];
                sum += h;
            }
            return sum;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
