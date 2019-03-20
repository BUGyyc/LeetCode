/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 报数
 *
 * https://leetcode-cn.com/problems/count-and-say/description/
 *
 * algorithms
 * Easy (48.34%)
 * Total Accepted:    23.7K
 * Total Submissions: 48.9K
 * Testcase Example:  '1'
 *
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 
 * 
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * 
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 
 * 注意：整数顺序将表示为一个字符串。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: "1"
 * 
 * 
 * 示例 2:
 * 
 * 输入: 4
 * 输出: "1211"
 * 
 * 
 */
class Solution {
    //TODO:
    public String countAndSay(int n) {
        String s="";
        if(n==1) {
            s+="1";
        }else if(n==2) {
            s+="11";
        }else if(n==3) {
            s+="21";
        }else if(n==4) {
            s+="1211";
        }else {
            String s1=countAndSay(n-1);
            char[] c=s1.toCharArray();
            int i=0;
            int j=1;
            for(j=1;j<c.length;j++) {
                if(c[i]!=c[j]) {
                    s+=(j-i)+String.valueOf(c[i]);
                    i=j;
                    if(j==c.length-1) {
                        s+=(j-i+1)+String.valueOf(c[j]);
                    }
                }else {
                    if(j==c.length-1) {
                        s+=(j-i+1)+String.valueOf(c[j]);
                    }
                }
            }
        }
        return s;
    }
}

