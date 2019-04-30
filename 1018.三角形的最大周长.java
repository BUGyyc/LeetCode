/*
 * @lc app=leetcode.cn id=1018 lang=java
 *
 * [1018] 三角形的最大周长
 */
class Solution {

    public List<Boolean> prefixesDivBy5(int[] A) {
        // return extracted(A);
        List<Boolean> ans = new ArrayList<Boolean>();
        int num = 0;
        for (int a : A) {
            num = (num * 2 + a) % 5;
            ans.add(num == 0);
        }
        return ans;
    }

    // FIXME:会溢出
    private List<Boolean> extracted(int[] A) {
        List<Boolean> list = new ArrayList<>();
        double sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = getSum(i, A);
            list.add((sum % 5 == 0));
        }
        return list;
    }

    public double getSum(int end, int[] A) {
        double sum = 0;
        for (int i = 0; i < end + 1; i++) {
            sum += A[i] * Math.pow(2, end - i);
        }
        return sum;
    }
}
