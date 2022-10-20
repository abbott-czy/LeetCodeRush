package spiralmatrix;

import java.util.Arrays;
import java.util.HashMap;

/*
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
限制：

0 <= matrix.length <= 100
0 <= matrix[i].length <= 100
 */
public class SpiralOrderJZOffer29 {

    public static int[] spiralOrder(int[][] matrix) {
         int row = matrix.length;
         if (row == 0){
             return  new int[0];
         }
         int col = matrix[0].length;
         int[] res = new int[row * col];
         int idx = 0;
         int left = 0;
         int top = 0;
         int right = col -1;
         int bottom = row -1;
         while (true){
             for (int i = left; i <= right ; i++) {
                 res[idx++] = matrix[top][i];
             }
             if (++top > bottom){
                 break;
             }
             //从上往下
             for (int i = top;i<= bottom; i ++){
                 res[idx++] = matrix[i][right];
             }
             if (--right < left)
                 break;;
             for (int i = right; i >=left ; i--) {
                 res[idx++] = matrix[bottom][i];
             }
             if (--bottom < top)
                 break;
             for (int i = bottom; i >=top ; i--) {
                 res[idx++] = matrix[i][left];
             }
             if (++left > right){
                 break;
             }

         }
         return res;

    }

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
//        int[][] matrix = new int[][]{{3},{2}};
//        int[][] matrix = new int[][]{};
//        int[][] matrix = new int[][]{{2,5,8},{4,0,-1}};
//        int[][] matrix = new int[][]{{2,3,4},{5,6,7},{8,9,10},{11,12,13}};
        int[][] matrix = new int[][]{{2,3,4},{5,6,7},{8,9,1},{11,12,13},{14,15,16}};
        int[] ints = spiralOrder(matrix);
        System.out.println(Arrays.toString(ints));

    }
}
