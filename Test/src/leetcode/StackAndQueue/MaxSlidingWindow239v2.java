package leetcode.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow239v2 {
/*
给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。
滑动窗口每次只向右移动一位。
返回 滑动窗口中的最大值 。

提示：
1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
Related Topics
队列
数组
滑动窗口
单调队列
堆（优先队列）

v2 利用双端队列手动实现单调队列
 * 用一个单调队列来存储对应的下标，每当窗口滑动的时候，直接取队列的头部指针对应的值放入结果集即可
 * 单调队列类似 （tail -->） 3 --> 2 --> 1 --> 0 (--> head) (右边为头结点，元素存的是下标)
 */



    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int idx = 0;
        int[] res = new int[n-k+1];
        for (int i = 0; i < n;i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()]< nums[i]){
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k - 1 ){
                res[idx++] = nums[deque.peek()];
            }

        }
        return res;
    }
    /*
    示例 1：
    输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
    输出：[3,3,5,5,6,7]
    解释：
    滑动窗口的位置                最大值
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7
    示例 2：
    输入：nums = [1], k = 1
    输出：[1]
     */
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ints = maxSlidingWindow(nums, k);
        for(int i :ints){
            System.out.println(i);
        }
    }
}
