package a_shuzu;

/**移除元素：
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 解题思路：双指针法（快慢指针法）： 通过一个快指针和慢指针在一个for循环下完成两个for循环的工作。
 */
public class delete_yuansu {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;

//        int[] nums = {0,1,2,2,3,0,4,2};
//        int val = 2;

        System.out.println(delete(nums, val));
    }
    public static int delete(int[] nums, int val){
        int move = 0;
        int stay = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[move] == val){
                move += 1;
            }
            else {
                nums[stay] = nums[move];
                move += 1;
                stay += 1;
            }
        }
        return stay;
    }
    //答案
    public int removeElement(int[] nums, int val) {
        // 快慢指针
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
}
