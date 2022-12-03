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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MonotoneIncreasingDigits738v1 {
    public static int monotoneIncreasingDigits(int n) {
        List<Integer> list = new LinkedList<>();
        while(n != 0){
            list.add(n%10);
            n = n / 10 ;
        }
        System.out.println(list.toString());
        if (list.size() == 1)
            return list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > list.get(i-1)){
                list.set(i,list.get(i)- 1);
                list.set(i-1,9);
                for (int j = 0; j < i-1; j++) {
                    list.set(j,9);
                }
            }
        }
        int res= 0;
        for (int i = 0; i < list.size(); i++) {
            res += Math.pow(10,i) * list.get(i);
        }

        return res;

    }

    public static void main(String[] args) {
        int n = 1234;
        int i = monotoneIncreasingDigits(n);
        System.out.println(i);

    }
}
