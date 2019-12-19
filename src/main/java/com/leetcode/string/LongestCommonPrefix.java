package com.leetcode.string;

/**
 * <pre>
 * 任务：
 * 描述：
 * 作者：@author huangpeng
 * 时间：@create 2019-12-14 下午5:08
 * 类名: LongestCommonPrefix
 * </pre>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 如果不存在公共前缀，返回空字符串 ""。
 示例 1:
 输入: ["flower","flow","flight"]
 输出: "fl"
 示例 2:
 输入: ["dog","racecar","car"]
 输出: ""
 解释: 输入不存在公共前缀。
 说明:
 所有输入只包含小写字母 a-z 。
 **/

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"acc","aaa","aaba"};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length<1) return "";
        if(strs.length==1) return strs[0];
        String result = strs[0];
        for(int i=1;i<strs.length;i++){
            result = longestCommonPrefix(result,strs[i]);
            if(result.isEmpty()) break;
        }
        return result;
    }

    public String longestCommonPrefix(String str1,String str2) {
        if(str1.equals(str2)) return str1;
        if(str1.isEmpty() || str2.isEmpty()) return "";
        StringBuilder res = new StringBuilder();
        if(str1.length()<=str2.length()){
            for(int i=0;i<str1.length();i++){
                if(str1.charAt(i)==str2.charAt(i)){
                    res.append(str1.charAt(i));
                }else{
                    break;
                }
            }
        }else{
            String temp = str1;
            str1 = str2;
            str2 = temp;
            return longestCommonPrefix(str1, str2);
        }
        return res.toString();
    }
}
