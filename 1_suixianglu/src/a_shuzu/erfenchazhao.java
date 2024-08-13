package a_shuzu;

/**
 * 二分查找：
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 解题思路：二分查找，左闭右开(left肯定不会等于right的，代码要注意！！)。   left middle right
 */
public class erfenchazhao {
    public static void main(String[] args) {
//        int[] nums = {-1, 0, 3, 5, 9, 12};
//        int target = 9;

        int[] nums = {-1,0,3,5,9,12};
        int target = 2;
        int out = search(nums, target);
        System.out.println(out);
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
//        int middle = left + (right - left)/2;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > target) {
                right = middle;
            }
            if (nums[middle] < target) {
                left = middle + 1;
            }
            else if(nums[middle] == target){
                return middle;
            }
        }
        return -1;
    }
}