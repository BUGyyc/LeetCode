import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=532 lang=java
 *
 * [532] 数组中的K-diff数对
 *
 * https://leetcode-cn.com/problems/k-diff-pairs-in-an-array/description/
 *
 * algorithms
 * Easy (30.14%)
 * Total Accepted:    2.8K
 * Total Submissions: 9.2K
 * Testcase Example:  '[3,1,4,1,5]\n2'
 *
 * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和
 * j 都是数组中的数字，且两数之差的绝对值是 k.
 * 
 * 示例 1:
 * 
 * 
 * 输入: [3, 1, 4, 1, 5], k = 2
 * 输出: 2
 * 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入:[1, 2, 3, 4, 5], k = 1
 * 输出: 4
 * 解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: [1, 3, 1, 5, 4], k = 0
 * 输出: 1
 * 解释: 数组中只有一个 0-diff 数对，(1, 1)。
 * 
 * 
 * 注意:
 * 
 * 
 * 数对 (i, j) 和数对 (j, i) 被算作同一数对。
 * 数组的长度不超过10,000。
 * 所有输入的整数的范围在 [-1e7, 1e7]。
 * 
 * 
 */
class Solution {
    public int findPairs(int[] nums, int k) {
        return func3(nums, k);
    }

    /**
     * 和两数之和相似， 在Map中操作
     */
    private int func1(int[] nums, int k) {
        int len = nums.length;
        if (len < 2 || k < 0)
            return 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 1);
        for (int i = 1; i < len; i++) {
            if (map.containsKey(nums[i])) {
                if (k == 0 && map.get(nums[i]) != -1) {
                    res++;
                    map.put(nums[i], -1);
                }
            } else {
                res += map.getOrDefault(nums[i] + k, 0) + map.getOrDefault(nums[i] - k, 0);
                map.put(nums[i], 1);
            }

        }
        return res;
    }

    /**
     * 排序，减少比较次数 从前往后找，
     */
    // private int func2(int[] nums, int k) {
    //     Arrays.sort(nums);
    //     int num = 0;
    //     for (int i = 0; i < nums.length - 1; i++) {
    //         for (int j = i + 1; j < nums.length; j++) {
    //             if (nums[i] + k == nums[j]) {
    //                 num++;
    //             }
    //         }
    //     }
    //     return num;
    // }

    private int func3(int[] nums,int k){
        Arrays.sort(nums);
        int len = nums.length;
        if (len < 2) return 0;
        int i = 0;
        int j = 1;
        int count = 0;
        Set<Integer> temp = new HashSet<Integer>();
        while (i < len && j < len){
            if (i == j) j++;
            else {
                if (nums[j] > nums[i] + k) i++;
                else if (nums[j] < nums[i] + k) j++;
                else{
                    // 避免出现[1,1,3,3,5]这种情况
                    if (!temp.contains(nums[i] + nums[j])){
                        temp.add(nums[i] + nums[j]);
                        count++;
                    }
                    i++;
                    j++;
                }
            }
        }
        return count;
    }
}
