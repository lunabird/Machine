package com.leetcode.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <pre>
 * 任务：
 * 描述：
 * 作者：@author huangpeng
 * 时间：@create 2019-11-27 下午9:58
 * 类名: TopologicSort
 * </pre>
 * 4, [[1,0],[2,0],[3,1],[3,2]]
 **/

public class TopologicSort {
    public static void main(String[] args) {

    }
    boolean hasCycle = false;
    Stack<Integer> stack = new Stack<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] isInStack = new boolean[numCourses];
        List<Integer>[] adj = (List<Integer>[]) new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            adj[i]=new ArrayList<>();
        for(int i=0;i<prerequisites.length;i++)
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        for(int i=0;i<numCourses;i++)
            if(!visited[i]) dfs(i,visited,isInStack,adj);
        if(hasCycle) return new int[0];
        int[] res=new int[stack.size()];
        for(int i=0;i<res.length;i++)
            res[i]=stack.pop();
        return res;
    }
    void dfs(int v,boolean[] visited, boolean[] isInStack,List<Integer>[] adj) {
        visited[v]=true;
        isInStack[v]=true;
        for(Integer i:adj[v])
            if(hasCycle) {
                return;
            }
            else if(!visited[i]){
                dfs(i,visited,isInStack,adj);
            }
            else if(isInStack[i]){
                hasCycle=true;
            }
        isInStack[v]=false;
        stack.push(v);
    }
}
