import java.util.Arrays;

public class NumSquares279v1 {
    //给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
//
//
//
//
// 示例 1：
//
//
//输入：n = 12
//输出：3
//解释：12 = 4 + 4 + 4
//
// 示例 2：
//
//
//输入：n = 13
//输出：2
//解释：13 = 4 + 9
//
//
//
// 提示：
//
//
// 1 <= n <= 10⁴
//
//
// Related Topics 广度优先搜索 数学 动态规划 👍 1556 👎 0



    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares(int n) {
            int max = Integer.MAX_VALUE;
            int[] dp = new int[n+1];
            Arrays.fill(dp,max);

            dp[0] = 0;
            //先遍历物品，再遍历背包
            for (int i = 1; i * i <= n ; i++) {
                for (int j = i *i ; j <= n  ; j++) {
                    if (dp[j - i * i] != max){
                        dp[j] = Math.min(dp[j], dp[j - i * i] +1);
                    }
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
