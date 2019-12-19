package com.leetcode.DFS;

/**
 * <pre>
 * 任务：
 * 描述：
 * 作者：@author huangpeng
 * 时间：@create 2019-11-28 下午11:55
 * 类名: NQueen
 * </pre>
 **/

public class NQueen {
    static int n=4;
    static int[] pos = new int[10]; //每一层的皇后放在哪个位置上
    static int total = 0;
    static boolean[][] visited = new boolean[3][10];

    public static void main(String[] args) {
        dfs(0);
    }

    static void dfs(int cur){
        if(cur==n){//遍历完了，要输出
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(pos[i]==j)
                        System.out.print("Q");
                    else
                        System.out.print("*");
                    if(j==n-1)
                        System.out.println();
                }
                total++;
                if(total%n==0)
                    System.out.println();
            }
        }else{
            // 因为是一行一行的放置元素，所以不需要判断行冲突；
            // 判断列冲突时，可以通过设置一个布尔数组，如果已经有皇后放入，就把bool值设成false，否则设置为true；
            // 判断对角线冲突，格子中x+y的值相等是副对角线，x-y=0是主对角线；
            // 假设我们把第cur个皇后放在了pos[cur]，那么只需判断所检查的从前往后数第k个皇后有没有冲突就行了。
            for(int i=0;i<n;i++){
                if(!visited[0][i] && !visited[1][cur+i] && !visited[2][cur-i+n]){
                    pos[cur]=i;
                    System.out.println("cur="+cur+",i="+i);
                    visited[0][i]=true;
                    visited[1][cur+i]=true;
                    visited[2][cur-i+n]=true;
                    print();
                    dfs(cur+1);
                    visited[0][i]=false;
                    visited[1][cur+i]=false;
                    visited[2][cur-i+n]=false;
                    print();
                }
            }
        }
    }
    static void print(){
        for(int i=0;i<visited.length;i++){
            for (int j=0;j<visited[i].length;j++){
                if(j!=visited[i].length-1)
                    System.out.print(visited[i][j]==true?"T":"F");
                else
                    System.out.println();
            }
        }
        System.out.println();
    }
}
