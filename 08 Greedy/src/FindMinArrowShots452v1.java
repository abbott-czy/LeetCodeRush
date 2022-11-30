import java.util.Arrays;

public class FindMinArrowShots452v1 {
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 1)
            return 1;

        Arrays.sort(points , (a, b)-> Integer.compare(a[0],b[0]));


        int res = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i-1][1] ){
                res += 1;
            }else {
                points[i][1] = Math.min(points[i][1],points[i-1][1]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        int minArrowShots = findMinArrowShots(points);
        System.out.println(minArrowShots);
    }
}
