import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveNQueens51v1 {

    //按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
//
//
//
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
//
//
//
//
// 示例 1：
//
//
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：[["Q"]]
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
// Related Topics 数组 回溯 👍 1563 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<String>> res= new ArrayList<>();
        public List<List<String>> solveNQueens(int n) {
            char[][] path = new char[n][n];
            for (char[] c : path){
                Arrays.fill(c,'.');
            }
            backTracking(n,0,path);
            return res;
        }

        public void backTracking(int n,int row, char[][] path){
            if (row == n){
                List<String> list = new ArrayList<>();
                for (char[] c : path){
                    list.add(String.copyValueOf(c));
                }
                res.add(list);
                return;
            }

            for (int col = 0; col < n; col++) {
                if (isValid(row,col,n,path)){
                    path[row][col] = 'Q';
                    backTracking(n,row+1,path);
                    path[row][col] = '.';
                }
            }
        }

        public boolean isValid(int row, int col, int n, char[][] path){
            for (int i = 0; i < row; i++) {
                if (path[i][col] == 'Q')
                    return false;
            }

            for (int i = row-1, j = col -1 ; i>=0&&j>=0; i--, j--){
                if (path[i][j] == 'Q')
                    return false;
            }

            for (int i = row-1,  j = col +1 ;  i>=0 && j <=n-1;i--,j++){
                if (path[i][j] == 'Q')
                    return false;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
