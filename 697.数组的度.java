/*
 * @lc app=leetcode.cn id=697 lang=java
 *
 * [697] 数组的度
 *
 * https://leetcode-cn.com/problems/degree-of-an-array/description/
 *
 * algorithms
 * Easy (44.59%)
 * Total Accepted:    2.7K
 * Total Submissions: 6K
 * Testcase Example:  '[1,2,2,3,1]'
 *
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * 
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释: 
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 * 
 * 
 * 注意:
 * 
 * 
 * nums.length 在1到50,000区间范围内。
 * nums[i] 是一个在0到49,999范围内的整数。
 * 
 * 
 */
class Solution {
    //TODO:
    static class Num {
        int num;
        int start;
        int end;
        int degree;
        
        public Num(int num, int index) {
            this.num = num;
            this.start = index;
            this.end = index;
            this.degree = 1;
        }
    }
    
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Num> map = new HashMap<>();
        int degree = 0, count = Integer.MAX_VALUE, curCount = 0, value = 0;
        Num cur = null;
        
        for(int i = 0; i < nums.length; ++i) {
            value = nums[i];
            if(!map.containsKey(value)) {
                cur = new Num(value, i);
                map.put(value, cur);
            } else {
                cur = map.get(value);
                cur.degree++;
                cur.end = i;
            }
            
            if(cur.degree > degree) {
                degree = cur.degree;
                count = cur.end - cur.start + 1;
            } else if(cur.degree == degree && count > (cur.end - cur.start + 1)) {
                count = cur.end - cur.start + 1;
            }
        }
        return count;
    }
}

