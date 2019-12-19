package com.leetcode.array;

/**
 * <pre>
 * 任务：
 * 描述：
 * 作者：@author huangpeng
 * 时间：@create 2019-12-04 下午10:47
 * 类名: MaximumSubarray
 * </pre>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

 示例:

 输入: [-2,1,-3,4,-1,2,1,-5,4],
 输出: 6
 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 进阶:

 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 **/

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2,-1};
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArray(nums));
    }
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int max = dp[0];
        for(int i=0;i<dp.length;i++){
            if(dp[i]>max){
                max = dp[i];
            }
        }
        return max;
    }
    // 超时了，用动态规划做
    public int maxSubArray1(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int max = nums[0];
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(sum(nums,i,j)>max){
                    max = sum(nums,i,j);
                }
            }
        }
        return max;
    }
    public int sum(int[] nums,int i,int j){
        int sum=0;
        for(int k=i;k<=j;k++){
            sum+=nums[k];
        }
        return sum;
    }


}
