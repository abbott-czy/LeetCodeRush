import java.util.stream.IntStream;

public class LargestSumAfterKNegations10005v1 {

    //给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
//
//
// 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
//
//
// 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
//
// 以这种方式修改数组后，返回数组 可能的最大和 。
//
//
//
// 示例 1：
//
//
//输入：nums = [4,2,3], k = 1
//输出：5
//解释：选择下标 1 ，nums 变为 [4,-2,3] 。
//
//
// 示例 2：
//
//
//输入：nums = [3,-1,0,2], k = 3
//输出：6
//解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
//
//
// 示例 3：
//
//
//输入：nums = [2,-3,-1,5,-4], k = 2
//输出：13
//解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁴
// -100 <= nums[i] <= 100
// 1 <= k <= 10⁴
//
//
// Related Topics 贪心 数组 排序 👍 295 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestSumAfterKNegations(int[] nums, int k) {
            if (nums.length == 1){
                if ( k % 2 == 0)
                    return nums[0];
                else {
                    return -nums[0];
                }
            }
            int res = 0;
            nums = IntStream.of(nums)
                    .boxed()
                    .sorted(((o1, o2) -> Math.abs(o1) - Math.abs(o2)))
                    .mapToInt(Integer::intValue)
                    .toArray();
            for (int i = 0; i < nums.length; i++) {
                System.out.println(nums[i]);
            }
            for (int i = nums.length -1 ; i >= 0 ; i--) {
                if (nums[i] < 0 && k > 0) {
                    res -= nums[i];
                    k--;
                }else {
                    res += nums[i];
                }

            }

            if (k % 2 == 0)
                return res;
            else {
                System.out.println(res);
                if (nums[0] > 0)
                    res -= 2 * nums[0];
                else
                    res += 2 * nums[0];
                return res;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
