package alphaticeectopic;

import java.util.Arrays;

/*
给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
如果可以，返回 true ；否则返回 false 。
magazine 中的每个字符只能在 ransomNote 中使用一次。

提示：
1 <= ransomNote.length, magazine.length <= 105
ransomNote 和 magazine 由小写英文字母组成
Related Topics
哈希表
字符串
计数
 */
public class CanConstruct383v1 {

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] nums = new int[26];
        for (int i =0 ; i < magazine.length();i++){
            int idx = magazine.charAt(i) - 'a';
            nums[idx] +=1;
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0 ; i < ransomNote.length();i++){
            int idx = ransomNote.charAt(i) - 'a';
            nums[idx] -= 1;
        }
        for (int i = 0 ; i < nums.length;i++){
            if (nums[i] < 0 )
                return false;
        }

        return  true;
    }

/*
输入：ransomNote = "a", magazine = "b"
输出：false
输入：ransomNote = "aa", magazine = "ab"
输出：false
输入：ransomNote = "aa", magazine = "aab"
输出：true
 */
    public static void main(String[] args) {
//        String  ransomNote = "aa";
//        String  magazine = "aab";
        String  ransomNote = "a";
        String  magazine = "b";
        boolean b = canConstruct(ransomNote, magazine);
        System.out.println(b);


    }
}
