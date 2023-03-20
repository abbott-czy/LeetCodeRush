package spiralmatrix;

//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
//
//
// 示例 2：
//
//
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100
//
//
// Related Topics 数组 矩阵 模拟 👍 1238 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        System.out.println();
        int row = matrix.length;
        if (row == 0){
            return  res;
        }
        int col = matrix[0].length;

        int idx = 0;
        int left = 0;
        int top = 0;
        int right = col -1;
        int bottom = row -1;
        while (true){
            for (int i = left; i <= right ; i++) {
                res.add(matrix[top][i]);
            }
            if (++top > bottom){
                break;
            }
            //从上往下
            for (int i = top;i<= bottom; i ++){
                res.add(matrix[i][right]);
            }
            if (--right < left)
                break;;
            for (int i = right; i >=left ; i--) {
                res.add(matrix[bottom][i]);
            }
            if (--bottom < top)
                break;
            for (int i = bottom; i >=top ; i--) {
                res.add(matrix[i][left]);
            }
            if (++left > right){
                break;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{2,3,4},{5,6,7},{8,9,1},{11,12,13},{14,15,16}};
        List<Integer> integers = spiralOrder(matrix);
        for(int i : integers){
            System.out.println(i);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
