package com.leetcode.BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 * 任务：
 * 描述：给定一个非负整数数组，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度。
        你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 示例:
 输入: [2,3,1,1,4]
 输出: 2
 解释: 跳到最后一个位置的最小跳跃数是 2。
      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 链接：https://leetcode-cn.com/problems/jump-game-ii
 思路：广度优先搜索，从第一个节点开始，把它可达的节点按照从跨度从大到小放入一个队列；
      定义数组visited来记录该节点是否已经被达到过；
      每次从队列头部取出一个节点，判断该节点加上nums[head.index]是否能够到达数组结尾，
      如果能到达，则走的最少步数就是树的高度，即head.step+1;
      如果尚未到达，并且该节点还没有在队列中，则把该节点加入到队列中；
 * 作者：@author huangpeng
 * 时间：@create 2019-11-19 下午11:14
 * 类名: JumGame
 * </pre>
 **/
public class JumGame {

    public int jump(int[] nums) {
        if (nums.length==1) return 0;
        int[] visited = new int[nums.length];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0,0));
        while(queue.size()>0){
            Node head = queue.poll();
            for(int i=nums[head.index];i>0;i--){
                if(head.index + i >= nums.length-1){
                    return head.step+1;
                }
                if(visited[head.index+i] == 0){
                  queue.offer(new Node(head.step+1, head.index+i));
                  visited[head.index+i] = 1;
                }
            }
        }
        return 0;
    }

    class Node{
        int step;
        int index;
        public Node(int step, int index){
            this.step = step;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        JumGame jumGame = new JumGame();
        int[] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        System.out.println(jumGame.jump(nums));
    }
}
