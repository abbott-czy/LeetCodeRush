import java.util.*;

public class PartitionLabels763v1 {

    public static List<Integer> partitionLabels(String s) {
        List<Integer> list = new LinkedList<>();
        int[] edge = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            edge[chars[i]-'a'] = i;
        }

        int idx = 0;
        int last = -1;
        for (int i = 0; i < chars.length; i++) {
            idx = Math.max(idx,edge[chars[i] - 'a']);
            if (i == idx){
                list.add(i - last);
                last = i;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String s = "eaaaabaaec";
        List<Integer> integers = partitionLabels(s);
        integers.forEach(System.out::println);
    }
}
