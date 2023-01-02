import java.util.Stack;

public class Trap42v3 {
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
            // 3 单调栈法
            int size = height.length;

            if (size <= 2) return 0;

            // in the stack, we push the index of array
            // using height[] to access the real height
            Stack<Integer> stack = new Stack<Integer>();
            stack.push(0);

            int sum = 0;
            for (int index = 1; index < size; index++){
                int stackTop = stack.peek();
                if (height[index] < height[stackTop]){
                    stack.push(index);
                }else if (height[index] == height[stackTop]){
                    // 因为相等的相邻墙，左边一个是不可能存放雨水的，所以pop左边的index, push当前的index
                    stack.pop();
                    stack.push(index);
                }else{
                    //pop up all lower value
                    int heightAtIdx = height[index];
                    while (!stack.isEmpty() && (heightAtIdx > height[stackTop])){
                        int mid = stack.pop();

                        if (!stack.isEmpty()){
                            int left = stack.peek();

                            int h = Math.min(height[left], height[index]) - height[mid];
                            int w = index - left - 1;
                            int hold = h * w;
                            if (hold > 0) sum += hold;
                            stackTop = stack.peek();
                        }
                    }
                    stack.push(index);
                }
            }

            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
