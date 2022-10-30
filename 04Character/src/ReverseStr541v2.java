public class ReverseStr541v2 {


/*
给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
提示：
1 <= s.length <= 104
s 仅由小写英文组成
1 <= k <= 104
Related Topics
双指针
字符串
 */
    public static String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i += 2*k) {
            int start = i;
            int end = Math.min(ch.length -1 ,  start +  k - 1);
            // 用异或运算符运算

            while (start <end){
                char tem = ch[start];
                ch[start] =ch[end];
                ch[end] = tem;
                start++;
                end--;
            }
        }
        return new String(ch);
    }

/*
示例 1：
输入：s = "abcdefg", k = 2
输出："bacdfeg"
示例 2：
输入：s = "abcd", k = 2
输出："bacd"
 */
    public static void main(String[] args) {
//        String s = "abcdefg";
        String s = "abcdefg";
        int k = 3;
        String s1 = reverseStr(s, k);
        System.out.println(s1.toString());
    }
}
