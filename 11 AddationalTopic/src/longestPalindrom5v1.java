public class longestPalindrom5v1 {
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
            if (s.length()<=1) return s;
            int length = 1;
            int index= 0;
            boolean[][] palindrome = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                palindrome[i][i]= true;
            }
            for (int L = 2; L <= s.length() ; L++) {
                for (int i = 0; i < s.length(); i++) {
                    int j = i + L - 1;
                    if (j>=s.length())
                        break;
                    if (s.charAt(i) != s.charAt(j)){
                        palindrome[i][j] = false;
                    }else {
                        if (j-i < 3){
                            palindrome[i][j] = true;
                        }else {
                            palindrome[i][j] = palindrome[i+1][j-1];
                        }
                    }
                    if (palindrome[i][j] && j-i +1 > length){
                        length = j-i +1;
                        index= i;
                    }
                }
            }
            return s.substring(index,index+length);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
