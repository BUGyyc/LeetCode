/*
 * @lc app=leetcode.cn id=400 lang=java
 *
 * [400] 第N个数字
 *
 * https://leetcode-cn.com/problems/nth-digit/description/
 *
 * algorithms
 * Easy (30.21%)
 * Total Accepted:    2.1K
 * Total Submissions: 6.9K
 * Testcase Example:  '3'
 *
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。
 * 
 * 注意:
 * n 是正数且在32为整形范围内 ( n < 231)。
 * 
 * 示例 1:
 * 
 * 
 * 输入:
 * 3
 * 
 * 输出:
 * 3
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入:
 * 11
 * 
 * 输出:
 * 0
 * 
 * 说明:
 * 第11个数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是0，它是10的一部分。
 * 
 * 
 */
class Solution {
    //TODO:
    public int findNthDigit(int n) {
        // 1-10 1*9+1
        // 11-100 2*90+1 + 1*9+1
        if(n<10)return n;
        int i=1;
        long now=n,pra=90;
        while(now>0){
            if(i==1)
                now-=9;
            else{
                now-=i*pra;
                pra*=10;
            }
            i++;
        }
        if(now==0)return 9;
        i--;pra/=10;
        long pos=i*pra+now;
        long no=pos/i;
        long p=pos%i;
        long res=(int)Math.pow(10,i-1)+no-1;
        if(p==0)return (int)res%10;
        res+=1; p=i-p;
        while(p-->0)res/=10;
        return (int)res%10;
    }
}
