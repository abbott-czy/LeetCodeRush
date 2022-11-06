package leetcode.StackAndQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent347{
    /*
    给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。

    提示：
    1 <= nums.length <= 105
    k 的取值范围是 [1, 数组中不相同的元素的个数]
    题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
    进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
    Related Topics
    数组
    哈希表
    分治
    桶排序
    计数
    快速选择
    排序
    堆（优先队列）

    v1 小顶堆
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1,pair2) -> pair1[1] - pair2[1]);

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (pq.size() < k){
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            }else {
                if (entry.getValue() > pq.peek()[1]){
                    pq.poll();
                    pq.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0 ; i--) {
            ans[i] = pq.poll()[0];
        }
        return ans;


    }
    /*
    示例 1:
    输入: nums = [1,1,1,2,2,3], k = 2
    输出: [1,2]
    示例 2:
    输入: nums = [1], k = 1
    输出: [1]
     */
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] ints = topKFrequent(nums, k);
        for (int i :ints){
            System.out.println(i);
        }
    }
}
