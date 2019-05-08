/*
 * @lc app=leetcode.cn id=938 lang=java
 *
 * [938] 二叉搜索树的范围和
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
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null){
            return 0;
        }
        if(root.val > R){
            return rangeSumBST(root.left, L, R);
        }else if(root.val < L){
            return rangeSumBST(root.right, L, R);
        }else{
            return root.val + rangeSumBST(root.left, L, R)+rangeSumBST(root.right, L, R);
        }
    }
}

