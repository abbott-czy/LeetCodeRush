import java.util.Arrays;

public class TotalNQueens52v1 {
    //n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
//
//
//
//
//
// 示例 1：
//
//
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
//
//
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= n <= 9
//
//
// Related Topics 回溯 👍 413 👎 0




    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int res = 0;
        public int totalNQueens(int n) {
            char[][] board = new char[n][n];
            for (char[] chars: board){
                Arrays.fill(chars,'.');
            }
            backTrack(n,0,board);
            return res;

        }

        private void backTrack(int n, int row, char[][] board){
            if (row == n){
                res++;
                return;
            }
            for (int col =0; col <n; col++){
                if (isValid(row,col,n,board)){
                    board[row][col] = 'Q';
                    backTrack(n,row+1,board);
                    board[row][col] = '.';
                }
            }
        }
        private boolean isValid(int row, int col, int n, char[][] board){
//        检查列
            for (int i = 0; i < row; ++i) {
                if (board[i][col] == 'Q'){
                    return false;
                }
            }
//        检查45°
            for(int i = row-1, j = col - 1; i>=0 &&j >= 0; i--,j--){
                if (board[i][j] == 'Q'){
                    return false;
                }
            }
//        检查135°
            for (int i = row-1,j=col+1;i>=0 && j<=n-1;i--,j++){
                if (board[i][j] == 'Q'){
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
