/*
 * @lc app=leetcode.cn id=700 lang=java
 *
 * [700] Search in a Binary Search Tree
 *
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/description/
 *
 * algorithms
 * Easy (62.97%)
 * Total Accepted:    3.8K
 * Total Submissions: 6K
 * Testcase Example:  '[4,2,7,1,3]\n2'
 *
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 * 
 * 例如，
 * 
 * 
 * 给定二叉搜索树:
 * 
 * ⁠       4
 * ⁠      / \
 * ⁠     2   7
 * ⁠    / \
 * ⁠   1   3
 * 
 * 和值: 2
 * 
 * 
 * 你应该返回如下子树:
 * 
 * 
 * ⁠     2     
 * ⁠    / \   
 * ⁠   1   3
 * 
 * 
 * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        return func1(root, val);
    }

    private TreeNode extracted(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;
        if (root.left != null)
            return searchBST(root.left, val);
        if (root.right != null)
            return searchBST(root.right, val);
        return null;
    }

    private TreeNode func1(TreeNode root, int val) {
        if (root == null)
            return null;
        return root.val == val ? root : root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
