/*
 * @lc app=leetcode.cn id=506 lang=java
 *
 * [506] 相对名次
 *
 * https://leetcode-cn.com/problems/relative-ranks/description/
 *
 * algorithms
 * Easy (46.99%)
 * Total Accepted:    2K
 * Total Submissions: 4.2K
 * Testcase Example:  '[5,4,3,2,1]'
 *
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold
 * Medal", "Silver Medal", "Bronze Medal"）。
 * 
 * (注：分数越高的选手，排名越靠前。)
 * 
 * 示例 1:
 * 
 * 
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal"
 * and "Bronze Medal").
 * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 * 
 * 提示:
 * 
 * 
 * N 是一个正整数并且不会超过 10000。
 * 所有运动员的成绩都不相同。
 * 
 * 
 */
class Solution {
    public String[] findRelativeRanks(int[] nums) {
        /**
         * 用一个数组来排序
         * 将索引作为排名的依据
         * 最后将结果存到原数组中
         */
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            tmp[i] = nums[i];
        }
        Arrays.sort(tmp);
        Map<Integer, String> rankMap = new HashMap();
        int len = nums.length;
        for (int i = len-1; i >= 0; i--){
            if (i == len-1) rankMap.put(tmp[i], "Gold Medal");
            else if (i == len-2) rankMap.put(tmp[i], "Silver Medal");
            else if (i == len-3) rankMap.put(tmp[i], "Bronze Medal");
            else rankMap.put(tmp[i], String.valueOf(len-i));
        }
        String[] result = new String[len];
        for (int i = 0; i < len; i++){
            result[i] = rankMap.get(nums[i]);
        }
        return result;
    }
}

