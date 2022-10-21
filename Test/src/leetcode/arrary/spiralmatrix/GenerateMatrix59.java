package leetcode.arrary.spiralmatrix;


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

public class GenerateMatrix59 {

    public static int[][] generateMatrix(int n) {
        int[][] ints = new int[n][n];
        int count = 1;
        int i,j;
        int start = 0;
        int loop = 0;

        while (loop++ < n / 2){
            // 从左到右
            for (j = start; j < n - loop; j++ ){
                ints[start][j] = count++;
            }
            System.out.println(Arrays.deepToString(ints));

            //从右到下
            for (i = start; i < n - loop; i++ ){
                ints[i][j] = count++;
            }
            //从右到左
            for (; j >= loop; j--){
                ints[i][j] = count++;
            }
            for (;i >= loop; i--){
                ints[i][j] = count++;
            }
            start++;
            }
        if (n % 2 == 1) {
            ints[start][start] = count;
        }




    return ints;
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
