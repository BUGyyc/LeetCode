import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=872 lang=java
 *
 * [872] 叶子相似的树
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    private ArrayList<Integer> list1 = new ArrayList<Integer>();
    private ArrayList<Integer> list2 = new ArrayList<Integer>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        pushNodeValue2List(root1, list1);
        pushNodeValue2List(root2, list2);
        if (list1.size() != list2.size())
            return false;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }

    public void pushNodeValue2List(TreeNode root, ArrayList<Integer> list) {
        if (root == null)
            return;
        if (root.left != null)
            pushNodeValue2List(root.left, list);
        if (root.right != null)
            pushNodeValue2List(root.right, list);
        if (root.left == null && root.right == null)
            list.add(root.val);
    }

}
