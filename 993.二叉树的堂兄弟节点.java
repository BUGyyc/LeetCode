import sun.reflect.generics.tree.Tree;

/*
 * @lc app=leetcode.cn id=993 lang=java
 *
 * [993] 最高的广告牌
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        // TreeNode t1 = getNode(x, root);
        // TreeNode t2 = getNode(y, root);
    }

    public TreeNode getNode(int n, TreeNode root) {
        if (n == root.val) {
            return root;
        }
        if (root.left)
            return getNode(n, root.left);
        if (root.right)
            return getNode(n, root.right);
    }
}
