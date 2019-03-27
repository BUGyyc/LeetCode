import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=581 lang=java
 *
 * [581] 最短无序连续子数组
 *
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/description/
 *
 * algorithms
 * Easy (30.49%)
 * Total Accepted:    2.9K
 * Total Submissions: 9.4K
 * Testcase Example:  '[2,6,4,8,10,9,15]'
 *
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 
 * 你找到的子数组应是最短的，请输出它的长度。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 
 * 
 * 说明 :
 * 
 * 
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 * 
 * 
 */
class Solution {
    /**
     * 拷贝数组
     * 然后数组排序之后比较
     * 
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        return func1(nums);
    }
    
    private int func1(int[] nums){
        int[] newArr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(newArr);
        int left = 0, right = newArr.length - 1;
        while (left <= right && nums[left] == newArr[left]) left++;
        while (left <= right && nums[right] == newArr[right]) right--;
        return (right - left + 1);
    }
}

