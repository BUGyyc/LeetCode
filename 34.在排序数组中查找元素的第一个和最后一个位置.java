/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 *
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (35.23%)
 * Total Accepted:    13.1K
 * Total Submissions: 37.1K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 
 * 示例 1:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 
 * 示例 2:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * 
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if(nums == null){
            return result;
        }
        result[0] = binarySearch(nums, target, true);
        result[1] = binarySearch(nums, target, false);
        return result;
    }
    public int binarySearch(int[] nums, int target, boolean b){
        int low = 0;
        int high = nums.length - 1;
        int middle;
        while(low <= high){
            middle = low + (high - low) / 2;
            if(nums[middle] == target){
                if(b){//找最小的下标
                    if(middle > 0 && nums[middle - 1] == target){
                        high = middle - 1;
                    }
                    else{
                        return middle;
                    }
                }
                else{//找最大的下标
                    if(middle < nums.length - 1 && nums[middle + 1] == target){
                        low = middle + 1;
                    }
                    else{
                        return middle;
                    }
                }
            }
            else if(nums[middle] < target){
                low = middle + 1;
            }
            else{
                high = middle - 1;
            }
        }
        return -1;
    }
    // public int[] searchRange(int[] nums, int target) {
    //     int[] rArr = new int[2];
    //     rArr[0] = -1;
    //     rArr[1] = -1;
    //     return search(nums, 0, nums.length - 1, target, rArr);
    // }
    // //TODO:
    // // 二分法查找
    // private int[] search(int[] nums, int f, int e, int target, int[] rArr) {
    //     if (f > e) {
    //         return rArr;
    //     }
    //     int mid = (f + e) / 2;
    //     if (target == nums[mid]) {// 找到了
    //         rArr[0] = mid;
    //         rArr[1] = mid + 1;
    //         return rArr;
    //     } else if (target > nums[mid]) {
    //         return search(nums, mid + 1, e, target, rArr);
    //     } else {
    //         return search(nums, f, mid - 1, target, rArr);
    //     }

    // }
}
