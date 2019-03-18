import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 *
 * https://leetcode-cn.com/problems/3sum/description/
 *
 * algorithms
 * Medium (19.86%)
 * Total Accepted:    33K
 * Total Submissions: 165.3K
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为：
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> allList = new ArrayList<>();
        for(int i = nums.length-1;i>=2;i--){
            for(int j = i-1,k=0;k<j;){
                int sum = nums[j] + nums[k];
                if(sum > -nums[i]){     
                    --j;
                }else if(sum < -nums[i]){
                    ++k;
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[k]);
                    list.add(nums[j]);
                    list.add(nums[i]);
                    allList.add(list);
                    do{//重复项去掉
                        ++k;
                    } while (k < j && nums[j-1] == nums[j]);
                    do{
                        --j;
                    } while (k < j && nums[k+1] == nums[k]);
                }
            }
            do{//重复项去掉
                --i;
            } while (i >= 2 && nums[i+1] == nums[i]);
        }
        return allList;
    }
}

