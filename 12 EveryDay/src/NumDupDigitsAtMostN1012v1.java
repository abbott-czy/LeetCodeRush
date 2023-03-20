import java.util.Arrays;

public class NumDupDigitsAtMostN1012v1 {
    //给定正整数 n，返回在 [1, n] 范围内具有 至少 1 位 重复数字的正整数的个数。
//
//
//
// 示例 1：
//
//
//输入：n = 20
//输出：1
//解释：具有至少 1 位重复数字的正数（<= 20）只有 11 。
//
//
// 示例 2：
//
//
//输入：n = 100
//输出：10
//解释：具有至少 1 位重复数字的正数（<= 100）有 11，22，33，44，55，66，77，88，99 和 100 。
//
//
// 示例 3：
//
//
//输入：n = 1000
//输出：262
//
//
//
//
// 提示：
//
//
// 1 <= n <= 10⁹
//
//
// Related Topics 数学 动态规划 👍 172 👎 0



    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        char s[];
        int dp[][];
        public int numDupDigitsAtMostN(int n) {
            s = Integer.toString(n).toCharArray();
            int m =s.length;
            dp = new int[m][1<<10];
            for (int i = 0; i < m; i++) {
                Arrays.fill(dp[i],-1); // -1 表示没有计算过
            }
            return n - f(0,0,true,false);

        }
        // i为从低位开始的合法方案
        // mask 表示前面选过的数字集合，第i位要选的数字不能在mask里。
        // isLimit：表示当前是否受到n的约束。若为真，则第i位填入的数字至多为s[i]，否则可以为9.
        // isNum：i前面的数位是否填了数字，若为假，则当前位可以跳过(不填数字)，或者要填入的数字至少为1，
        // 若为真，则要填入的数字可以从0开始
        int f(int i, int mask, boolean isLimit, boolean isNum){
            if (i == s.length){
                return isNum ? 1 :  0 ;// isNum为true表示得到一个合法的数字
            }
            if ( !isLimit && isNum && dp[i][mask]!= -1){
                return dp[i][mask];
            }
            int res = 0;
            if(!isNum) // 可以跳过当前数位
                res = f(i+1,mask,false,false);
            int up = isLimit? s[i] - '0' : 9  ;// 如果前面填的数字和n的意义，那么这一位至多填数字s[i]
            for(int d = isNum? 0 : 1; d<= up; ++d){
                if ((mask >> d & 1) == 0){ // d不在mask中
                    res += f(i+1,mask|(1<<d),isLimit&& d == up, true);
                }
            }
            if (!isLimit && isNum)
                dp[i][mask]= res;
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
