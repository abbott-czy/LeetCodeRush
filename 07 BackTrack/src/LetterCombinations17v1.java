import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations17v1 {

    //给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//
//
// 示例 1：
//
//
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//
//
// 示例 2：
//
//
//输入：digits = ""
//输出：[]
//
//
// 示例 3：
//
//
//输入：digits = "2"
//输出：["a","b","c"]
//
//
//
//
// 提示：
//
//
// 0 <= digits.length <= 4
// digits[i] 是范围 ['2', '9'] 的一个数字。
//
//
// Related Topics 哈希表 字符串 回溯 👍 2193 👎 0



    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> list = new ArrayList<>();
        public StringBuilder temp = new StringBuilder();
        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0 || digits == null)
                return list;

            String[] numString = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

            backTracking(digits,numString,0);
            return list;
        }

        public void backTracking(String digits,String[] numString,int num){
            if (num == digits.length()){
                list.add(temp.toString());
                return;
            }

            // 得到当前的字符的字符串
            String str = numString[digits.charAt(num) - '0'];
            for (int i = 0; i < str.length(); i++) {
                temp.append(str.charAt(i));
                backTracking(digits,numString,num+1);
                temp.deleteCharAt(temp.length() -1);
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
