import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=621 lang=java
 *
 * [621] 任务调度器
 */
class Solution {
    //TODO:
    public int leastInterval(char[] tasks, int n) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < 26; i++) {
            map.put('A' + i, 0);
        }
        for (int i = 0; i < tasks.length; i++) {
            char c = tasks[i];
            int x = map.get(Integer(c));
            map.put(Integer(c), x + 1);
        }

        int m = 0;
        for (int i = 0; i < 26; i++) {
            int x = map.get(i + 'A');
            if (x > 0) {
                m++;
                map.put(i + 'A', x - 1);
            }
        }

    }
}
