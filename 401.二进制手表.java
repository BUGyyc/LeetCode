

/*
 * @lc app=leetcode.cn id=401 lang=java
 *
 * [401] 二进制手表
 *
 * https://leetcode-cn.com/problems/binary-watch/description/
 *
 * algorithms
 * Easy (44.60%)
 * Total Accepted:    2.3K
 * Total Submissions: 5K
 * Testcase Example:  '0'
 *
 * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
 * 
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * 
 * 
 * 
 * 例如，上面的二进制手表读取 “3:25”。
 * 
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 * 
 * 案例:
 * 
 * 
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16",
 * "0:32"]
 * 
 * 
 * 
 * 注意事项:
 * 
 * 
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 * 
 * 
 */
class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        if(num == 0){
            list.add("0:00");
            return list;
        }
        for (int i = 0; i <= num; i++) {// 时种取i,分钟取num-i;
            String s1 = checkSz(i);
            String s2 = checkFz(num-i);
            if (s1.equals("false") || s2.equals("false")) {
                continue;
            }else{
                list.add(s1 + ":" + s2);
            }
            
        }
        return list;
    }

    private String checkSz(int n) {
        if(n == 0){
            return "0";
        }
        int num = getNums(n);//Math.pow(2,n);
        if(num > 11){
            return "false";
        }
        return String.valueOf(num);
    }

    private String checkFz(int n) {
        if(n == 0){
            return "00";
        }
        int num = getNums(n);//Math.pow(2,n);
        if(num > 59){
            return "false";
        }
        if(num < 10){
            return "0"+num;
        }
        return String.valueOf(num);
    }

    private int getNums(int n) {
        int num = 1;
        for (int i = 0; i < n; i++) {
            num *=2;
        }
        return num;
    }
}
