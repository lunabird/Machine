package com.edu.io;

import java.io.*;

/**
 * <pre>
 * 任务：
 * 描述：java io 测试
 * 作者：@author huangpeng
 * 时间：@create 2018-08-11 下午7:53
 * 类名: FileOperationTest
 * </pre>
 **/

/**
 * 正确关闭流的顺序：
 * 1. 先关闭外层，在关闭内层；
 * 2. 先打开的后关闭，后打开的先关闭；
 * 3. 看依赖关系，如果a依赖b，先关闭a再关闭b；
 */


public class FileOperationTest {

    public static void main(String[] args) {
        FileOperationTest t = new FileOperationTest();
        t.bufferedInputOutputStreamTest();
    }

    public void createFile() {
        File file = new File("/Users/huangpeng/workspace/javaproj/github/Machine/src/main/resources/files/testData.txt");
        if (file.exists()) {
            //得到文件路径
            System.out.println(file.getAbsolutePath());
            //得到文件大小
            System.out.println("文件大小：" + file.length());
        } else {
            //创建文件和创建文件夹
            File file1 = new File("/Users/huangpeng/workspace/javaproj/github/Machine/src/main/resources/files/testData.txt");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("testData.txt文件已存在。");
            }
        }
    }

    public void createDir() {
        File file2 = new File("/Users/huangpeng/workspace/javaproj/github/Machine/src/main/resources/files/sub");
        if (file2.isDirectory()) {
            System.out.println("文件夹已存在。");
        } else {
            file2.mkdir();
        }
    }

    public void listAllFiles() {
        File f = new File("/Users/huangpeng/workspace/javaproj/github/Machine/src/main/resources/files");
        if (f.isDirectory()) {
            File[] lists = f.listFiles();
            for (int i = 0; i < lists.length; i++) {
                System.out.println(lists[i].getName());
            }
        }
    }

    public void inputStreamTest() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("/Users/huangpeng/workspace/javaproj/github/Machine/src/main/resources/files/testData.txt");
            byte bytes[] = new byte[1024];
            int n = 0;
            while ((n = fis.read(bytes)) != -1) {
                String str = new String(bytes, 0, n);
                System.out.print(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void outputStreamTest() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("/Users/huangpeng/workspace/javaproj/github/Machine/src/main/resources/files/testData.txt", true);
            String str = "，潇潇雨歇";
            byte bytes[] = str.getBytes();
            fos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void fileReaderWriterTest() {
        FileReader freader = null;
        FileWriter fwriter = null;
        try {
            freader = new FileReader("/Users/huangpeng/workspace/javaproj/github/Machine/src/main/resources/files/testData.txt");
            File f1 = new File("/Users/huangpeng/workspace/javaproj/github/Machine/src/main/resources/files/testData1.txt");
            if (!f1.exists()) {
                f1.createNewFile();
            }
            fwriter = new FileWriter(f1);

            //读入到内存
            char chars[] = new char[1024];
            int n = 0;
            while ((n = freader.read(chars)) != -1) {
                fwriter.write(chars);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                freader.close();
                fwriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void bufferedReaderWriteTest() {
        BufferedReader bf = null;
        try {
            FileReader fileReader = new FileReader("/Users/huangpeng/workspace/javaproj/github/Machine/src/main/resources/files/testData.txt");
            bf = new BufferedReader(fileReader);
            String s = "";
            while ((s = bf.readLine()) != null) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void bufferedInputOutputStreamTest(){
        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;

        OutputStream outputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try{
            inputStream = new FileInputStream(new File("/Users/huangpeng/workspace/javaproj/github/Machine/src/main/resources/files/testData.txt"));
            bufferedInputStream = new BufferedInputStream(inputStream);

            outputStream = new FileOutputStream(new File("/Users/huangpeng/workspace/javaproj/github/Machine/src/main/resources/files/testData2.txt"));
            bufferedOutputStream = new BufferedOutputStream(outputStream);

            byte[] b = new byte[1024];

            int length = 0;

            while((length = bufferedInputStream.read(b))!=-1){
                bufferedOutputStream.write(b,0,length);
            }
            bufferedOutputStream.flush();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if( bufferedOutputStream != null ){
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if( bufferedInputStream != null){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
