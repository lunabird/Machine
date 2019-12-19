package com.leetcode.DP;

/**
 * <pre>
 * 任务：
 * 描述：给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 示例 1：
 输入: "babad"
 输出: "bab"
 注意: "aba" 也是一个有效答案。
 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 思路：动态规划法。
 第一步，找出dp数组的含义；dp[l][r]=true表示从l到r这个字符串是回文字符串；
 第二步，写出dp方程式；那么dp[l+1][r-1]必定也是个回文字符串；
        如果s(l)==s(r),dp(l)(r) = (s(l)==s(r) && (dp[l+1][r-1]))
 第三步，找到初始条件；就是边界值；
       如果只有一个字符，肯定是回文字符串，l+1=r-1  ==> r-l=2 一定是回文串；
       r-l<=2或者dp[l+1][r-1]都可以满足方程式；
       dp(l)(r) = (s(l)==s(r) && (dp[l+1][r-1] || r-l<=2))

 * 作者：@author huangpeng
 * 时间：@create 2019-11-21 下午11:38
 * 类名: LongestPalindrome
 * </pre>
 **/

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "babad";
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int maxLength = 1;
        String maxString = s.substring(0,1);
        for(int r=1;r<len;r++){
            for (int l=0;l<r;l++){
                if(s.charAt(l)==s.charAt(r) && (r-l<=2||dp[l+1][r-1])){
                    dp[l][r] = true;
                    if(r-l+1>maxLength){
                        maxLength = r-l+1;
                        maxString = s.substring(l,r+1);
                    }
                }
            }
        }
        return maxString;
    }
}
