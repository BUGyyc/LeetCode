import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1122 lang=java
 *
 * [1122] 数组的相对排序
 */
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] res = new int[len1];
        int i = 0;
        int j = 0;
        for (int m : arr2) {
            for (int n : arr1) {
                if (n == m) {
                    res[i++] = m;
                }
            }
        }
        int[] temp = new int[len1 - i];
        for (int n : arr1) {
            boolean isEqual = false;
            for (int m : arr2) {
                if (n == m) {
                    isEqual = true;
                    break;
                }
            }
            if (isEqual == false) {
                temp[j++] = n;
            }
        }
        Arrays.sort(temp);
        for (int x : temp) {
            res[i++] = x;
        }
        return res;
    }
}
