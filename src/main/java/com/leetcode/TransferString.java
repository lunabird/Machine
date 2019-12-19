package com.leetcode;

/**
 * <pre>
 * 任务：
 * 描述：
 * 作者：@author huangpeng
 * 时间：@create 2019-11-24 下午12:42
 * 类名: TransferString
 * </pre>
 **/

public class TransferString {
    public static void main(String[] args) {
        String s = "MyNameIsTom";
        System.out.println(trans(s));
    }

    public static String trans(String s){
        String result = "";
        char[] ch = s.toCharArray();
        int start = 0;
        int end = s.length();
        for (int i=0;i<ch.length;i++){
            if(i!=0 && ch[i]>='A' && ch[i]<='Z'){
                StringBuilder temp = new StringBuilder(s.substring(start,i));
                start = i;
                result += temp.reverse().toString();
            }
        }
        result += new StringBuilder(s.substring(start,end)).reverse().toString();
        return result;
    }
}
