package com.leetcode;

import java.util.Arrays;

/**
 * <pre>
 * 任务：
 * 描述：求让数组有序的最小交换次数。
 * 思路：先把数组排序，然后一一对比原始数组和排好序的数组同一位置的元素是否相等；
 *      如果相等，继续到下一个位置比对，直到数组所有元素比对完成；
 *      如果不等，说明需要一次交换操作，找出b[i]的值在a中的下标j，然后交换a[i]和a[j],count计数加一；
 *      例如[2,0,1]
 *      [0,2,1] -> [0,1,2] 需要2次交换
 * 作者：@author huangpeng
 * 时间：@create 2019-11-24 下午1:07
 * 类名: ExchangeSort
 * </pre>
 **/

public class ExchangeSort {
    public static void main(String[] args) {
        int[] a = {2, 3, 1, 5, 6, 4};
        System.out.println(exchange(a));
    }

    public static int exchange(int[] a){
        int[] b = Arrays.copyOf(a,a.length);
        Arrays.sort(b);
        int count = 0;
        for (int i=0;i<a.length;i++){
            if(a[i] == b[i]){
                continue;
            }
            for(int j=0;j<a.length;j++){
                if(a[j]==b[i]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    count++;
                }
            }
        }
        return count;
    }
}
