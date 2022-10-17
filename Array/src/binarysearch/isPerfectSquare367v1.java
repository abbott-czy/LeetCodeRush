package binarysearch;

/**
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 进阶：不要 使用任何内置的库函数，如 sqrt 。
 * 1 <= num <= 2^31 - 1
 * Related Topics
 * 数学
 * 二分查找
 */

public class isPerfectSquare367v1 {

    public static boolean isPerfectSquare(int num) {

        if (num == 1) {
            return true;
        }
        int left = 1;
        int right = num;
        while (left < right) {
            int mid = (left + right) / 2;
            if (num / mid == mid && num % mid == 0) {
                return true;
            }
            if (num / mid == mid && num % mid != 0) {
                right = mid;
            } else if (num / mid > mid) {
                left = mid + 1;
            }
            if (num / mid < mid) {
                right = mid;
            }
        }
        return false;
    }


//   输入：num = 16
// * 输出：true
// * 输入：num = 14
// * 输出：false

    public static void main(String[] args) {
        int num = 16;
        boolean perfectSquare = isPerfectSquare(6);
        System.out.println(perfectSquare);
    }
}
