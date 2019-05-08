
/*
 * @lc app=leetcode.cn id=849 lang=java
 *
 * [849] Maximize Distance to Closest Person
 */
class Solution {
    // [1,0,0,0]
    //[0,0,0,0,1,0,1]
    public int maxDistToClosest(int[] seats) {
        int[] newArr = new int[seats.length + 2];
        newArr[0] = 0;
        newArr[newArr.length - 1] = 0;
        for (int i = 0; i < seats.length; i++) {
            newArr[i + 1] = seats[i];
        }
        int max = 0;
        int n = 0;
        boolean isFirst = true;
        int firstIndex = 0;
        for (int x : newArr) {
            if (x == 0) {
                n++;
                if (isFirst)
                    firstIndex++;
            } else {
                isFirst = false;
                max = Math.max(max, n);
                n = 0;
            }
        }
        int x = 0;
        if (n > 0 && n >= max) {
            x = (n - 1 > 0) ? (n - 1) : 1;
        } else {
            x = (max + 1) / 2;
        }
        x = Math.max(x, firstIndex-1);
        return x;
    }
}
