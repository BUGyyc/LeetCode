/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/description/
 *
 * algorithms
 * Easy (60.25%)
 * Total Accepted:    15.2K
 * Total Submissions: 25.1K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 
 * 示例 1:
 * 
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 
 * 说明:
 * 
 * 
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * 
 * 
 */
class Solution {
    //TODO:
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] num = {};
        for (int i = 0; i < nums1.length; i++) {
        	if(i==nums1.length-1 || nums1[i]<nums1[i+1]) {
         	   for (int j = 0; j < nums2.length; j++) {
        		   if(nums1[i]==nums2[j]) {
        			   num = Arrays.copyOf(num, num.length+1);
        			   num[num.length-1] = nums1[i];
        			   break;
        		   }
        	   }
        	}
        }
        return num;
    }
}

