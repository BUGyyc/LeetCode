import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=653 lang=java
 *
 * [653] 两数之和 IV - 输入 BST
 *
 * https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/description/
 *
 * algorithms
 * Easy (49.54%)
 * Total Accepted:    2.9K
 * Total Submissions: 5.9K
 * Testcase Example:  '[5,3,6,2,4,null,7]\n9'
 *
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * 
 * 案例 1:
 * 
 * 
 * 输入: 
 * ⁠   5
 * ⁠  / \
 * ⁠ 3   6
 * ⁠/ \   \
 * 2   4   7
 * 
 * Target = 9
 * 
 * 输出: True
 * 
 * 
 * 
 * 
 * 案例 2:
 * 
 * 
 * 输入: 
 * ⁠   5
 * ⁠  / \
 * ⁠ 3   6
 * ⁠/ \   \
 * 2   4   7
 * 
 * Target = 28
 * 
 * 输出: False
 * 
 * 
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return func1(root, k);
    }

    /**
     * 因为是二叉搜索树
     * 前序遍历二叉树
     * 把值存储在list
     * 最后首尾双指针遍历list
     * @param root
     * @param k
     * @return
     */
    private List<Integer> list;
    private boolean func1(TreeNode root, int k) {
        list = new ArrayList<>();
        getNumList(root);
        int i = 0;
        int j = list.size()-1;
        while(i<j){
            if(list.get(i) + list.get(j) == k){
                return true;
            }else if(list.get(i) + list.get(j) > k){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }

    private void getNumList(TreeNode root){
        if(root == null)return;
        getNumList(root.left);
        list.add(root.val);
        getNumList(root.right);
    }
}
