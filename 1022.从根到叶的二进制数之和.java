/*
 * @lc app=leetcode.cn id=1022 lang=java
 *
 * [1022] 从根到叶的二进制数之和
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    //TODO:
    private int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        getItem(0, root);
        return sum;
    }

    public void getItem(int parent, TreeNode root) {
        if (root == null) {
            return;
        } else {
            parent <<= (root.val);
        }
        if (root.left == null && root.right == null) {
            sum += parent;
        }
        if (root.left != null) {
            getItem(parent, root.left);
        }
        if (root.right != null) {
            getItem(parent, root.right);
        }
    }
}
