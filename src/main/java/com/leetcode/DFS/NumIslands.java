package com.leetcode.DFS;

/**
 * <pre>
 * 任务：
 * 描述：
 * 作者：@author huangpeng
 * 时间：@create 2019-12-01 下午10:14
 * 类名: NumIslands
 * </pre>
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 示例 1:

 输入:
 11110
 11010
 11000
 00000

 输出: 1
 **/

public class NumIslands {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        NumIslands numIslands = new NumIslands();
        System.out.println(numIslands.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        if(grid.length<1) return 0;
        int[][] marked = new int[grid.length][grid[0].length];
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1' && marked[i][j]==0){
                    dfs(grid,marked,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid,int[][] marked, int i,int j){
        if(marked[i][j] != 0) return;
        if(grid[i][j]=='0'){
            marked[i][j]=-1;
            return;
        }
        marked[i][j]=1;
        if(grid[i][j]=='1'){
            if(j<grid[i].length-1) dfs(grid,marked,i,j+1);
            if(j>0) dfs(grid,marked,i,j-1);
            if(i<grid.length-1) dfs(grid,marked,i+1,j);
            if(i>0) dfs(grid,marked,i-1,j);
        }
    }
}
