

/*
 * @lc app=leetcode.cn id=390 lang=java
 *
 * [390] 消除游戏
 */
class Solution {
    public int lastRemaining(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        boolean isLeft = true;
        return execute(list, isLeft);
    }

    private int execute(ArrayList<Integer> list, boolean isLeft) {
        if (list.size() == 1) {
            return list.get(0);
        }
        if (isLeft) {
            int start = 0;
            while (start <= list.size() - 1) {
                list.remove(start);
                start += 2;
            }
        } else {
            int end = list.size() - 1;
            while (end >= 0) {
                list.remove(end);
                end -= 2;
            }
        }
        isLeft = !isLeft;
        return execute(list, isLeft);
    }
}
