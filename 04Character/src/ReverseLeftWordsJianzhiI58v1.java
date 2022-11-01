public class ReverseLeftWordsJianzhiI58v1 {
/*
字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，
输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
限制：
1 <= k < s.length <= 10000
Related Topics
数学
双指针
字符串
 */
    public static String reverseLeftWords(String s, int n) {
        String tem = s.substring(0,n);
        int count = 0;
        int left = 0;
        char[] chars = s.toCharArray();
        while (n < s.length()){
            chars[left] = chars[n];
            left++;
            n++;
        }
        while (left < s.length()){
            chars[left] = tem.charAt(count++);
            left++;
        }

        return new String(chars);

    }
/*
示例 1：
输入: s = "abcdefg", k = 2
输出: "cdefgab"
示例 2：
输入: s = "lrloseumgh", k = 6
输出: "umghlrlose"
 */
    public static void main(String[] args) {
        String s = "abcdefg";
        int n = 2;
        String s1 = reverseLeftWords(s, n);
        System.out.println(s1);
    }

}
