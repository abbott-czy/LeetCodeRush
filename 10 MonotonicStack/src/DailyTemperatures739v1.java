import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperatures739v1 {
    //给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现
//在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
//
//
//
// 示例 1:
//
//
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
//
//
// 示例 2:
//
//
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
//
//
// 示例 3:
//
//
//输入: temperatures = [30,60,90]
//输出: [1,1,0]
//
//
//
// 提示：
//
//
// 1 <= temperatures.length <= 10⁵
// 30 <= temperatures[i] <= 100
//
//
// Related Topics 栈 数组 单调栈 👍 1367 👎 0

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int lens = temperatures.length;
            int[] res = new int[lens];

            /**
             如果当前遍历的元素 大于栈顶元素，表示 栈顶元素的 右边的最大的元素就是 当前遍历的元素，
             所以弹出 栈顶元素，并记录
             如果栈不空的话，还要考虑新的栈顶与当前元素的大小关系
             否则的话，可以直接入栈。
             注意，单调栈里 加入的元素是 下标。
             */
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i <lens ; i++) {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
            return res;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
