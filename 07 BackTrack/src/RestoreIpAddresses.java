import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
/*
有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。
你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 */

/*
解答成功:
	执行耗时:5 ms,击败了37.73% 的Java用户
	内存消耗:41.7 MB,击败了30.10% 的Java用户
 */
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() == 0)
            return  res;
        backTrack(s,res,new String(""),0,0);
        return res;
    }

    public static void backTrack(String s, List<String> res,String path,int idx,int pointNum){
        if (pointNum == 3 && path.length() == (s.length()+3)){
            res.add(path);
            return;
        }

        if (pointNum == 3 && path.length() != (s.length()+3)){
            return;
        }

        for (int i = idx; i <s.length(); i++) {
            String tem = s.substring(idx,i+1);
            if (tem.length() > 1 && Integer.parseInt(tem.substring(0,1)) == 0){
                break;
            }else {
                int temNum = Integer.parseInt(tem);
                if (temNum <= 255){
                    if (path.length() == 0){
                        path = path + tem;
                        backTrack(s,res,path,i+1,pointNum);
                        path = path.substring(0,path.length()- (tem.length()));

                    }else {
                        path  = path + "." + tem;
                        pointNum +=1;
                        backTrack(s,res,path,i+1,pointNum);
                        pointNum -=1;
                        path = path.substring(0,path.length()- (tem.length()+1));
                    }
                }else {
                    break;
                }
            }

        }


    }

    public static void main(String[] args) {
        String s = "25525511135";
        List<String> strings = restoreIpAddresses(s);
        strings.forEach(System.out::println);
    }
}
/*
示例 1：

输入：s = "25525511135"
输出：["255.255.11.135","255.255.111.35"]
示例 2：

输入：s = "0000"
输出：["0.0.0.0"]
示例 3：

输入：s = "101023"
输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 */