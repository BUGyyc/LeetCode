import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1037 lang=java
 *
 * [1037] 有效的回旋镖
 */
class Solution {
    // [[0,1],[0,2],[1,2]]
    // [[1,1],[2,3],[3,2]]
    public boolean isBoomerang(int[][] points) {
        // return extracted(points);
        // return extracted2(points);
        double a = Math.sqrt(Math.pow(points[1][0] - points[0][0], 2) + Math.pow(points[1][1] - points[0][1], 2));
        double b = Math.sqrt(Math.pow(points[2][0] - points[1][0], 2) + Math.pow(points[2][1] - points[1][1], 2));
        double c = Math.sqrt(Math.pow(points[2][0] - points[0][0], 2) + Math.pow(points[2][1] - points[0][1], 2));
        double[] arr = new double[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        Arrays.sort(arr);
        return arr[0] + arr[1] > arr[2];
    }

    private boolean extracted2(int[][] points) {
        // 相同点
        for (int i = 1; i < 3; i++) {
            if (points[i - 1][0] == points[i][0] && points[i - 1][1] == points[i][1]) {
                return false;
            }
        }
        // 一条线
        if ((points[0][0] == points[1][0] && points[1][0] == points[2][0])
                || (points[0][1] == points[1][1] && points[1][1] == points[2][1])) {
            return false;
        }
        return true;
    }

    private boolean extracted(int[][] points) {
        for (int i = 1; i < 3; i++) {
            if (points[i - 1][0] == points[i][0] && points[i - 1][1] == points[i][1]) {
                return false;
            }
        }
        if (points[0][0] == points[2][0] && points[0][1] == points[2][1]) {
            return false;
        }
        // if ((points[2][0] - points[1][0]) / (points[2][1] - points[1][1]) ==
        // (points[1][0] - points[0][0])
        // / (points[1][1] - points[0][1])) {
        // return false;
        // }
        int disX = (points[1][0] - points[0][0]);// 差值x
        if (disX != 0) {
            int k = (points[1][1] - points[0][1]) / disX;
            if (points[2][1] - points[1][1] == k * (points[2][0] - points[1][0])) {
                return false;// k系数一样
            }
        } else {
            disX = (points[2][0] - points[1][0]);// 这次绝对不为0，如果这也是零，说明在一条直线

            int k = (points[1][1] - points[0][1]) / disX;
            if (points[2][1] - points[1][1] == k * (points[2][0] - points[1][0])) {
                return false;// k系数一样
            }
        }
        // disX = (disX == 0)?(points[1][0] - points[0][0])
        // if ((points[2][0] - points[1][0]) * (points[1][0] - points[0][0]) ==
        // (points[2][1] - points[1][1])
        // * (points[1][1] - points[0][1])) {
        // return false;
        // }

        // if (points[2][0] / points[1][0] == points[1][0] / points[0][0]
        // && points[2][1] / points[1][1] == points[1][1] / points[0][1]) {
        // return false;
        // }
        return true;
    }
}
