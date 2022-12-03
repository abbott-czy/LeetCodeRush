import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Merge56v1 {


    public static int[][] merge(int[][] intervals) {
       Arrays.sort(intervals, (a,b)->{
           if (a[0] == b[0]) return a[1] - b[1];
           return a[0] - b[0];
       });

        List<int[]> list = new LinkedList<>();
        int end = intervals[0][1];
        int[] res = new int[2];
        res[0] = intervals[0][0];
        res[1] = intervals[0][1];
        for (int i = 1; i < intervals.length ; i++) {
            if (intervals[i][0] <= end){
                end = Math.max(intervals[i][1],res[1]);
                res[1] = end;
                if (i == intervals.length - 1){
                    list.add(res);
                }
            }else {
                list.add(res);
                res = new int[2];
                res[0] = intervals[i][0];
                res[1] = intervals[i][1];
                end = res[1];
                if (i == intervals.length - 1){
                    list.add(res);
                }
            }
        }
        int[][] objects = list.toArray(new int[list.size()][]);
        return objects;
    }

    public static void main(String[] args) {
        int[][] intervals = {{2,6},{1,3},{15,18},{8,10}};
        int[][] merge = merge(intervals);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(Arrays.toString(merge[i]));
        }
    }
}
