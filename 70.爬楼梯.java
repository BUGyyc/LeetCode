/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 *
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (44.46%)
 * Total Accepted:    35.7K
 * Total Submissions: 79.7K
 * Testcase Example:  '2'
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 注意：给定 n 是一个正整数。
 * 
 * 示例 1：
 * 
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 
 * 示例 2：
 * 
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 
 * 
 */
class Solution {
    /**
     * 数列
     */
    public int climbStairs(int n) {
        // return fbFunc(n);

        //使用带缓存的递归
        if(n==1||n==2){return n;}
        int[] cache = new int[n+1];
        cache[0] = 1;
        cache[1] = 1;
        
        for(int i=2;i<=n;i++){
            cache[i] = cache[i-1] +cache[i-2];
        }
        return cache[n];
    }

    private int fbFunc(int x){
        if(x == 1){
            return 1;
        }else if(x == 2){
            return 2;
        }else{
            return fbFunc(x-1)+fbFunc(x-2);
        }
    }
}

