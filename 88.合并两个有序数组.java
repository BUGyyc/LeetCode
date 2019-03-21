/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (43.02%)
 * Total Accepted:    33.4K
 * Total Submissions: 77.3K
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 
 * 说明:
 * 
 * 
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 
 * 
 * 示例:
 * 
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * 输出: [1,2,2,3,5,6]
 * 
 */
class Solution {
    /**
     * 遍历1个数组 当第二个数组可插入，则插入同时执行后移
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        
        while (n >= 0) {//没比较完，全部插入
            nums1[p--] = nums2[n--];
        }
        // int j = 0;
        // for (int i = 0; i < m; i++) {
        //     if (nums2[j] < nums1[i]) {
        //         moveArr1(nums1, i, m+j);
        //         nums1[i] = nums2[j];
        //         j++;
        //     }
        // }
        // int x = m;
        // while (j < n) {// nums2还没遍历完
        //     nums1[x] = nums2[j];
        //     x++;
        //     j++;
        // }
    }

    // private void moveArr1(int[] nums1, int index, int len) {
    //     for (int i = len; i >= index; i--) {
    //         nums1[i + 1] = nums1[i];
    //     }
    // }
}
