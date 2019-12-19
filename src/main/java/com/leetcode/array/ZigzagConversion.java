package com.leetcode.array;

/**
 * <pre>
 * 任务：
 * 描述：
 * 作者：@author huangpeng
 * 时间：@create 2019-12-11 下午10:47
 * 类名: ZigzagConversion
 * </pre>
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

 L   C   I   R
 E T O E S I I G
 E   D   H   N
 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

 请你实现这个将字符串进行指定行数变换的函数：

 string convert(string s, int numRows);
 示例 1:

 输入: s = "LEETCODEISHIRING", numRows = 3
 输出: "LCIRETOESIIGEDHN"
 LDREOEIIECIHNTSG
 "PAYPALISHIRING"
 5
 **/

public class ZigzagConversion {
    public static void main(String[] args) {
        ZigzagConversion zigzagConversion = new ZigzagConversion();
        System.out.println(zigzagConversion.getCol(14,5));

    }
    public String convert(String s, int numRows) {
        if(s==null || s.isEmpty() || numRows==1 || s.length()<=numRows) return s;
        int col = getCol(s.length(),numRows);
        char[][] arr = new char[numRows][col];
        int index = 0;
        for(int j=0;j<col;j++){
            if(j%(numRows-1)==0){
                for(int i=0;i<numRows;i++){
                    if(index<s.length()) arr[i][j] = s.charAt(index++);
                    else arr[i][j] = ' ';
                }
            }else{
                int m = j%(numRows-1);
                for(int i=0;i<numRows;i++){
                    if(i==numRows-1-m){
                        if(index<s.length()) arr[i][j] = s.charAt(index++);
                        else arr[i][j] = ' ';
                    }else{
                        arr[i][j] = ' ';
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numRows;i++){
            for(int j=0;j<col;j++){
                sb.append(arr[i][j]!=' '?arr[i][j]:"");
            }
        }
        return sb.toString();
    }
    public int getCol(int length, int numRows) {
        int group  = length / (numRows + (numRows - 2));
        int m = 0;
        int mod = length % (numRows + (numRows - 2));
        if (mod != 0) {
            if (mod < numRows) {
                m = 1;
            }
            else {
                m = mod % numRows + 1;
            }
        }
        int column = group * (numRows - 1) + m;
        return column;
    }
}
