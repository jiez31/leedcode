package a_shuzu;

/**长度最小的子数组：
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 * 思路：滑动窗口，就是不断的调节子序列的起始位置和终止位置，从而得出我们要想的结果。
 * 注意：先定义一个最大的整数来表示存在数组的长度，再动态更新这个整数，如果到最后这个整数没有被更新，还是最大的，那么就不存在题意的数组。
 */
public class min_len_nums {
    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2,3,1,2,4,3};
//        int s = 100;
//        int[] nums = {1,1,1,1,1,100};

        System.out.println(min_nums(nums,s));
    }
    public static int min_nums(int[] nums, int s){
        int left = 0, right = 0, sumlength = Integer.MAX_VALUE;
        int sum = 0;
        int result;
        for (right = 0; right < nums.length; right++){
            sum += nums[right];
            while (sum >= s){
                result = right - left + 1;
                if(result < sumlength){sumlength = result;}
                sum -= nums[left];
                left++;
            }
        }
        if(sumlength != Integer.MAX_VALUE){return sumlength;}
        else return 0;
    }

    //答案
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
