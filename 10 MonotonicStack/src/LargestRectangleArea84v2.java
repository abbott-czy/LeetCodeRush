import java.util.Stack;

public class LargestRectangleArea84v2 {
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
            // 2 单调栈
            Stack<Integer> st = new Stack<>();
            // 数组扩容，在头和尾各加入一个元素
            int[] newHeights = new int[heights.length + 2];
            newHeights[0] = 0;
            newHeights[newHeights.length - 1] = 0;
            for (int index = 0; index < heights.length ; index++) {
                newHeights[index+1] = heights[index];
            }
            heights = newHeights;

            st.push(0);
            int result = 0;
            // 第一个元素已经入栈，从下标1开始
            for (int i = 1; i < heights.length ; i++) {
                // 注意heights[i] 是和heights[st.top()] 比较 ，st.top()是下标
                if (heights[i] > heights[st.peek()]){
                    st.push(i);
                }else if (heights[i] == heights[st.peek()]){
                    st.pop();
                    st.push(i);
                }else {
                    while(heights[i] < heights[st.peek()]){
                        int mid = st.peek();
                        st.pop();
                        int left = st.peek();
                        int right = i;
                        int w = right -left-1;
                        int h = heights[mid];
                        result = Math.max(result,w*h);
                    }
                    st.push(i);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
