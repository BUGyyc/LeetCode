import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */
class Solution {
    // TODO:
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = 0;
        for (int i = 1; i < nums.length; i++) {
            n = nums[i - 1] ^ nums[i];
            if (n == 0) {
                return nums[i];
            }
        }
        return nums[0];
    }
}
