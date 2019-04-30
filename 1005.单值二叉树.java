import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1005 lang=java
 *
 * [1005] 单值二叉树
 */
//[2,-3,-1,5,-4]\n2
class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int n = 0;//统计负数的次数
        for(int x : A){
            if(x < 0){
                n++;
            }
        }
        if(K < n){
            for(int i=0;i<K;i++){
                A[i] = -A[i];
            }
        }else{
            for(int i=0;i<n;i++){
                A[i] = -A[i];
            }
            if((K-n)%2==1){//剩奇数次
                Arrays.sort(A);//再排一次
                A[0] = -A[0];
            }
        }
        return Arrays.stream(A).sum();
    }
}

