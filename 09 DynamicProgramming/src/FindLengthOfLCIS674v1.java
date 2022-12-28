import java.util.Arrays;

public class FindLengthOfLCIS674v1 {
    public static int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]){
                dp[i] = (dp[i-1] + 1);
            }else {
                dp[i] = 1;
            }
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i]> res)
                res = dp[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        int lengthOfLCIS = findLengthOfLCIS(nums);
        System.out.println(lengthOfLCIS);
    }
}
