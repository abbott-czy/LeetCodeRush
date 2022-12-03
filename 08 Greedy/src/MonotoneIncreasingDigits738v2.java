//当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
//
// 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
//
//
//
// 示例 1:
//
//
//输入: n = 10
//输出: 9
//
//
// 示例 2:
//
//
//输入: n = 1234
//输出: 1234
//
//
// 示例 3:
//
//
//输入: n = 332
//输出: 299
//
//
//
//
// 提示:
//
//
// 0 <= n <= 10⁹
//
//
// Related Topics 贪心 数学 👍 315 👎 0

import java.util.LinkedList;
import java.util.List;

public class MonotoneIncreasingDigits738v2 {
    public static int monotoneIncreasingDigits(int n) {
        String[] strings = (n+"").split("");
        int start = strings.length;
        for (int i = strings.length - 1; i > 0 ; i--) {
            if (Integer.parseInt(strings[i]) < Integer.parseInt(strings[i-1]) ){
                strings[i-1]  = (Integer.parseInt(strings[i-1]) - 1) + "";
                start = i;
            }
        }
        for (int i = start ; i < strings.length; i++ ){
            strings[i] = "9";
        }
        return  Integer.parseInt(String.join("",strings));

    }

    public static void main(String[] args) {
        int n = 1234;
        int i = monotoneIncreasingDigits(n);
        System.out.println(i);

    }
}
