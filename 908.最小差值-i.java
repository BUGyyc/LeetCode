import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=908 lang=java
 *
 * [908] 最小差值 I
 */
class Solution {
    public int smallestRangeI(int[] A, int K) {
        Arrays.sort(A);
        int min = A[0];
        int max = A[A.length - 1];
        if (min == max) {
            return 0;
        }

        min = (K > 0) ? (min + K) : (min - K);
        max = (K <= 0) ? (max + K) : (max - K);

        return (min - max >= 0) ? 0 : (max - min);
    }
}
