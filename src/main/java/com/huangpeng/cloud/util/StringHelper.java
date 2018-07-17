package com.huangpeng.cloud.util;

/**
 * <pre>
 * 任务：
 * 描述：
 * 作者：@author huangpeng
 * 时间：@create 2018-02-02 下午3:43
 * 类名: StringHelper
 * </pre>
 **/

public final class StringHelper {
    public static boolean isNullOrEmpty(String string) {
        return string == null || string.equals("") || string.equalsIgnoreCase("null");
    }
}
