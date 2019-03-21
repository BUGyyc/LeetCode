/*
 * @lc app=leetcode.cn id=447 lang=java
 *
 * [447] 回旋镖的数量
 *
 * https://leetcode-cn.com/problems/number-of-boomerangs/description/
 *
 * algorithms
 * Easy (52.40%)
 * Total Accepted:    2.8K
 * Total Submissions: 5.3K
 * Testcase Example:  '[[0,0],[1,0],[2,0]]'
 *
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k
 * 之间的距离相等（需要考虑元组的顺序）。
 * 
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 * 
 * 示例:
 * 
 * 
 * 输入:
 * [[0,0],[1,0],[2,0]]
 * 
 * 输出:
 * 2
 * 
 * 解释:
 * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * 
 * 
 */
class Solution {
    //TODO:
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            // clearing map for new search
            map.clear();
            for (int j = 0; j < points.length; j++) {
                // skipping the same point
                if (i == j) {
                    continue;
                }
                // calculating distance. We will compare distance^2 and get rid of Math.sqrt
                int distance = (points[j][0] - points[i][0])*(points[j][0] - points[i][0]) 
                    + (points[j][1] - points[i][1])*(points[j][1] - points[i][1]);
                // finding number of previously met points with the same distance to i point
                int size = map.getOrDefault(distance, 0);
                // adding that number * 2 to result, since j point can be either second or third point in the bumerang
                count += size++ * 2;
                // adding increased by 1 size back to map
                map.put(distance, size);
            }
        }
        return count;
    }
}

