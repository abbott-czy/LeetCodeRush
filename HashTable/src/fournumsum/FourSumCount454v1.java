package fournumsum;

import java.util.HashMap;
import java.util.Map;

/*
给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：

0 <= i, j, k, l < n
nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
提示：
n == nums1.length
n == nums2.length
n == nums3.length
n == nums4.length
1 <= n <= 200
-228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228
Related Topics
数组
哈希表
 */

/*
执行耗时:162 ms,击败了15.10% 的Java用户
	内存消耗:41.9 MB,击败了9.60% 的Java用户
 */
public class FourSumCount454v1 {

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0; //统计总共出现的次数;
        Map<Integer,Integer> record = new HashMap<>();
        for (int i=0; i < nums1.length; i++){
            for (int j = 0; j < nums2.length; j++) {
                int tem = nums1[i] + nums2[j];
                if (record.containsKey(tem)){
                    record.put(tem, record.get(tem)+1);
                }else{
                    record.put(tem,record.getOrDefault(tem,0)+1);
                }
            }
        }
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int tem =  0 - (nums3[i] + nums4[j]);
                if (record.containsKey(tem)){
                   count += record.get(tem);
                }
            }

        }
        return count;
    }
/*
示例 1：
输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
输出：2
解释：
两个元组如下：
1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
示例 2：
输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
输出：1
 */
    public static void main(String[] args) {
        int[] nums1 = {-1,-1};
        int[] nums2 = {-1,1};
        int[] nums3 = {-1,1};
        int[] nums4 = {1,-1};
        int i = fourSumCount(nums1, nums2, nums3, nums4);
        System.out.println(i); //6
    }
}
