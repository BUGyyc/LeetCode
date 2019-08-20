
/*
 * [77] 组合
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * 示例:
 * 
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 */
class Solution {
    //LinkedList防止重复
    List<List<Integer>> result = new LinkedList();
    int n;
    int k;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        func(new LinkedList<Integer>(), 1);
        return result;
    }

    private void func(LinkedList<Integer> list, int first) {
        if (list.size() == this.k) {
            //满足条件
            result.add(new LinkedList(list));
            return;
        }

        for (int i = first; i < n + 1; i++) {
            list.add(i);
            func(list, i + 1);
            //回溯
            list.removeLast();
        }
    }
}
