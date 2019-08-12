import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 求众数
 */
class Solution {
    public int majorityElement(int[] nums) {
        // int len = nums.length;
        // Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // for (int i = 0; i < nums.length; i++) {
        // if (map.containsKey(nums[i])) {
        // int value = map.get(nums[i]);
        // map.put(nums[i], value + 1);
        // } else {
        // map.put(nums[i], 1);
        // }
        // }
        // int index = 0;
        // for (int v : map.keySet()) {
        // if (v > len / 2) {
        // // return map.;
        // }
        // index++;
        // }
        // return 0;

        int count = 0;
        int ret = 0;
        for (int var : nums) {
            if (count == 0) {
                ret = var;
            }
            if (ret == var) {
                count++;
            } else{
                count--;
            }
        }
        return ret;
    }
}
