/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 *
 * https://leetcode-cn.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (53.53%)
 * Total Accepted:    9.2K
 * Total Submissions: 17K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 
 * 说明：
 * 
 * 
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * ⁠ [1, 7],
 * ⁠ [1, 2, 5],
 * ⁠ [2, 6],
 * ⁠ [1, 1, 6]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 */
class Solution {
    //TODO:
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null){
            return ll;
        }
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, 0);
        return ll;
    }
    List<List<Integer>> ll = new ArrayList<>();
    List<Integer> l = new ArrayList<>();
    public void backTracking(int[] c, int t, int s, int j){
        if(s >= t){
            if(s == t){
                if(ll.contains(l)){
                    return ;
                }
                ll.add(l);
                List<Integer> l1 = new ArrayList<>();
                for(int i : l){
                    l1.add(i);
                }
                l = l1;
            }
        }else{
            for(int i = j;i < c.length;i ++){
                l.add(c[i]);
                backTracking(c, t, s + c[i], i + 1);
                l.remove(l.size() - 1);
            }
        }
    }
}

