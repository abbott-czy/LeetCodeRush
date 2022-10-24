package happynumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
编写一个算法来判断一个数 n 是不是快乐数。

「快乐数」 定义为：

对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
如果这个过程 结果为 1，那么这个数就是快乐数。
如果 n 是 快乐数 就返回 true ；不是，则返回 false 。

提示：
1 <= n <= 231 - 1
Related Topics
哈希表
数学
双指针
 */
public class IsHappy202v1 {

    public static boolean isHappy(int n) {
        HashMap<Integer,Integer>  res = new HashMap<>();
        int sum = 0;
        while(n >= 1){
            if (n==1){
                return true;
            }
            List<Integer> tem = new ArrayList<>();
            while(n > 0){
                tem.add(n%10);
                n  = n / 10;
            }

            for (int i : tem ) {
                sum += i * i;
            }

            if (res.containsKey(sum)){
                return false;
            }else {
                res.put(sum,res.getOrDefault(sum,0)+1);
            }
            n = sum;
            sum = 0;
            System.out.println(n);

        }

        return false;
    }

/*
示例 1：
输入：n = 19
输出：true
解释：
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
示例 2：
输入：n = 2
输出：false
 */
    public static void main(String[] args) {
        int n = 2;
        boolean happy = isHappy(n);
        System.out.println(happy);
    }
}
