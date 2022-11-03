import java.util.Stack;

public class RemoveDuplicates1047v1 {
/*
给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
在 S 上反复执行重复项删除操作，直到无法继续删除。
在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
提示：
1 <= S.length <= 20000
S 仅由小写英文字母组成。
Related Topics
栈
字符串

执行耗时:102 ms,击败了34.77% 的Java用户
内存消耗:42.2 MB,击败了48.56% 的Java用户
 */
    public  static  String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
            }else if (ch == stack.peek()){
                stack.pop();
            }else {
                stack.push(ch);
            }
        }

        if (stack.isEmpty())
            return "";
        else{
            while (!stack.isEmpty()){
                sb.append(stack.peek());
                stack.pop();
            }
            sb.reverse();
            return new String(sb);
        }
    }
    /*

输入："abbaca"
输出："ca"
解释：
例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。

     */
    public static void main(String[] args) {
        String s = "abbaca";
        String s1 = removeDuplicates(s);
        System.out.println(s1);
    }
}
