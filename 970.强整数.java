import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=970 lang=java
 *
 * [970] Powerful Integers
 */
class Solution {
    // 2\n1\n10
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        int value = 1;
        int n = 0;
        while (value < bound) {
            if (list1.contains(value) == false) {
                list1.add(value);
            }
            n++;
            if (x == 1)
                break;
            value = (int) Math.pow(x, n);
        }

        value = 1;
        n = 0;
        while (value < bound) {
            if (list2.contains(value) == false) {
                list2.add(value);
            }
            n++;
            if (y == 1)
                break;
            value = (int) Math.pow(y, n);
        }

        for (int a : list1) {
            for (int b : list2) {
                if (a + b <= bound) {
                    if (list.contains(a + b) == false) {
                        list.add(a + b);
                    }
                }
            }
        }
        return list;
    }
}
