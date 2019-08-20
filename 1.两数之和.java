import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import sun.tools.jar.resources.jar_sv;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 
 * 示例:
 * 
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 
 * 
 */
class Solution {

    public int[] twoSum(int[] nums, int target) {
        return func1(nums, target);
    }

    /**
     * target - x 目标差值 若存在，说明有解 关键在map.get(x)、map.put((target-x), i)
     */
    private int[] func1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (map.get(x) != null) {// 直接找 目标差值 （target-x）
                arr[1] = i;
                arr[0] = map.get(nums[i]);
                return arr;
            } else {
                map.put((target - x), i);// 存索引
            }
        }
        return null;
    }

    /**
     * 方法2： 遍历数组，看是否存在,效率不高
     */
    private int[] func2(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return null;
    }

    private int[] func3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] newArr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i])!=null){//如果目标值存在
                newArr[1] = i;
                newArr[0] = map.get(nums[i]);
                return newArr;
            }else{
                map.put(target-nums[i], i);//target-nums[i]就是下一个目标值，
            }
        }
        return null;
    }
}
