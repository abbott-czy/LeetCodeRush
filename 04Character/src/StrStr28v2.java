public class StrStr28v2 {
/*
给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
如果 needle 不是 haystack 的一部分，则返回 -1 。
提示：
1 <= haystack.length, needle.length <= 104
haystack 和 needle 仅由小写英文字符组成
Related Topics
双指针
字符串
字符串匹配
 */
        public static int strStr(String haystack, String needle) {
            /**
             * 基于窗口滑动的算法
             * <p>
             * 时间复杂度：O(m*n)
             * 空间复杂度：O(1)
             * 注：n为haystack的长度，m为needle的长度
             */

            int m = needle.length();
            // 当 needle 是空字符串时我们应当返回 0
            if (m == 0) {
                return 0;
            }
            int n = haystack.length();
            if (n < m) {
                return -1;
            }
            int i = 0;
            int j = 0;
            while (i < n - m + 1) {
                // 找到首字母相等
                while (i < n && haystack.charAt(i) != needle.charAt(j)) {
                    i++;
                }
                if (i == n) {// 没有首字母相等的
                    return -1;
                }
                // 遍历后续字符，判断是否相等
                i++;
                j++;
                while (i < n && j < m && haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                }
                if (j == m) {// 找到
                    return i - j;
                } else {// 未找到
                    i -= j - 1;
                    j = 0;
                }
            }
            return -1;

        }

/*
示例 1：
输入：haystack = "sadbutsad", needle = "sad"
输出：0
解释："sad" 在下标 0 和 6 处匹配。
第一个匹配项的下标是 0 ，所以返回 0 。
示例 2：
输入：haystack = "leetcode", needle = "leeto"
输出：-1
解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 */
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "sippia";
        int i = strStr(haystack, needle);
        System.out.println(i);
    }
}
