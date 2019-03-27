import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=637 lang=java
 *
 * [637] 二叉树的层平均值
 *
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/description/
 *
 * algorithms
 * Easy (56.24%)
 * Total Accepted:    3.7K
 * Total Submissions: 6.6K
 * Testcase Example:  '[3,9,20,15,7]'
 *
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 * 
 * 示例 1:
 * 
 * 输入:
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 * 
 * 
 * 注意：
 * 
 * 
 * 节点值的范围在32位有符号整数范围内。
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
    private List<Double> list;
    private List<Integer> list2;
    public List<Double> averageOfLevels(TreeNode root) {
        return func2(root);
    }

    // private List<Double> func1(TreeNode root){
    //     list = new ArrayList<>();
    //     list2 = new ArrayList<>();
    //     setSum(root, 0);
    //     int i = 0;
    //     for(Double item:list){
    //         list.set(i, item/list2.get(i));
    //     }
    //     return list;
    // }

    // private void setSum(TreeNode root,int level){
    //     if(root == null)return;
    //     int a = (list.size()-1<level)?0:list.get(level);
    //     list.set(level,a+root.val);
    //     int b = (list2.size()-1<level)?0:list2.get(level);
    //     list2.set(level,b+1);//每层的数字个数
    //     if(root.left)
    //         setSum(root.left, level+1);
    //     if(root.right!=null)
    //         setSum(root.right, level+1);
    // }

    /**
     * 要用上队列
     * TODO:
     */
    private List<Double> func2(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> list = new LinkedList<>();
        queue.add(root); 
        while(!queue.isEmpty()){
            int count = queue.size();
            double sum = 0;
            for(int i = 0; i < count; i++){
                root = queue.poll();
                sum += root.val;
                if(root.left != null) queue.add(root.left);
                if(root.right != null) queue.add(root.right);
            }
            list.add(sum / count);
        }
        return list;
    }
}

