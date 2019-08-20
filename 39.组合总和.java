import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 *
 * https://leetcode-cn.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (62.52%)
 * Total Accepted:    13K
 * Total Submissions: 20.6K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的数字可以无限制重复被选取。
 * 
 * 说明：
 * 
 * 
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        logic(result, new ArrayList<Integer>(), candidates, 0, target);
        return result;
    }

    private void logic(List<List<Integer>> result, ArrayList<Integer> temp, int[] candidates, int sum, int target) {
        if (sum == target) {
            result.add(temp);
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            if (sum + candidates[i] > target)
                continue;
            sum += candidates[i];
            temp.add(candidates[i]);
            logic(result, temp, candidates, sum, target);
            temp.remove(temp.size() - 1);
            sum -= candidates[i];
        }
    }

    private List<List<Integer>> extracted(int[] candidates, int target) {
        List<List<Integer>> listAll = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        // 排序
        Arrays.sort(candidates);
        find(listAll, list, candidates, target, 0);
        return listAll;
    }

    public void find(List<List<Integer>> listAll, List<Integer> tmp, int[] candidates, int target, int num) {
        // 递归的终点
        if (target == 0) {
            listAll.add(tmp);
            return;
        }
        if (target < candidates[0])
            return;
        for (int i = num; i < candidates.length && candidates[i] <= target; i++) {
            // 深拷贝
            List<Integer> list = new ArrayList<>(tmp);
            list.add(candidates[i]);
            // 递归运算，将i传递至下一次运算是为了避免结果重复。
            find(listAll, list, candidates, target - candidates[i], i);
        }
    }
}
