public class ReverseStr541v1 {
//    执行耗时:2 ms,击败了14.56% 的Java用户
//    内存消耗:41.8 MB,击败了6.41% 的Java用户


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
        char[] ss = s.toCharArray();
        int ssLen = ss.length;
        int left;
        int right;
        int iter;
        int lastss = 0;
        int count = 0;
        if (ssLen % (2 * k) == 0 ){
            iter =  ssLen / (2 * k);

        }
        else {
            iter =  ssLen / (2 * k) + 1 ;
            lastss = ssLen % (2 * k);
        }
        System.out.println(iter);


        while(count < iter){
            left =  count * 2 * k;
           if ((count == iter - 1) && lastss < k && lastss > 0 ){
               right = count * 2 * k + lastss - 1;
           }else {
               right = left + k - 1;
           }

            while (left <right){
                char tem = ss[left];
                ss[left] = ss[right];
                ss[right] = tem;
                left++;
                right--;
            }
            count++;

       }

        return new String(ss);
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
