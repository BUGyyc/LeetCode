/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
 *
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/description/
 *
 * algorithms
 * Easy (61.22%)
 * Total Accepted:    14.6K
 * Total Submissions: 23.7K
 * Testcase Example:  '[-10,-3,0,5,9]'
 *
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 
 * 示例:
 * 
 * 给定有序数组: [-10,-3,0,5,9],
 * 
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * 
 * ⁠     0
 * ⁠    / \
 * ⁠  -3   9
 * ⁠  /   /
 * ⁠-10  5
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
    //TODO:
    class Node{ // need another class to store multi information
        int low, up; // means the TreeNode covers [low, up], low and up are all index
        TreeNode t;
        Node(int l, int p, TreeNode node){
            low = l;
            up = p;
            t = node;
        }
    }
    public TreeNode sortedArrayToBST(int[] num) {
        if(num == null || num.length == 0) return null;
        Stack<Node> stack = new Stack<Node>();
        // initialize
        TreeNode root = new TreeNode(num[(num.length-1)/2]);
        Node rootNode = new Node(0,num.length-1,root);
        stack.push(rootNode);
        // iteration
        while(!stack.isEmpty()){
            Node node = stack.pop();
            int middle = (node.low+node.up)/2; // cut half for [low, up]
            
            // [low, middle-1]
            if(middle-1 >= node.low){
                TreeNode leftnode = new TreeNode(num[(middle-1+node.low)/2]);
                node.t.left = leftnode;
                Node left = new Node(node.low, middle-1, leftnode);
                stack.push(left);
            }
            // [middle+1, up]
            if(middle+1 <= node.up){
                TreeNode rightnode = new TreeNode(num[(middle+1+node.up)/2]);
                node.t.right = rightnode;
                Node right = new Node(middle+1, node.up, rightnode);
                stack.push(right);
            }
        }
        return root;
    }
}

