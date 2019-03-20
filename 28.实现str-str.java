/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现strStr()
 *
 * https://leetcode-cn.com/problems/implement-strstr/description/
 *
 * algorithms
 * Easy (37.88%)
 * Total Accepted:    41.6K
 * Total Submissions: 109.7K
 * Testcase Example:  '"hello"\n"ll"'
 *
 * 实现 strStr() 函数。
 * 
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置
 * (从0开始)。如果不存在，则返回  -1。
 * 
 * 示例 1:
 * 
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 
 * 
 * 说明:
 * 
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * 
 */
class Solution {
    //TODO:
    /**
     * 滑动窗口来比较
     */
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if ("".equals(needle)) {
            return 0;
        }
        int i = 0;
        while (i <= haystack.length()-needle.length()) {
            if (isValid(haystack,needle,i)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private boolean isValid(String haystack, String needle, int start) {
        int i = 0;
        while (i < needle.length()) {
            if (haystack.charAt(start) != needle.charAt(i)) {
                return false;
            }
            start++;
            i++;
        }
        return true;
    }


    private void func(){
        // if (needle.equals("") || needle == null) {
        //     return 0;
        // }
        // char[] aArr = haystack.toCharArray();
        // char[] bArr = needle.toCharArray();
        // int j = 0;
        // for (int i = 0; i < aArr.length; i++) {
        //     if (aArr[i] == bArr[j]) {
        //         j++;
        //         if (j > bArr.length - 1)
        //             return i - bArr.length + 1;
        //     } else {
        //         j = 0;// 重置
        //     }

        // }
        // return -1;
    }

    private void func2(){
                // if (needle.equals("") || needle == null) {
        //     return 0;
        // }
        // char[] aArr = haystack.toCharArray();
        // char[] bArr = needle.toCharArray();
        // int j = 0;
        // int i = 0;
        // int nexti = 0;
        // /**
        //  * i,j
        //  * 如果j= 0,时  不等就 i++;
        //  * 
        //  */
        // while(i<aArr.length){
        //     if(j == 0){//j等于第一个
        //         if(aArr[i] != bArr[j]){//不等时
        //             i++;//继续往后找，找第一字符相等的情况
        //         }else{
        //             //相等时，i，j同时都往后
        //             i++;
        //             j++;
        //             nexti = i;//记住这个位置

        //         }
        //     }else if(j >= bArr.length -1){//如果是最后一个字符
        //         if(aArr[i] == bArr[j]){//最后一个字符还相等，说明找到了
        //             return i - bArr.length + 1;
        //         }else{//说明不等
        //             j = 0;//重置
        //             i = nexti;//重置回去
        //         }
        //     }else{
        //         if(aArr[i] != bArr[j]){//如果不等
        //             j = 0;//重置
        //             i = nexti;//重置回去
        //         }else{
        //             i++;
        //             j++;
        //         }
        //     }
        // }
        // return -1;
    }
}
