package com.leetcode.DP;

/**
 * <pre>
 * 任务：
 * 描述：
 * 作者：@author huangpeng
 * 时间：@create 2019-11-20 下午10:44
 * 类名: Square
 * </pre>
 **/

public class Square {
    public static void main(String[] args) {
        char[][] matrix = {{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
        Square square = new Square();
        System.out.println(square.maximalSquare(matrix));
    }

    public int maximalSquare(char[][] matrix) {
        if(matrix.length<1) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1 && i>0 && j>0){
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                }else{
                    dp[i][j] = Integer.parseInt(String.valueOf(matrix[i][j])+"");
                }
            }
        }
        int max = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(dp[i][j]>max){
                    max = dp[i][j];
                }
            }
        }
        return max*max;
    }
}
