/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 *
 * https://leetcode-cn.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (39.04%)
 * Total Accepted:    18.7K
 * Total Submissions: 47.6K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target
 * 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            // if (i == 0 || i > 0 && nums[i] == nums[i + 1]) {// 重复不需要判断
                int f = i + 1;// 头
                int e = nums.length - 1;// 尾
                while (f < e) {
                    int sum = nums[i] + nums[f] + nums[e];
                    if(Math.abs(sum - target) < Math.abs(minSum - target)){
                        minSum = sum;
                    }
                    if(sum > target){
                        // while(e > f && nums[e] == nums[e-1])//去除重复
                        //     e--;
                        e--;
                    }else if(sum < target){
                        // while(e > f && nums[f] == nums[f+1])//除去重复
                        //     f++;
                        f++;
                    }else{
                        return target;//等于目标值了
                    }
                }
            // }
        }
        return minSum;
    }
}
