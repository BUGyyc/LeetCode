/*
 * @lc app=leetcode.cn id=538 lang=java
 *
 * [538] 把二叉搜索树转换为累加树
 *
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/description/
 *
 * algorithms
 * Easy (50.41%)
 * Total Accepted:    2.4K
 * Total Submissions: 4.9K
 * Testcase Example:  '[5,2,13]'
 *
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater
 * Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * 
 * 例如：
 * 
 * 
 * 输入: 二叉搜索树:
 * ⁠             5
 * ⁠           /   \
 * ⁠          2     13
 * 
 * 输出: 转换为累加树:
 * ⁠            18
 * ⁠           /   \
 * ⁠         20     13
 * 
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 二叉累加树
     * 左节点 = 父节点 + 右节点
     * 节点 = 节点 + 右节点
     */
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return root;
        dfs(root, 0);
        return root;
    }
    public int dfs(TreeNode root, int sum){
        if(root.right != null){
            sum = dfs(root.right, sum);
        }
        root.val += sum;//把右节点的值全部取出来，赋予root节点
        if(root.left != null){
            return dfs(root.left, root.val); //左节点则取 root节点的值+ 左节点
        }else return root.val;
    }
}

