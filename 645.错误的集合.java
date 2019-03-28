

/*
 * @lc app=leetcode.cn id=645 lang=java
 *
 * [645] 错误的集合
 *
 * https://leetcode-cn.com/problems/set-mismatch/description/
 *
 * algorithms
 * Easy (33.66%)
 * Total Accepted:    2.5K
 * Total Submissions: 7.3K
 * Testcase Example:  '[1,2,2,4]'
 *
 * 集合 S 包含从1到 n
 * 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 * 
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * 
 * 示例 1:
 * 
 * 
 * 输入: nums = [1,2,2,4]
 * 输出: [2,3]
 * 
 * 
 * 注意:
 * 
 * 
 * 给定数组的长度范围是 [2, 10000]。
 * 给定的数组是无序的。
 * 
 * 
 */
class Solution {
    // TODO:
    public int[] findErrorNums(int[] nums) {
        return func2(nums);
    }

    // /**
    //  * 排序 对应索引来比较值
    //  * 
    //  * @param nums
    //  * @return
    //  */
    // private int[] extracted(int[] nums) {
    //     int[] newArr = new int[2];
    //     Arrays.sort(nums);
    //     int index = 0;// 记录出错的索引
    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[i] != i + 1) {
    //             index = i;
    //             break;
    //         }
    //     }
    //     newArr[0] = nums[index];
    //     if (index == 0) {
    //         newArr[1] = 1;
    //     } else if (index == nums.length - 1) {
    //         newArr[1] = nums.length;
    //     } else if (nums[index + 1] - nums[index] > 1) {
    //         newArr[1] = nums[index + 1] - 1;
    //     } else if (nums[index] - nums[index - 1] > 1) {
    //         newArr[1] = nums[index - 1] + 1;
    //     }
    //     return newArr;
    // }

    /**
     * TODO:
     * @param nums
     * @return
     */
    private int[] func2(int[] nums) {
        int[] newnum = new int[nums.length + 1];//多记录一位，因为有重复一位
        int repeat = 0;
        int loss = 0;
        for (int i = 0; i < nums.length; i++) {
            if (newnum[nums[i]] == 0) {//把出现1次的位置变成1
                newnum[nums[i]] = 1;
            } else {
                newnum[nums[i]] = 2;//出现两次的位置变为2
            }
        }
        for (int i = 1; i < newnum.length; i++) {
            if (newnum[i] == 0) {//没出现的数字就是0
                loss = i;
            } else if (newnum[i] == 2) {//出现两次的数字就是2
                repeat = i;
            }
        }
        int[] res = new int[2];
        res[0] = repeat;
        res[1] = loss;
        return res;
    }
}
