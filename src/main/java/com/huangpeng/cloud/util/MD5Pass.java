package com.huangpeng.cloud.util;

import java.util.ArrayList;


public class MD5Pass {
    //*************************************************字符串解密算法*************************************************
    public static String DecryptString(String str) throws Exception {
        if ((str.length() % 4) != 0) {
            throw new Exception("不是正确的编码，请检查。");
        }
        String Base64Code = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+/=";
        int page = str.length() / 4;
        ArrayList outMessage = new ArrayList(page * 3);
        char[] message = str.toCharArray();
        for (int i = 0; i < page; i++) {

            byte[] instr = new byte[4];
            instr[0] = (byte) Base64Code.indexOf(message[i * 4]);
            instr[1] = (byte) Base64Code.indexOf(message[i * 4 + 1]);
            instr[2] = (byte) Base64Code.indexOf(message[i * 4 + 2]);
            instr[3] = (byte) Base64Code.indexOf(message[i * 4 + 3]);
            byte[] outstr = new byte[3];
            outstr[0] = (byte) ((instr[0] << 2) ^ ((instr[1] & 0x30) >> 4));
            if (instr[2] != 64) {
                outstr[1] = (byte) ((instr[1] << 4) ^ ((instr[2] & 0x3c) >> 2));
            } else {
                outstr[2] = 0;
            }
            if (instr[3] != 64) {
                outstr[2] = (byte) ((instr[2] << 6) ^ instr[3]);
            } else {
                outstr[2] = 0;
            }
            outMessage.add(outstr[0]);
            if (outstr[1] != 0) {
                outMessage.add(outstr[1]);
            }
            if (outstr[2] != 0) {
                outMessage.add(outstr[2]);
            }
        }
        byte[] outbyte = new byte[outMessage.size()];
        int i = 0;
        for (Object b1 : outMessage) {
            outbyte[i] = Byte.parseByte(b1 + "");
            i++;
        }
        return new String(outbyte);
    }
//    public static void main(String[] args) throws Exception {
//        System.out.println(DecryptString("mtiZndu2"));
//    }

}