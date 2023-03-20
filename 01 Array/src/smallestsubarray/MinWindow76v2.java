package smallestsubarray;

import java.util.*;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 提示
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 * Related Topics
 * 哈希表
 * 字符串
 * 滑动窗口
 */

public class MinWindow76v2 {

    public static  String minWindow(String s, String t) {
       if ( s.length() < t.length()){
           return "";
       }

       int left = 0;
       int right = 0;
       int minLen = Integer.MAX_VALUE;
       int minleft = 0;
       int vaild = 0;
       Map<Character,Integer> window = new HashMap<>();
       Map<Character,Integer> need = new HashMap<>();

       for(int i=0; i < t.length(); i++){
           need.put(t.charAt(i),need.getOrDefault(t.charAt(i),0)+1);
       }
        System.out.println(need);


       while(right < s.length()){
           char ch = s.charAt(right);
           window.put(ch,window.getOrDefault(ch,0)+1);
           right++;

           if (window.get(ch).equals(need.get(ch)) ){
               vaild++;
           }

           while (vaild == need.size()){
               if (right - left < minLen){
                   minLen = right - left;
                   minleft = left;
               }
               //缩小左边界
               char c = s.charAt(left);
               if (window.get(c).equals(need.get(c))){
                   vaild--;
               }
               window.put(c,window.get(c)-1);
               left++;
           }

       }
       return minLen == Integer.MAX_VALUE? "" : s.substring(minleft,minleft + minLen);

    }


    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String s1 = minWindow(s, t);
        System.out.println(s1);
    }
    /*
     * 示例 1：
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * 示例 2：
     * 输入：s = "a", t = "a"
     * 输出："a"
     * 示例 3:
     * 输入: s = "a", t = "aa"
     * 输出: ""
     * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
     * 因此没有符合条件的子字符串，返回空字符串。
     */


}
