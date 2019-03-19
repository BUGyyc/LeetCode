/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 *
 * https://leetcode-cn.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (37.64%)
 * Total Accepted:    41.1K
 * Total Submissions: 108.6K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * 
 * 
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            carry = 0;//重置
            if (i == digits.length - 1) {
                sum += 1;
            }
            if(sum >= 10){
                carry = 1;
                digits[i] = sum%10;
            }else{
                digits[i] = sum;
            }
        }
        if(carry == 0){
            return digits;
        }else{
            int newArr[] = new int[digits.length+1];
            newArr[0] = 1;
            for(int j =1;j<newArr.length;j++){
                newArr[j] = digits[j-1];
            }
            return newArr;
        }
    }
}
