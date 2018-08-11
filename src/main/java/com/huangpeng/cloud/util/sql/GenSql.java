package com.huangpeng.cloud.util.sql;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre>
 * 任务：
 * 描述：生成可以重复执行的脚本
 * 作者：@author huangpeng
 * 时间：@create 2018-07-17 下午2:43
 * 类名: GenSql
 * </pre>
 **/
public class GenSql {

    public static void main(String[] args){
        GenSql a = new GenSql();

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddHHMM");
        String pre = dateformat.format(new Date());

        String conf_query_path = "/Users/huangpeng/workspace/javaproj/github/Machine/src/main/resources/mysql_conf_query.txt";
        String ac_interface_path = "/Users/huangpeng/workspace/javaproj/github/Machine/src/main/resources/mysql_ac_interface.txt";
        String conf_condition_path = "/Users/huangpeng/workspace/javaproj/github/Machine/src/main/resources/mysql_conf_condition.txt";
        String conf_content_path = "/Users/huangpeng/workspace/javaproj/github/Machine/src/main/resources/mysql_conf_content.txt";

        String conf_query_result = "/Users/huangpeng/workspace/javaproj/github/Machine/src/main/resources/result/"+pre+"02"+"_CONF_QUERY_RELATION_INSERT.SQL";
        String ac_interface_result = "/Users/huangpeng/workspace/javaproj/github/Machine/src/main/resources/result/"+pre+"01"+"_AC_INTERFACE_INSERT.SQL";
        String conf_condition_result = "/Users/huangpeng/workspace/javaproj/github/Machine/src/main/resources/result/"+pre+"03"+"_CONF_CONDITION_RELATION_INSERT.SQL";
        String conf_content_result = "/Users/huangpeng/workspace/javaproj/github/Machine/src/main/resources/result/"+pre+"04"+"_CONF_CONTENT_RELATION_INSERT.SQL";

        String[] colArr0 = {"INTERFACE_ID"};
        String[] colArr1 = {"STANDARD_CODE","TERM_CODE"};
        String[] colArr2 = {"INTERFACE_ID","COLUMN_NAME"};

        a.readFile(ac_interface_path,ac_interface_result,colArr1);
//        a.readFile(conf_query_path,conf_query_result,colArr0);
//        a.readFile(conf_condition_path,conf_condition_result,colArr1);
//        a.readFile(conf_content_path,conf_content_result,colArr2);
    }



    public String dealWithString(String originStr,String[] colArr){
        String column1 = colArr[0];
        String column2 = colArr[1];
        int colIndex1 = 0;
        int colIndex2 = 0;
        String resultStr = "";
        String tableName = originStr.substring(originStr.lastIndexOf("insert into")+11,originStr.indexOf("(")).trim();
        String[] temp = originStr.split("values\\(");
        String secondPart = "select "+temp[1].replaceAll("\\);"," ").trim()+" from dual WHERE NOT EXISTS (SELECT 1 FROM "+tableName;
        String firstPart = temp[0].split("\\(")[1].trim().split("\\)")[0];
        String[] cols = firstPart.split(",");
        for (int i = 0; i < cols.length; i++) {
            if(cols[i].trim().replaceAll("`"," ").trim().equalsIgnoreCase(column1)){
                colIndex1 = i;
            }
            if(cols[i].trim().replaceAll("`"," ").trim().equalsIgnoreCase(column2)){
                colIndex2 = i;
            }
        }
        String[] colvals = temp[1].split("\\);")[0].split(",");
        String val1 = colvals[colIndex1].trim();
        String val2 = colvals[colIndex2].trim();
        String thirdPart = " WHERE "+column1+" = "+val1+" "+" AND "+column2+" = "+val2+");";
        System.out.println(temp[0]+secondPart+thirdPart);
        return temp[0]+secondPart+thirdPart;
    }

    public String dealWithStringOne(String originStr,String[] colArr){
        String column1 =colArr[0];
        int colIndex1 = 0;
        String resultStr = "";
        String tableName = originStr.substring(originStr.lastIndexOf("insert into")+11,originStr.indexOf("(")).trim();
        String[] temp = originStr.split("values\\(");
        String secondPart = "select "+temp[1].replaceAll("\\);"," ").trim()+" from dual WHERE NOT EXISTS (SELECT 1 FROM "+tableName;
        String firstPart = temp[0].split("\\(")[1].trim().split("\\)")[0];
        String[] cols = firstPart.split(",");
        for (int i = 0; i < cols.length; i++) {
            if(cols[i].trim().replaceAll("`"," ").trim().equalsIgnoreCase(column1)){
                colIndex1 = i;
            }
        }
        String[] colvals = temp[1].split("\\);")[0].split(",");
        String val1 = colvals[colIndex1].trim();
        String thirdPart = " WHERE "+column1+" = "+val1+" "+");";
        System.out.println(temp[0]+secondPart+thirdPart);
        return temp[0]+secondPart+thirdPart;
    }

    public void readFile(String pathName,String resultPath,String[] colArr){
        File file=new File(pathName);
        BufferedReader reader=null;
        String temp=null;
        int line=1;
        try{
            reader=new BufferedReader(new FileReader(file));
            while((temp=reader.readLine())!=null){
                if(colArr.length==1){
                    String res = dealWithStringOne(temp,colArr);
                    writeFile(resultPath, res);
                }else if(colArr.length==2){
                    String res = dealWithString(temp,colArr);
                    writeFile(resultPath, res);
                }
                line++;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(reader!=null){
                try{
                    reader.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }

    }

    public void writeFile(String path, String conent) {
        File file = new File(path);
        BufferedWriter out = null;
        try {
            //如果文件不存在，则创建新的文件
            if(!file.exists()){
                file.createNewFile();
            }
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file, true)));
            out.write(conent+"\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
