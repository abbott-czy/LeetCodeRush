//n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
//
// 你需要按照以下要求，给这些孩子分发糖果：
//
//
// 每个孩子至少分配到 1 个糖果。
// 相邻两个孩子评分更高的孩子会获得更多的糖果。
//
//
// 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
//
//
//
// 示例 1：
//
//
//输入：ratings = [1,0,2]
//输出：5
//解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
//
//
// 示例 2：
//
//
//输入：ratings = [1,2,2]
//输出：4
//解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
//
//
//
// 提示：
//
//
// n == ratings.length
// 1 <= n <= 2 * 10⁴
// 0 <= ratings[i] <= 2 * 10⁴
//
//
// Related Topics 贪心 数组 👍 1051 👎 0

public class Candy135v1 {
/*
	执行耗时:3 ms,击败了30.66% 的Java用户
	内存消耗:42 MB,击败了62.59% 的Java用户
 */
    public  static int candy(int[] ratings) {
        if (ratings.length == 1)
            return 1;

        int sum = 1;
        int[] every = new int[ratings.length];
        every[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1] ){
                every[i] = every[i-1] + 1;
            }else {
                every[i] = 1;
            }
            sum += every[i];
        }
        System.out.println(sum);
        for (int i = ratings.length - 2; i >=0 ; i--) {
            if (ratings[i] > ratings[i + 1]  && every[i] <= every[i+1]){
                int tem = every[i];
                every[i] = every[i + 1] + 1;
                sum += every[i] - tem;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
//        int[] ratings = {1,2,87,87,87,2,1};
        int[] ratings = {1,3,4,5,2};
        int candy = candy(ratings);
        System.out.println(candy);
    }
}
