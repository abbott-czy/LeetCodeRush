public class MinCut132v1 {
    //给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
//
// 返回符合要求的 最少分割次数 。
//
//
//
//
//
//
//
// 示例 1：
//
//
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
//
//
// 示例 2：
//
//
//输入：s = "a"
//输出：0
//
//
// 示例 3：
//
//
//输入：s = "ab"
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 2000
// s 仅由小写英文字母组成
//
//
// Related Topics 字符串 动态规划 👍 649 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCut(String s) {
            if (s == null || "".equals(s)){
                return 0;
            }
            int len = s.length();
            // 1. 记录子串[i,,j]是否是回文串
            boolean[][] isPalindromic = new boolean[len][len];
            for (int i = len -1; i >=0 ; i--) {
                for (int j = i; j < len; j++) {
                    if (s.charAt(i) == s.charAt(j)){
                        if (j-i <=1){
                            isPalindromic[i][j] = true;
                        }else {
                            isPalindromic[i][j] = isPalindromic[i+1][j-1];
                        }
                    }else {
                        isPalindromic[i][j] = false;
                    }
                }
            }
            //2. dp[i] 表示[0...i]的最小分隔次数
            int[] dp = new int[len];
            for (int i = 0; i < len; i++) {
                dp[i] = i;
            }

            for (int i = 1; i < len ; i++) {
                if (isPalindromic[0][i]){
                    dp[i]=0;
                    continue;
                }
                for (int j = 0; j < i; j++) {
                    if (isPalindromic[j+1][i]){
                        dp[i] = Math.min(dp[i],dp[j]+1);
                    }
                }
            }
            return dp[len-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
