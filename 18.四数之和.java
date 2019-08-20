import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c
 * + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 
 * 注意：
 * 
 * 答案中不可以包含重复的四元组。
 * 
 * 示例：
 * 
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 
 * 满足要求的四元组集合为：
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 * 
 * 
 */
class Solution {
    //类似三数之和，再加一层遍历，最后两个数字是首尾查找，注意要先排序
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> allList = new ArrayList<>();
        if (nums.length == 0)
            return allList;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;// 去掉重复的
            int newTarget = target - nums[i];
            for (int x = i + 1; x < nums.length; x++) {
                if (x > i + 1 && nums[x] == nums[x - 1])
                    continue;
                int newTarget2 = newTarget - nums[x];
                int f = x + 1;
                int e = nums.length - 1;
                while (f < e) {
                    if (newTarget2 == nums[f] + nums[e]) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[x]);
                        list.add(nums[f]);
                        list.add(nums[e]);
                        allList.add(list);
                        while (f < e && nums[f] == nums[f + 1])
                            ++f; // 注意去重
                        while (f < e && nums[e] == nums[e - 1])
                            --e;
                        f++;
                        e--;
                    } else if (newTarget2 < nums[f] + nums[e]) {
                        // while (f < e && nums[e] == nums[e - 1])
                        // e--;
                        e--;
                    } else if (newTarget2 > nums[f] + nums[e]) {
                        // while (f < e && nums[f] == nums[f + 1])
                        // f++;
                        f++;
                    }
                }
            }
        }
        return allList;
    }
}
