/*
 * [78] 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */
class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        func2(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }

    private void func2(List<List<Integer>> list, List<Integer> temp, int[] nums, int first) {
        list.add(new ArrayList<>(temp));
        for (int i = first; i < nums.length; i++) {
            temp.add(nums[i]);
            func2(list, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
