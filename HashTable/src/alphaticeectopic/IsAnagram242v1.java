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

//hashtable，数组其实就是一个简单哈希表，而且这道题目中字符串只有小写字符，那么就可以定义一个数组，来记录字符串s里字符出现的次数。
//需要定义一个多大的数组呢，定一个数组叫做record，大小为26 就可以了，初始化为0，因为字符a到字符z的ASCII也是26个连续的数值。
public class IsAnagram242v1 {

    public static boolean isAnagram(String s, String t) {
        int[] nums = new int[26];
        for (int i =0 ; i < s.length();i++){
            int idx = s.charAt(i) - 'a';
            nums[idx] +=1;
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0 ; i < t.length();i++){
            int idx = t.charAt(i) - 'a';
            nums[idx] -= 1;
        }
        for (int i = 0 ; i < nums.length;i++){
            if (nums[i] != 0 )
                return false;
        }

            return  true;
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
