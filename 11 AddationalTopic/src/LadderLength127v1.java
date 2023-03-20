import java.util.*;

public class LadderLength127v1 {
    //字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列
// beginWord -> s1 -> s2 -> ... -> sk：
//
//
// 每一对相邻的单词只差一个字母。
//
// 对于 1 <= i <= k 时，每个
// si 都在
// wordList 中。注意， beginWord 不需要在
// wordList 中。
//
// sk == endWord
//
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列
//中的 单词数目 。如果不存在这样的转换序列，返回 0 。
//
// 示例 1：
//
//
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
//
//
// 示例 2：
//
//
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。
//
//
//
// 提示：
//
//
// 1 <= beginWord.length <= 10
// endWord.length == beginWord.length
// 1 <= wordList.length <= 5000
// wordList[i].length == beginWord.length
// beginWord、endWord 和 wordList[i] 由小写英文字母组成
// beginWord != endWord
// wordList 中的所有字符串 互不相同
//
//
// Related Topics 广度优先搜索 哈希表 字符串 👍 1206 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            HashSet<String> wordSet = new HashSet<>(wordList); // 转换为hashset速度比较快;
            if (wordSet.size() == 0 || !wordSet.contains(endWord)){
                return 0;
            }
            Queue<String> queue = new LinkedList<>(); //BFS队列
            queue.offer(beginWord);
            Map<String,Integer> map = new HashMap<>(); // 记录单词对应路径长度
            map.put(beginWord,1);

            while (!queue.isEmpty()){
                String word = queue.poll(); // 取出队头单词
                int path = map.get(word); // 获得该单词的路径长度
                for (int i = 0; i < word.length(); i++) {
                    char[] chars = word.toCharArray();
                    for (char k = 'a'; k<= 'z'; k++){
                        chars[i] = k;
                        String newWord = String.valueOf(chars);
                        if (newWord.equals(endWord)){
                            return path+1;
                        }
                        if (wordSet.contains(newWord) && !map.containsKey(newWord)){
                            map.put(newWord,path+1);
                            queue.offer(newWord);
                        }
                    }
                }
            }
            return 0;//未找到
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
