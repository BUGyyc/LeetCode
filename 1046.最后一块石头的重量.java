import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1046 lang=java
 *
 * [1046] 最后一块石头的重量
 */
class Solution {
    public int lastStoneWeight(int[] stones) {
        int len = stones.length;
        if (len == 0)
            return 0;
        if (len == 1)
            return stones[0];
        Arrays.sort(stones);
        int haveStoneNum = 0;
        for (int n : stones) {
            if (n > 0) {
                haveStoneNum++;
            }
        }
        // 只有一块有效石头
        if (haveStoneNum == 1) {
            return stones[len - 1];
        } else if (haveStoneNum == 0) {
            // 没有有效石头
            return 0;
        }

        // 两个最大石头相等
        if (stones[len - 1] == stones[len - 2]) {
            stones[len - 1] = 0;
            stones[len - 2] = 0;
        } else {
            // 不等
            stones[len - 1] = stones[len - 1] - stones[len - 2];
            stones[len - 2] = 0;
        }
        return lastStoneWeight(stones);
    }
}
