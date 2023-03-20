public class MaxValuejianzhi47v1 {
    //在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直
//到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
//
//
//
// 示例 1:
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 12
//解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
//
//
//
// 提示：
//
//
// 0 < grid.length <= 200
// 0 < grid[0].length <= 200
//
//
// Related Topics 数组 动态规划 矩阵 👍 386 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxValue(int[][] grid) {


            // 1. 确定dp数组 dp[n][n] 每个位置的最大价值，返回dp[n-1][n-1]
            // 2. 确定递推公式： dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]) + grip[i][j]
            // 3. 初始化 dp[i][j] = grid[i][j]
            // 4. 确认遍历顺序： for(i=1;i<= grid.length-1;i++): for(i = 1; j <= grid.length-1;j++)

            if (grid == null || grid.length == 0){
                return 0;
            }
            int n = grid.length;
            int m = grid[0].length;
            int[][] dp = new int[n][m];
            dp[0][0] = grid[0][0];
            for (int i = 1; i < n; i++) {
                dp[i][0] = dp[i-1][0] +grid[i][0];
            }
            for (int i = 1; i < m; i++) {
                dp[0][i] = dp[0][i-1] +grid[0][i];
            }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.println(dp[i][j]);
//            }
//        }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j <m; j++) {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]) + grid[i][j];
                }
            }

            return dp[n-1][m-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//
//解答成功:
//        执行耗时:2 ms,击败了97.82% 的Java用户
//        内存消耗:43.8 MB,击败了85.74% 的Java用户
