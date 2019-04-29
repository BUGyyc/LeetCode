/*
 * @lc app=leetcode.cn id=836 lang=java
 *
 * [836] 赛车
 */
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if(rec1[0] < rec2[0]){
            if(rec1[1] < rec2[1])
                return rec1[2] > rec2[0] && rec1[3] > rec2[1];
            else
                return rec1[2] > rec2[0] && rec1[1] < rec2[3];
        }
        else{
            if(rec2[1] < rec1[1])
                return rec2[2] > rec1[0] && rec2[3] > rec1[1];
            else
                return rec2[2] > rec1[0] && rec2[1] < rec1[3];
        }
    }
}

