/*
 * @lc app=leetcode.cn id=599 lang=java
 *
 * [599] 两个列表的最小索引总和
 *
 * https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/description/
 *
 * algorithms
 * Easy (43.66%)
 * Total Accepted:    2.6K
 * Total Submissions: 6.1K
 * Testcase Example:  '["Shogun","Tapioca Express","Burger King","KFC"]\n["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]'
 *
 * 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * 
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 * 
 * 示例 1:
 * 
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse",
 * "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 * 
 * 
 * 提示:
 * 
 * 
 * 两个列表的长度范围都在 [1, 1000]内。
 * 两个列表中的字符串的长度将在[1，30]的范围内。
 * 下标从0开始，到列表的长度减1。
 * 两个列表都没有重复的元素。
 * 
 * 
 */
class Solution {
    //TODO:
    public String[] findRestaurant(String[] list1, String[] list2) {
        return func1(list1,list2);
    }

    /**
     * 
     * @param list1
     * @param list2
     * @return
     */
    private String[] func1(String[] list1, String[] list2) {
        int min = 10000;
        Set<String> list = new HashSet<>();
        Map<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        for (int j = 0; j < list2.length; j++) {
            if (map1.containsKey(list2[j])) {//如果包含
                int i = map1.get(list2[j]);//拿到索引
                if (i + j < min) {//索引和小于最小值
                    min = i + j;
                    list = new HashSet<>();//重置掉之前的值
                    list.add(list2[j]);
                } else if (i + j == min) {
                    list.add(list2[j]);
                }
            }
        }
        return list.toArray(new String[0]);
    }
}
