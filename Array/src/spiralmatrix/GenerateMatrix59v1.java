package spiralmatrix;

/*
给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
提示：
1 <= n <= 20
Related Topics
数组
矩阵
模拟
 */


import java.util.Arrays;

public class GenerateMatrix59v1 {

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int loop = 0;
        int start =0;  // 每次循环的开始点 (start，start)
        int count = 1; // 定义填充数字
        int i,j;
        while (loop++ < n/2){
            System.out.println(loop);

            //1. 从上到右
            for(j = start; j < n -loop; j++){
                matrix[start][j] = count++;
            }
            //2.从右到下
            for (i = start; i < n - loop; i++){
                matrix[i][j] = count++;
            }
            //3.从下到左
            for ( ; j >= loop; j--){
                matrix[i][j] = count++;
            }
            //4.从左到上
            for ( ; i >= loop; i--){
                matrix[i][j] = count++;
            }
            start++;
        }
        if (n % 2 == 1){
            matrix[start][start] =count;
        }

        return matrix;


    }

    /*
    示例 1：
    输入：n = 3
    输出：[[1,2,3],[8,9,4],[7,6,5]]
    示例 2：
    输入：n = 1
    输出：[[1]]
     */
    public static void main(String[] args) {
        int n =5;
        int[][] ints = generateMatrix(n);
        System.out.println(Arrays.deepToString(ints));

    }

}
