//在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
//
// 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
//
// 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
//
//
//
// 示例 1:
//
//
//输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
//输出: 3
//解释:
//从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
//开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
//开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
//开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
//开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
//开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
//因此，3 可为起始索引。
//
// 示例 2:
//
//
//输入: gas = [2,3,4], cost = [3,4,3]
//输出: -1
//解释:
//你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
//我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
//开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
//开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
//你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
//因此，无论怎样，你都不可能绕环路行驶一周。
//
//
//
// 提示:
//
//
// gas.length == n
// cost.length == n
// 1 <= n <= 10⁵
// 0 <= gas[i], cost[i] <= 10⁴
//
//
// Related Topics 贪心 数组 👍 1090 👎 0


public class CanCompleteCircuit134v1 {
/*
执行耗时:4 ms,击败了16.48% 的Java用户
	内存消耗:60.8 MB,击败了84.33% 的Java用户
 */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if (cost.length == 1 && (gas[0] > cost[0])){
            return 0;}

        // 情况1 如果gas的总和小于cost总和，那么无论从哪里出发，一定是跑不了一圈的
        int gasSum = 0;
        int costSum = 0;
        for (int i = 0; i < gas.length; i++) {
            costSum += cost[i];
            gasSum  = gasSum + gas[i];
        }
        if (gasSum < costSum)
            return -1;

        int res = 0;
        int start = 0;
        int curGas = 0;
        int complete = cost.length;
        int cur = 0;

        while (cur < cost.length){
            if (cur == 0 &&  gas[start] >= cost[start]){
                curGas = gas[start] - cost[start];
                cur++;
                res = start;

            }else if (cur == 0 &&  gas[start] < cost[start]){
                cur = 0;
            }else {
                curGas =  curGas + gas[start]  - cost[start];
                if ( curGas < 0){
                    if (cur == (complete - 1))
                        return -1;
                    cur = 0;
                    curGas = 0;
                }else {
                    cur++;
                }
            }
            start = ( start + 1 ) % complete;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,3,2,4,1,5,3,2,4};
        int[] cost = {1,1,1,3,2,4,3,6,7,4,3,1};
        int i = canCompleteCircuit(gas, cost);
        System.out.println(i);
    }
}
