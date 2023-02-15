import java.util.Arrays;
import java.util.HashMap;

public class SmallerNumbersThanCurrent1365v1 {

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
        }

        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            dp[map.get(nums[i])] = i;
        }

        return dp;

    }

    public static void main(String[] args) {
        int[] nums = {8,1,2,2,3};
        int[] ints = smallerNumbersThanCurrent(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }


}
