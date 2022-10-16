package BinarySearch;

/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 * 提示：
 * 0 <= x <= 231 - 1
 * Related Topics
 * 数学
 * 二分查找
 */

public class MySqrt69v1 {
    public static int mySqrt(int x) {
        if (x == 1 || x == 0){
            return x;
        }
        int left = 1;
        int right = x;
        while (left < right){
            int mid = left + ((right - left) >> 1);

            if ( x / mid   == mid){
                return  mid;
            }
            if ( x / mid  > mid   &&  x / (mid + 1) < (mid + 1)){
                return mid;
            }

            if (x / mid < mid){
                right = mid;
            }
            if (x / mid > mid ){
                left = mid + 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {

//        输入：x = 4
//        输出：2
//        示例 2：
//        输入：x = 8
//        输出：2
//
        int i = mySqrt(2147395599);
//        int i = mySqrt(9);
        System.out.println(i);
    }
}
