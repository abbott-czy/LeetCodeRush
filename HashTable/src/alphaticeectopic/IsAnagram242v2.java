package alphaticeectopic;

import java.util.Arrays;

/*
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
提示:
1 <= s.length, t.length <= 5 * 104
s 和 t 仅包含小写字母
进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

Related Topics
哈希表
字符串
排序
 */

// 用java数组的内置排序
public class IsAnagram242v2 {

    public static boolean isAnagram(String s, String t) {
      char[] sChars = s.toCharArray();
      char[] tChars = t.toCharArray();
      Arrays.sort(sChars);
      Arrays.sort(tChars);
      return Arrays.equals(sChars,tChars);
    }
    /*
    示例 1:
    输入: s = "anagram", t = "nagaram"
    输出: true
    示例 2:
    输入: s = "rat", t = "car"
    输出: false
     */
    public static void main(String[] args) {
//        String s = "anagram";
//        String t = "nagaram";
        String s = "rat";
        String t = "car";
        boolean anagram = isAnagram(s, t);
        System.out.println(anagram);



    }
}
