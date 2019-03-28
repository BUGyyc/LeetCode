/*
 * @lc app=leetcode.cn id=783 lang=java
 *
 * [783] 二叉搜索树中的搜索
 *
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/description/
 *
 * algorithms
 * Easy (50.66%)
 * Total Accepted:    1.8K
 * Total Submissions: 3.5K
 * Testcase Example:  '[4,2,6,1,3,null,null]'
 *
 * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 * 
 * 示例：
 * 
 * 
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树结点对象(TreeNode object)，而不是数组。
 * 
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 * 
 * ⁠         4
 * ⁠       /   \
 * ⁠     2      6
 * ⁠    / \    
 * ⁠   1   3  
 * 
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 * 
 * 注意：
 * 
 * 
 * 二叉树的大小范围在 2 到 100。
 * 二叉树总是有效的，每个节点的值都是整数，且不重复。
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    // private int min = Integer.MAX_VALUE;

    // public int minDiffInBST(TreeNode root) {
    //     return extracted(root);
    // }

    // private int extracted(TreeNode root) {
    //     func1(root);
    //     return min;
    // }

    // private void func1(TreeNode root) {
    //     if (root == null)
    //         return;
    //     if (root.left != null) {
    //         min = Math.min(min, Math.abs(root.left.val - root.val));
    //         func1(root.left);
    //     }
    //     if (root.right != null){
    //         min = Math.min(min, Math.abs(root.right.val - root.val));
    //         func1(root.right);
    //     } 
    // }
    
    //TODO:
    private int min = Integer.MAX_VALUE;
    private int curV = Integer.MIN_VALUE;
    private boolean t = true;
    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return min;
    }
    public void inOrder(TreeNode r){
        if(r == null) return;
        inOrder(r.left);
        if(t){
            t = false;
        }else min = Math.min(min,r.val - curV);
        curV = r.val;
        inOrder(r.right);
    }
}
