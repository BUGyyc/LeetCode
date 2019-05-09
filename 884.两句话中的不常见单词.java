import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=884 lang=java
 *
 * [884] 两句话中的不常见单词
 */
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        String[] arr1 = A.split("\\s+");
        String[] arr2 = B.split("\\s+");
        Map<String, Integer> map1 = new HashMap<>();
        for (String s : arr1) {
            if (map1.containsKey(s)) {
                int n = map1.get(s);
                map1.put(s, n + 1);
            } else {
                map1.put(s, 1);
            }
        }
        for (String s : arr2) {
            if (map1.containsKey(s)) {
                int n = map1.get(s);
                map1.put(s, n + 1);
            } else {
                map1.put(s, 1);
            }
        }
        ArrayList<String> list = new ArrayList<>();
        for (String key : map1.keySet()) {
            if (map1.get(key) == 1) {
                list.add(key);
            }
        }
        String[] strings = new String[list.size()];
        return list.toArray(strings);
    }
}
