import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1029 lang=java
 *
 * [1029] 两地调度
 */
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        return extracted(costs);
    }

    private int extracted(int[][] costs) {
        int len = costs.length;
        int[] needA = new int[len];
        int[] needB = new int[len];
        int i = 0;
        int j = 0;
        for (int[] arr : costs) {
            needA[i++] = arr[0];
            needB[j++] = arr[1];
        }
        Arrays.sort(needA);
        Arrays.sort(needB);
        int cost = 0;
        for (int x = 0; x < len / 2; x++) {
            cost += needA[x] + needB[x];
        }
        return cost;
    }
}
