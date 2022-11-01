/*
给你一个字符串 s ，请你反转字符串中 单词 的顺序。
单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
提示：
1 <= s.length <= 104
s 包含英文大小写字母、数字和空格 ' '
s 中 至少存在一个 单词
进阶：如果字符串在你使用的编程语言中是一种可变数据类型，请尝试使用 O(1) 额外空间复杂度的 原地 解法。
Related Topics
双指针
字符串
 */
public class ReverseWords151v2 {
/*
解法二：创建新字符数组填充。时间复杂度为O（n）
 */
    public static String reverseWords(String s) {
       char[]  initialArr = s.toCharArray();
       //新字符数组
       char[]  newArr = new char[initialArr.length+1];
       int newArrPos=0;
        //i来进行整体对源字符数组从后往前遍历
       int i = initialArr.length-1;
       while (i >=0){
           while (i>=0 && initialArr[i] == ' '){ i--;} //跳过空格
           //此时i位置是边界或!=空格，先记录当前索引，之后的while用来确定单词的首字母的位置
           int right = i;
           while (i>=0 && initialArr[i] != ' ' ){i--;}
           //指定区间单词取出(由于i为首字母的前一位，所以这里+1,)，取出的每组末尾都带有一个空格
           for (int j = i+1; j <= right ; j++) {
               newArr[newArrPos++] = initialArr[j];
               if (j == right){
                   newArr[newArrPos++] = ' ';
               }
           }

       }
       if (newArrPos==0){
           return "";
       }else {
           return new String(newArr,0,newArrPos-1);
       }

    }


/*
示例 1：
输入：s = "the sky is blue"
输出："blue is sky the"
示例 2：
输入：s = "  hello world  "
输出："world hello"
解释：反转后的字符串中不能存在前导空格和尾随空格。
示例 3：
输入：s = "a good   example"
输出："example good a"
解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 */
    public static void main(String[] args) {
        String s = "the sky is blue";
        String s1 = reverseWords(s);
        System.out.println(s1);
    }
}
