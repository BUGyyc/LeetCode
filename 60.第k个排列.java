

/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 第k个排列
 *
 * https://leetcode-cn.com/problems/permutation-sequence/description/
 *
 * algorithms
 * Medium (45.06%)
 * Total Accepted:    6K
 * Total Submissions: 13K
 * Testcase Example:  '3\n3'
 *
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * 
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * 
 * 给定 n 和 k，返回第 k 个排列。
 * 
 * 说明：
 * 
 * 
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 
 * 
 * 示例 1:
 * 
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 
 * 
 * 示例 2:
 * 
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * 
 * 
 */
class Solution {
    public String getPermutation(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        List<Integer> res = new ArrayList<>();
        // visited标记这个位置是否使用过
        int[] visited = new int[arr.length];
        String temp = "";
        backtrack(res, arr, temp, visited);

        int[] nums = new int[res.size()];
        Arrays.sort(nums);

        return nums[nums.length - k];
    }

    private void backtrack(List<Integer> res, int[] nums, String tmp, int[] visited) {
        // 放满后
        if (tmp.length() == nums.length) {
            res.add(Integer.parseInt(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 使用过的直接跳过
            if (visited[i] == 1)
                continue;
            // 标记使用过
            visited[i] = 1;
            // 放入
            tmp += "" + (nums[i]);
            backtrack(res, nums, tmp, visited);
            // 重置标志位
            visited[i] = 0;
            // 移除
            tmp.remove(tmp.size() - 1);
        }
    }
}
