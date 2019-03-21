/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 *
 * https://leetcode-cn.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (31.82%)
 * Total Accepted:    95.8K
 * Total Submissions: 299.6K
 * Testcase Example:  '123'
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 
 * 示例 1:
 * 
 * 输入: 123
 * 输出: 321
 * 
 * 
 * 示例 2:
 * 
 * 输入: -123
 * 输出: -321
 * 
 * 
 * 示例 3:
 * 
 * 输入: 120
 * 输出: 21
 * 
 * 
 * 注意:
 * 
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回
 * 0。
 * 
 */
class Solution {
	/**
	 * TODO:可以再优化
	 */
    //2^31-1=2147483647,-2^31=-2147483648
    public int reverse(int x) {
        String s = String.valueOf(x);
		char[] chars = s.toCharArray();
		// 判断输入整数是正数还是负数。正数则flag=false。
		boolean flag = chars[0] == '-' ? true : false;
		// 如果是负数最后一个是符号位，不用翻转！
		int end = flag ? 1 : 0;
		StringBuffer sb = new StringBuffer();// 保存翻转后的字符串
		for (int i = chars.length - 1; i >= end; i--) {
			sb.append(chars[i]);
		}

		int result = 0;// 保存结果
		try {
			result = Integer.parseInt(sb.toString());
		} catch (NumberFormatException e) { // 如果反转后的整数溢出，则返回 0
			return 0;
		}
		result = flag ? (-result) : result;
		return result;
    }
}

