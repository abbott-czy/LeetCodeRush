package leetcode.StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow239v1 {
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


v1 自定义数组
 */
    static class MyQueue{
        Deque<Integer> deque = new LinkedList<>();

        void poll(int val){
            if (!deque.isEmpty() && deque.peek() == val)
                deque.poll();
        }

        void add(int val){
            while (!deque.isEmpty() && val > deque.getLast()){
                deque.removeLast();
            }
            deque.add(val);
        }

        int peek(){
           return deque.peek();
        }
}


    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length <=1){
            return nums;
        }

        int len = nums.length - k  + 1;
        int[] res = new int[len];
        int num = 0;
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < k; i++) {
                myQueue.add(nums[i]);
        }
        res[num++] = myQueue.peek();

        for (int i = k; i < nums.length; i++) {
            myQueue.poll(nums[i-k]);
            myQueue.add(nums[i]);
            res[num++] = myQueue.peek();
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
