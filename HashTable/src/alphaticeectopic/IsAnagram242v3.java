package alphaticeectopic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

// 用map来解决
public class IsAnagram242v3 {

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : t.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) {
                return false;
            } else if (count > 1) {
                map.put(ch, count - 1);
            } else {
                map.remove(ch);
            }
        }
        return map.isEmpty();
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
