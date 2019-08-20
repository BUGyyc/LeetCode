import sun.reflect.generics.tree.Tree;

/*
 * @lc app=leetcode.cn id=572 lang=java
 *
 * [572] 另一个树的子树
 *
 * https://leetcode-cn.com/problems/subtree-of-another-tree/description/
 *
 * algorithms
 * Easy (39.57%)
 * Total Accepted:    2.7K
 * Total Submissions: 6.8K
 * Testcase Example:  '[3,4,5,1,2]\n[4,1,2]'
 *
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s
 * 也可以看做它自身的一棵子树。
 * 
 * 示例 1:
 * 给定的树 s:
 * 
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 * 
 * 
 * 给定的树 t：
 * 
 * 
 * ⁠  4 
 * ⁠ / \
 * ⁠1   2
 * 
 * 
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 * 
 * 示例 2:
 * 给定的树 s：
 * 
 * 
 * ⁠    3
 * ⁠   / \
 * ⁠  4   5
 * ⁠ / \
 * ⁠1   2
 * ⁠   /
 * ⁠  0
 * 
 * 
 * 给定的树 t：
 * 
 * 
 * ⁠  4
 * ⁠ / \
 * ⁠1   2
 * 
 * 
 * 返回 false。
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    private StringBuilder sb1;
    private StringBuilder sb2;

    public boolean isSubtree(TreeNode s, TreeNode t) {
        // return func2(s,t);
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.val == t.val) {
            return isSub(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSub(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.val == t.val) {
            return isSub(s.left, t.left) && isSub(s.right, t.right);
        }
        return false;
    }

    /**
     * 把两个树的层序遍历保存为字符串 如果包含字符串，那么就是树的子树
     * 
     * @param s
     * @param t
     * @return
     */
    private boolean func1(TreeNode s, TreeNode t) {
        sb1 = new StringBuilder();
        sb2 = new StringBuilder();
        treeToString(s, 1);
        treeToString(t, 2);
        return (sb1.toString().indexOf(sb2.toString()) != -1);
    }

    private void treeToString(TreeNode root, int type) {
        if (root == null) {
            if (type == 1)
                sb1.append("*");
            else
                sb2.append("*");
            return;
        }
        if (type == 1) {
            sb1.append("&" + root.val + "-");
        } else {
            sb2.append("&" + root.val + "-");
        }
        treeToString(root.left, type);
        treeToString(root.right, type);
    }

    public boolean func2(TreeNode s, TreeNode t) {
        if (s == null || t == null)
            return false;
        if (isSameTree(s, t))
            return true;
        return func2(s.left, t) || func2(s.right, t);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null)
            return t == null;
        if (t == null)
            return s == null;
        if (s.val != t.val)
            return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
