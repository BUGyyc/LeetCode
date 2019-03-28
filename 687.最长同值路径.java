/*
 * @lc app=leetcode.cn id=687 lang=java
 *
 * [687] 最长同值路径
 *
 * https://leetcode-cn.com/problems/longest-univalue-path/description/
 *
 * algorithms
 * Easy (32.84%)
 * Total Accepted:    2.2K
 * Total Submissions: 6.6K
 * Testcase Example:  '[5,4,5,1,1,5]'
 *
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * 
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 * 
 * 示例 1:
 * 
 * 输入:
 * 
 * 
 * ⁠             5
 * ⁠            / \
 * ⁠           4   5
 * ⁠          / \   \
 * ⁠         1   1   5
 * 
 * 
 * 输出:
 * 
 * 
 * 2
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * 
 * 
 * ⁠             1
 * ⁠            / \
 * ⁠           4   5
 * ⁠          / \   \
 * ⁠         4   4   5
 * 
 * 
 * 输出:
 * 
 * 
 * 2
 * 
 * 
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
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
    //TODO:
    int count = 0;
    public int longestUnivaluePath(TreeNode root) {
        getCount(root);
        return count;
    }
    
    public int getCount(TreeNode root) {
        if(root == null) return 0;
        
        int left = getCount(root.left);
        int right = getCount(root.right);
        
        int leftCur = 0;
        int rightCur = 0;
        if(root.left != null && root.val == root.left.val) {
            leftCur += 1 + left;
        }
        
        if(root.right != null && root.val == root.right.val) {
            rightCur += 1 + right;
        }
        
        count = Math.max(count, leftCur + rightCur);
        
        return Math.max(leftCur, rightCur);
    }
}

