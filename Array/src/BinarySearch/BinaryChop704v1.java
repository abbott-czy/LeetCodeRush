package BinarySearch;

public class BinaryChop704v1 {
    /**
     * 二分查找
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，
     * 如果目标值存在返回下标，否则返回 -1。
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }
        else if(nums.length ==1){
            if (nums[0] == target){
                return 0;
            }
            else
                return -1;
        }
        int i = binarySearcch(nums, target, 0, nums.length-1);

        return i;
    }

    public static int binarySearcch(int[] nums, int target, int start,int end){

        if (start > end || end < start){
            return -1;
        }

        if (start == end){
            if (nums[start] == target){
                if (nums[start] == target)
                    return start;
            }
            else
                return  -1;
        }
        int middle_id = (start + end) / 2;
        int middle_num = nums[middle_id];

        if (middle_num == target){
            return middle_id;
        }
        else if (target > middle_num){
            int i = binarySearcch(nums, target, middle_id+1, end);

            return i;
        }
        else if (target < middle_num){
            int i = binarySearcch(nums, target, start, middle_id - 1);
            return i;
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = {-1,0,3,5,9,12,17};
//        int[] nums = {-1,0,5};
        int[] nums = {-1,0,3,5,9,12};
        int target = 13;
        int search = search(nums, target);
        System.out.println(search);
    }
}
