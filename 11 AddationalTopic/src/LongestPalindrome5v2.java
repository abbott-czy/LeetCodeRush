public class LongestPalindrome5v2 {
    //给你一个字符串 s，找到 s 中最长的回文子串。
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出："bb"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母组成
//
//
// Related Topics 字符串 动态规划 👍 6189 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            String s1 = "";
            String s2 = "";
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                //分两种情况，一个元素中心点，两个元素为中心点
                s1 = extend(s,i,i);
                res = s1.length() > res.length() ? s1 :res;
                s2 = extend(s,i,i+1);
                res = s2.length() > res.length() ?s2 : res;
            }
            return res;
        }
        public String extend(String s, int start, int end){
            String temp = "";
            while (start>=0 && end< s.length() && s.charAt(start) == s.charAt(end)){
                temp = s.substring(start,end+1);
                start--;
                end++;
            }
            return temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
