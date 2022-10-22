package alphaticeectopic;

import java.util.*;

/*
给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
提示:
1 <= s.length, p.length <= 3 * 104
s 和 p 仅包含小写字母
Related Topics
哈希表
字符串
滑动窗口
 */

public class FindAnagrams438v2 {
    //    执行耗时:1791 ms,击败了5.63% 的Java用户
//    内存消耗:42.9 MB,击败了10.39% 的Java用户
    public static List<Integer> findAnagrams(String s, String p) {
        int[] s_count = new int[26];
        int[] p_count = new int[26];

        List<Integer> ans = new ArrayList<>();
        int left = 0, right = -1;
        if (s.length() < p.length())
            return ans;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            char cs = s.charAt(i);
            p_count[c-'a']++;
            s_count[cs-'a']++;
            right++;
        }

        if (Arrays.equals(s_count,p_count)){
            ans.add(left);
        }

        while (right < s.length()-1){
            s_count[s.charAt(left) - 'a']--;
            left++;

            right++;
            s_count[s.charAt(right) - 'a']++;

            if (Arrays.equals(s_count,p_count)){
                ans.add(left);
            }

        }
        return ans;
    }
    /*
    输入: s = "cbaebabacd", p = "abc"
    输出: [0,6]
    解释:
    起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
    起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。

    输入: s = "abab", p = "ab"
    输出: [0,1,2]
    解释:
    起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
    起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
    起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
     */
    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println(Arrays.toString(anagrams.toArray()));

    }
}
