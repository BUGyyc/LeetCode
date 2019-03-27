/*
 * @lc app=leetcode.cn id=605 lang=java
 *
 * [605] 种花问题
 *
 * https://leetcode-cn.com/problems/can-place-flowers/description/
 *
 * algorithms
 * Easy (26.64%)
 * Total Accepted:    3.8K
 * Total Submissions: 14.4K
 * Testcase Example:  '[1,0,0,0,1]\n1'
 *
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n
 * 朵花？能则返回True，不能则返回False。
 * 
 * 示例 1:
 * 
 * 
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 
 * 
 * 注意:
 * 
 * 
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 * 
 * 
 */
class Solution {
    //TODO:
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        return func2(flowerbed, n);
    }

    // /**
    // * 遍历数组 算0的个数 首尾想放x个1的话，首或尾部需要2x个0 中间x个1 ，则2x+1;
    // *
    // * @param flowerbed
    // * @param n
    // * @return
    // */
    // private boolean func1(int[] flowerbed, int n) {
    // int f = 0;
    // for (int x : flowerbed) {
    // if(x == 1){
    // break;
    // }
    // f++;
    // }
    // n -= (f/2);
    // for(int j = flowerbed.length-1;j>=0;j--){
    // if(flowerbed[j] == 1){
    // break;
    // }
    // }
    // n -= (flowerbed.length-1-j)/2;
    // return n>0;
    // }

    private boolean func2(int[] flowerbed, int n) {
        int cnt = 0;// 能放的花的数量
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1)
                continue;
            // 其他都是当前为0
            int pre = (i == 0) ? 0 : flowerbed[i - 1];
            int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
            if (pre == 0 && next == 0) {
                cnt++;//然后需要改为1
                flowerbed[i] = 1;
            }
        }
        return cnt>=n;
    }
}
