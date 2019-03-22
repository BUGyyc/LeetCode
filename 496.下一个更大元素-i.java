import java.util.Map;

/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 *
 * https://leetcode-cn.com/problems/next-greater-element-i/description/
 *
 * algorithms
 * Easy (56.97%)
 * Total Accepted:    5.3K
 * Total Submissions: 9.4K
 * Testcase Example:  '[4,1,2]\n[1,3,4,2]'
 *
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2
 * 中的下一个比其大的值。
 * 
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 * 
 * 示例 1:
 * 
 * 
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 * ⁠   对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 * ⁠   对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 * ⁠   对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 
 * 示例 2:
 * 
 * 
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 * 对于num1中的数字2，第二个数组中的下一个较大数字是3。
 * ⁠   对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 
 * 
 * 注意:
 * 
 * 
 * nums1和nums2中所有元素是唯一的。
 * nums1和nums2 的数组大小都不超过1000。
 * 
 * 
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        /**
         * 先遍历一遍nums2 每个结果保存到map 再遍历nums1，找map中的值
         */
        int[] newArr = new int[nums1.length];
        if (nums1.length == 0 || nums2.length == 0) {
            return newArr;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums2.length - 1; i++) {
            for (int j = i + 1; j < nums2.length; j++) {
                if (nums2[j] > nums2[i]) {// 找到了
                    map.put(nums2[i], nums2[j]);
                    break;
                }
                if (j == nums2.length - 1) {// 最后一项也不是
                    if (nums2[j] <= nums2[i]) {
                        map.put(nums2[i], -1);
                    }
                }
            }
        }
        map.put(nums2[nums2.length - 1], -1);// nums2的最后一项
        int n = 0;
        while (n < nums1.length) {
            newArr[n] = map.get(nums1[n]);
            n++;
        }
        return newArr;
    }
}
