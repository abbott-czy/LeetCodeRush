public class ReplaceSpaceJianzhi05v2 {

/*
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
示例 1：
输入：s = "We are happy."
输出："We%20are%20happy."
限制：
0 < s 的长度 <= 10000
Related Topics
字符串


 */
    public static String replaceSpace(String s) {

        if (s == null || s.length() == 0)
            return null;

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                str.append("  ");
            }
        }

        if (str.length() == 0)
            return s;

        int left = s.length() - 1;
        s += str.toString();
        int right = s.length() - 1;
        char[]  ch = s.toCharArray();
        while (left >=0){
            if (ch[left] == ' '){
                ch[right--] = '0';
                ch[right--] = '2';
                ch[right] = '%';
            }else {
                ch[right] = ch[left];
            }
            left--;
            right--;
        }
        return new String(ch);
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
