import java.util.Map;

public class StrStr28v1 {
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

            if (needle.length() > haystack.length())
                return -1;
            if (needle.length() == haystack.length()){
                if (haystack.equals(needle)){
                    return 0;
                }else
                    return -1;
            }

            char[] target = haystack.toCharArray();
            char[] need = needle.toCharArray();
            int left = 0;
            int right = haystack.length() ;
            int  res;
            int current = 0;



            while (left < right){
                if (target[left] == need[current]){
                    if (need.length == 1 )
                        return left;
                    if (left == right -1 )
                        return -1;
                    int currentLeft = left+ 1;
                    current++;
                    res = left;
                    while (current < need.length){
                        if (currentLeft == right)
                            return -1;

                        if (target[currentLeft] != need[current]){
                            current = 0;
                            break;
                        }
                        currentLeft++;
                        current++;
                       if (current == need.length )
                           return res;

                    }
                }
                left++;
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
