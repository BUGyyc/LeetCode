import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=821 lang=java
 *
 * [821] 打砖块
 */
class Solution {
    public int[] shortestToChar(String S, char C) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                list.add(i);
            }
        }
        int[] arr = new int[S.length()];
        for (int j = 0; j < S.length(); j++) {
            int min = Integer.MAX_VALUE;
            for(int n : list){
                min = Math.min(min,Math.abs(j-n));
            }
            arr[j] = min;
        }
        return arr;
    }
}
