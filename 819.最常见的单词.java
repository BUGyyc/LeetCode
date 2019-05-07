import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=819 lang=java
 *
 * [819] 最常见的单词
 */
class Solution {
    //TODO:
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[\\!\\?',;\\.]", " ").toLowerCase();

        HashMap<String, Integer> counts = new HashMap<>();
        Set<String> bans = Arrays.stream(banned).collect(Collectors.toSet());

        Arrays.stream(paragraph.split("\\s+")).filter(s -> !bans.contains(s))
                .forEach(s -> counts.put(s, counts.getOrDefault(s, 0) + 1));

        return counts.keySet().stream().reduce((a, b) -> counts.get(a) > counts.get(b) ? a : b).get();
    }
}
