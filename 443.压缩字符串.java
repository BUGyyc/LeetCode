/*
 * @lc app=leetcode.cn id=443 lang=java
 *
 * [443] 压缩字符串
 *
 * https://leetcode-cn.com/problems/string-compression/description/
 *
 * algorithms
 * Easy (32.58%)
 * Total Accepted:    2.6K
 * Total Submissions: 7.9K
 * Testcase Example:  '["a","a","b","b","c","c","c"]'
 *
 * 给定一组字符，使用原地算法将其压缩。
 * 
 * 压缩后的长度必须始终小于或等于原数组长度。
 * 
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 * 
 * 在完成原地修改输入数组后，返回数组的新长度。
 * 
 * 
 * 
 * 进阶：
 * 你能否仅使用O(1) 空间解决问题？
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：
 * ["a","a","b","b","c","c","c"]
 * 
 * 输出：
 * 返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
 * 
 * 说明：
 * "aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：
 * ["a"]
 * 
 * 输出：
 * 返回1，输入数组的前1个字符应该是：["a"]
 * 
 * 说明：
 * 没有任何字符串被替代。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * 
 * 输出：
 * 返回4，输入数组的前4个字符应该是：["a","b","1","2"]。
 * 
 * 说明：
 * 由于字符"a"不重复，所以不会被压缩。"bbbbbbbbbbbb"被“b12”替代。
 * 注意每个数字在数组中都有它自己的位置。
 * 
 * 
 * 注意：
 * 
 * 
 * 所有字符都有一个ASCII值在[35, 126]区间内。
 * 1 <= len(chars) <= 1000。
 * 
 * 
 */
class Solution {
    /**
     * 取第一个开始遍历比较 如果下一个不等于比较字符，那么重置比较字符，再继续往下比较 如果等于，那么开始计数，直到不等于，或者是最后一个字符时，数目写入数组
     */
    public int compress(char[] chars) {
        int index = 0; // 用来更新chars
        int i = 0; // 用来遍历chars
        while (i < chars.length) {
            int sum = 1;
            for (int j = i + 1; j < chars.length; j++) { // 找到有几个相等的字符
                if (chars[j] != chars[i]) {
                    break;
                }
                sum++;
            }
            chars[index++] = chars[i];
            if (sum > 1) {
                String s = String.valueOf(sum);
                for (int k = 0; k < s.length(); k++) {
                    chars[index++] = s.charAt(k);
                }
            }
            i += sum;
        }
        return index;
        // int j = 0;
        // int lastIndex = -1;// 最后相等的索引
        // for (int i = 1; i < chars.length; i++) {
        // if (chars[i] != chars[j]) {// 如果不等
        // if (lastIndex > -1) {
        // // chars[j++] = chars[i];
        // int nums = lastIndex - j + 1;// 重复的数量
        // String str = String.valueOf(nums);
        // char[] cs = str.toCharArray();
        // for (int x = 0; x < cs.length; x++) {
        // chars[j++] = cs[x];
        // }
        // lastIndex = -1;
        // }
        // chars[j++] = chars[i];
        // } else {
        // lastIndex = i;
        // }
        // }
        // return j;
    }

    // private int insertArr(char[] chars,int s,int nums){
    // String str = String.valueOf(nums);
    // char[] cs = str.toCharArray();
    // for(int i =0;i<cs.length;i++){
    // chars[]
    // }
    // }

    private void func() {
        // Char compareC = chars[0];
        // int nums = 0;
        // boolean isStart = false;
        // int j = 0;
        // for(int i = 1;i<chars.length;i++){
        // if(compareC != chars[i]){
        // if(isStart == false)
        // compareC = chars[i];
        // chars[j]
        // else{
        // isStart = false;
        // }
        // }else{
        // if(isStart == false){//首次计数
        // nums = 2;
        // isStart = true;//说明开始比较了
        // }else{
        // nums++;
        // }
        // }
        // }
    }
}
