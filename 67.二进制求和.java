/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 *
 * https://leetcode-cn.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (46.70%)
 * Total Accepted:    18.7K
 * Total Submissions: 39.7K
 * Testcase Example:  '"11"\n"1"'
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 
 * 输入为非空字符串且只包含数字 1 和 0。
 * 
 * 示例 1:
 * 
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 
 * 示例 2:
 * 
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * 
 */
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder(a); 
        a = builder.reverse().toString();//反转
        builder = new StringBuilder(b); 
        b = builder.reverse().toString();//反转
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        int carry = 0;
        int max = Math.max(aArr.length, bArr.length);
        int[] newArr = new int[max];
        int i = 0;
        while (i < max) {
            int x = (i < aArr.length)?Integer.parseInt(String.valueOf(aArr[i])):0;
            int y = (i < bArr.length)?Integer.parseInt(String.valueOf(bArr[i])):0;
            if(x + y + carry > 1){//有进位
                carry = 1;
                newArr[i] = 0;
            }else{
                newArr[i] = x + y + carry;
                carry = 0;//重置
            }
            i++;
        }
        String str = String.valueOf(newArr);
        builder = new StringBuilder(str); 
        str = builder.reverse().toString();//反转回来
        return str;
    }
}
