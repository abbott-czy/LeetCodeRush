package smallestsubarray;

/**
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
 * 1 <= fruits.length <= 105
 * 0 <= fruits[i] < fruits.length
 * Related Topics
 * 数组
 * 哈希表
 * 滑动窗口
 */

// 滑动窗口的方法，也是双指针，始终记住就是更新水果位置和更新当前水果，
public class TotalFruit904v1 {

    public static int totalFruit(int[] fruits) {
        int fruit1 = -1;  // 第一个水果
        int fruit2 = -1; // 第二个水果
        int curFruit = 0;  // 当前的水果是
        int curFruitLoc = 0; //当前水果的位置;
        int left = 0;    // left 为篮子的起始位置
        int sum = 0;
        int subSum;

        if (fruits.length <=2){
            return fruits.length;
        }

        for (int right = 0; right < fruits.length; right++){
            if (fruits[right] == fruit1 || fruits[right] == fruit2){
                if (fruits[right] !=curFruit){
                    curFruit = fruits[right];
                    curFruitLoc = right;
                }
            }
            else {
                left = curFruitLoc;
                curFruitLoc = right;
                if (fruit1 == curFruit){
                    fruit2 = fruits[right];
                    curFruit = fruit2;
                }
                else {
                    fruit1 = fruits[right];
                    curFruit = fruit1;
                }
            }
                subSum = (right - left +1);
                sum = sum > subSum ? sum : subSum;
        }

        return sum;
    }

    public static void main(String[] args) {
//        int[] fruits = {1,2,1};
        int[] fruits= {0,1,6,6,4,4,6};
//        int[] fruits = {0,1,2,2};
//        int[] fruits = {1,2,3,2,2};
//        int[] fruits = {1,0,1,4,1,4,1,2,3};   // 5
        int i = totalFruit(fruits);
        System.out.println(i);

    }
}

