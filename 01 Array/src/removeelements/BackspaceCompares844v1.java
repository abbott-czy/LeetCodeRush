package removeelements;

import java.util.Arrays;
import java.util.List;
import java.util.PropertyResourceBundle;

/**
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * 1 <= s.length, t.length <= 200
 * s 和 t 只含有小写字母以及字符 '#'
 * 进阶：
 *
 * 你可以用 O(n) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 * Related Topics
 * 栈
 * 双指针
 * 字符串
 * 模拟

 */

// 用StringBuilder模拟栈的实现
public class BackspaceCompares844v1 {

    public static boolean backspaceCompare(String s, String t) {
        StringBuilder  ssb = new StringBuilder();
        StringBuilder  sst = new StringBuilder();
        for(char c : s.toCharArray()){
            if (c != '#'){
                ssb.append(c);
            }else if (ssb.length() > 0){
                ssb.deleteCharAt(ssb.length() - 1);
            }
        }

        for(char c : t.toCharArray()){
            if (c != '#'){
                sst.append(c);
            }else if (sst.length() > 0){
                sst.deleteCharAt(sst.length() - 1);
            }
        }
        return ssb.toString().equals(sst.toString());
    }


//            * 输入：s = "ab#c", t = "ad#c"
//            * 输出：true
//            * 解释：s 和 t 都会变成 "ac"。
//            * 输入：s = "ab##", t = "c#d#"
//            * 输出：true
//            * 解释：s 和 t 都会变成 ""。
//            * 输入：s = "a#c", t = "b"
//            * 输出：false
//            * 解释：s 会变成 "c"，但 t 仍然是 "b"。
    public static void main(String[] args) {
//        String s = "ab#c";
//        String t = "ad#c";
//        String s = "ab##";
//        String t = "";
        String s = "a##c";
        String t = "#a#c";
        boolean b = backspaceCompare(s, t);
        System.out.println(b);


    }
}
