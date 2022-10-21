package alphaticeectopic;

import java.util.*;

/*
给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
提示：
1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] 仅包含小写字母
Related Topics
数组
哈希表
字符串
排序
 */
public class GroupAnagrams49v1 {

    public static List<List<String>> groupAnagrams(String[] strs) {
       List<List<String>> list = new ArrayList<List<String>>();
       if (strs.length == 0 ){
           return list;
       }
        List<String> list0 = new ArrayList<>();
       list0.add(strs[0]);
       list.add(list0);
        for (int i=1; i < strs.length; i ++){
            for (int j = 0; j < list.size();j++){
                char[] sChars = list.get(j).get(0).toCharArray();
                char[] tChars = strs[i].toCharArray();
                Arrays.sort(sChars);
                Arrays.sort(tChars);
                if (Arrays.equals(sChars,tChars)){
                    list.get(j).add(strs[i]);
                    break;
                }else if (j == list.size() -1){
//                        List<String> list2 = new ArrayList<>();
                        list.add(new ArrayList<>());
                        list.get(list.size()-1).add(strs[i]);
                        break;
                }
            }
        }
       return list;
    }

/*
输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
输入: strs = [""]
输出: [[""]]
输入: strs = ["a"]
输出: [["a"]]
 */
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = groupAnagrams(strs);
        for (List<String> e : lists){
            System.out.println(e);
        }
    }
}
