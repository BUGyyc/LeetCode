import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (66.69%)
 * Total Accepted:    17.6K
 * Total Submissions: 26.2K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 */
class Solution {
    // 回溯算法
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // visited标记这个位置是否使用过
        int[] visited = new int[nums.length];
        backtrack(res, nums, new ArrayList<Integer>(), visited);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        // 放满后
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 使用过的直接跳过
            if (visited[i] == 1)
                continue;
            // 标记使用过
            visited[i] = 1;
            // 放入
            tmp.add(nums[i]);
            backtrack(res, nums, tmp, visited);
            // 重置标志位
            visited[i] = 0;
            // 移除
            tmp.remove(tmp.size() - 1);
        }
    }
}
