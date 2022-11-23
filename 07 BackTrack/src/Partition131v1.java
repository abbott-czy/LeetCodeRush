import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Partition131v1 {
/*
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
回文串 是正着读和反着读都一样的字符串
 */

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 0)
            return  res;
        backTrack(s,res,new LinkedList<>(),0);
        return res;
    }

    public static boolean isHui(String s, int start, int end){
        for (int i = start,j=end; i< j; i++, j--){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void backTrack(String s,List<List<String>> res,LinkedList<String> path, int idx){
        if (idx >= s.length() ){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            // 在这里idx是不动的，i是不断向后移动的
            if (isHui(s,idx,i)){
                String str = s.substring(idx,i+1);
                path.add(str);
            }
            else {
                continue;
            }
            backTrack(s,res,path,i+1);
            path.removeLast();

        }

    }

/*
输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]
示例 2：
输入：s = "a"
输出：[["a"]]
 */
    public static void main(String[] args) {
        String s = "ababba";
        List<List<String>> partition = partition(s);
        for (int i = 0; i < partition.size(); i++) {
            System.out.println(partition.get(i));
        }
    }
}
