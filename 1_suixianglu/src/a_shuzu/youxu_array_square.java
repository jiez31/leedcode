package a_shuzu;

/**有序数组的平方：
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * 思路：数组平方的最大值就在数组的两端，不是最左边就是最右边，不可能是中间。此时可以考虑双指针法了，i指向起始位置，j指向终止位置。
 */
public class youxu_array_square {
    public static void main(String[] args) {
//        int[] nums = {-4,-1,0,3,10};
        int[] nums = {-7,-3,2,3,11};
        int[] newnums = square(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(newnums[i]);
        }
    }
    public static int[] square(int[] nums){
        int[] newnums = new int[nums.length];
        int i = 0;
        int j = nums.length - 1;
        for (int temp = nums.length - 1; temp >= 0; temp--){
            if(nums[i] * nums[i] < nums[j] *nums[j]){
                newnums[temp] = nums[j]*nums[j];
                j--;
            }
            else{
                newnums[temp] = nums[i]*nums[i];
                i++;
            }
        }
        return newnums;
    }

    //答案
    public int[] sortedSquares(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int[] result = new int[nums.length];
        int index = result.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                // 正数的相对位置是不变的， 需要调整的是负数平方后的相对位置
                result[index--] = nums[left] * nums[left];
                ++left;
            } else {
                result[index--] = nums[right] * nums[right];
                --right;
            }
        }
        return result;
    }
}
