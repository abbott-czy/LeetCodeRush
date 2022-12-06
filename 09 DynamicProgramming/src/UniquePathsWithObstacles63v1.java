public class UniquePathsWithObstacles63v1 {
    //一个机器人位于一个
// m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。
//
//
//
// 示例 1：
//
//
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
//
//
// 示例 2：
//
//
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
//
//
//
//
// 提示：
//
//
// m == obstacleGrid.length
// n == obstacleGrid[i].length
// 1 <= m, n <= 100
// obstacleGrid[i][j] 为 0 或 1
//
//
// Related Topics 数组 动态规划 矩阵 👍 922 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            // 如果第一位就是障碍，那么直接返回0
            if (obstacleGrid[0][0] == 1)
                return 0;
            int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    // 如果不是障碍
                    if (obstacleGrid[i][j] != 1) {
                        // 当（0，0）位不是障碍时，到（0，0）的路径总数为1
                        if (i == 0 && j == 0) {
                            dp[0][0] = 1;
                            continue;
                        }
                        if (i == 0) {
                            //（0，x）为第一行路径，其路径总数与其左边路径总数相等
                            dp[0][j] = dp[0][j - 1];
                        } else if (j == 0) {
                            //（x，0）为第一列路径，其路径总数与其上边路径总数相等
                            dp[i][0] = dp[i - 1][0];
                        } else {
                            // 其余路径总数，符合转移方程
                            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                        }
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
            return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
