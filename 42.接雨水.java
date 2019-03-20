/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 *
 * https://leetcode-cn.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (41.95%)
 * Total Accepted:    10.2K
 * Total Submissions: 24.1K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 
 * 
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢
 * Marcos 贡献此图。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * 
 */
class Solution {
    //TODO:
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            //如果当前值大于栈顶值，需要弹出栈顶的值，并在弹出的时候执行计算雨水的逻辑
            if (height[i] >= height[stack.peek()]) {
                int bottom = height[stack.pop()];
                //当前栈有元素，且当前值，大于bottom后面的值
                while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                    int leftEdge = stack.pop();
                    result += (height[leftEdge] - bottom) * (i - leftEdge - 1);
                    bottom = height[leftEdge];//将bottom移动到左边的边界处
                }
                //上面的while循环跑完后，判断栈顶的值比当前值大的话，进下面的逻辑
                if (!stack.isEmpty() && height[i] < height[stack.peek()]) {
                    result += (height[i] - bottom) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return result;
    }
}

