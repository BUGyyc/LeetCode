
/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
 *
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/description/
 *
 * algorithms
 * Easy (51.65%)
 * Total Accepted:    2.5K
 * Total Submissions: 4.8K
 * Testcase Example:  '[1,null,3,2]'
 *
 * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 * 
 * 示例 :
 * 
 * 
 * 输入:
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    3
 * ⁠   /
 * ⁠  2
 * 
 * 输出:
 * 1
 * 
 * 解释:
 * 最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 * 
 * 
 * 注意: 树中至少有2个节点。
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    // private int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        // func(root);
        // return min;
        // 中序输出之后，就是从小到大的排序数组
        inOrder(root);
        // 遍历数组，找出相邻结点差值最小的值，即是题目所求的值
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            if (Math.abs(list.get(i + 1) - list.get(i)) < min)
                min = Math.abs(list.get(i + 1) - list.get(i));
        }
        return min;
    }

    ArrayList<Integer> list = new ArrayList<>();

    // 中序遍历以node为根的二分搜索树, 递归算法
    private void inOrder(TreeNode node) {
        if (node == null)
            return;
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }

    private void func(TreeNode root) {
        if (root == null) {
            return;
        }
        int left = 0;
        if (root.left == null) {
            left = root.left.val;
            func(root.left);
        }
        int right = 0;
        if (root.right == null) {
            right = root.right.val;
            func(root.right);
        }
        int d = Math.abs(left - right);
        min = Math.min(min, d);
    }
}
