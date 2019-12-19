package com.leetcode.DP;

/**
 * <pre>
 * 任务：
 * 描述：
 * 作者：@author huangpeng
 * 时间：@create 2019-11-24 下午3:41
 * 类名: ClimbStairs
 * </pre>
 **/

public class ClimbStairs {
    public static void main(String[] args) {

    }
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<n+1;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
