public class LargestRectangleArea84v1 {
    //给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。
//
//
//
// 示例 1:
//
//
//
//
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
//
//
// 示例 2：
//
//
//
//
//输入： heights = [2,4]
//输出： 4
//
//
//
// 提示：
//
//
// 1 <= heights.length <=10⁵
// 0 <= heights[i] <= 10⁴
//
//
// Related Topics 栈 数组 单调栈 👍 2268 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            // 1 动态规划
            int length = heights.length;
            int[] minLeftIndex = new int[length];
            int[] minRightIndex = new int[length];
            // 记录左边第一个小于该柱子的下标
            minLeftIndex[0] = -1;
            for (int i = 1; i < length ; i++) {
                int t = i -1;
                // 这里不是用if，而是不断向右寻找的过程
                while(t >= 0 && heights[t] >= heights[i]){
                    t = minLeftIndex[t];
                }
                minLeftIndex[i] = t;
            }

            // 记录每个柱子右边第一个小于该柱字的下标
            minRightIndex[length-1] = length;
            for (int i = length-2; i >=0 ; i--) {
                int t = i + 1 ;
                while(t<length && heights[t] >= heights[i]){
                    t = minRightIndex[t];
                }
                minRightIndex[i]= t;
            }
            int res = 0;
            for (int i = 0; i < length; i++) {
                int sum = heights[i] * (minRightIndex[i] - minLeftIndex[i] - 1);
                res = Math.max(sum,res);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
