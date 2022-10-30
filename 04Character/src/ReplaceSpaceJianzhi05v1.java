public class ReplaceSpaceJianzhi05v1 {

/*
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
示例 1：
输入：s = "We are happy."
输出："We%20are%20happy."
限制：
0 < s 的长度 <= 10000
Related Topics
字符串

执行耗时:0 ms,击败了100.00% 的Java用户
内存消耗:39.2 MB,击败了75.20% 的Java用户
用的StringBuidler
 */
    public static String replaceSpace(String s) {
        if (s == null)
            return null;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
/*
输入：s = "We are happy."
输出："We%20are%20happy."
 */
    public static void main(String[] args) {
        String s = "We are happy.";
        String s1 = replaceSpace(s);
        System.out.println(s);
    }
}
