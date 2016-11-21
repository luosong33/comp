package cn.newtouch;

/**
 * Created by Administrator on 2016/11/16.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Comp {

    public static void main(String[] args) {
//        String strRet = readfile1("E:\\picc\\project\\file\\prppmain.txt", "E:\\picc\\project\\file\\bj1100prp3gdb.prppmain.insert.201611081710.sql");
        String strRet = readfile1("E:\\picc\\project\\file\\bj1100prp3gdb.prppmain.insert.201611081710.sql", "E:\\picc\\project\\file\\prppmain.txt");
//        String s = readfile2("E:\\picc\\project\\file\\bj1100prp3gdb.prppmain.insert.201611081710.sql");
//        System.out.println(s);
    }

    private static String readfile1(String filepath, String filepath2) {
        FileInputStream fis = null; // 从文件系统中的某个文件中获得输入字节。用于读取诸如图像数据之类的原始字节流。要读取字符流，请考虑使用 FileReader。
        InputStreamReader isr = null; // InputStreamReader 是字节流通向字符流的桥梁,
        BufferedReader br = null; //用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。
        String strRet = "";
        try {
            String regEx = "";
            fis = new FileInputStream(filepath);// FileInputStream
            // 从文件系统中的某个文件中获取字节
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象

            String str2 = readfile2(filepath2); // 文件2
            /*while ((regEx = br.readLine()) != null) {
                // if (regEx.contains(str2)){
                if (Pattern.compile(spl, Pattern.CASE_INSENSITIVE).matcher(str2).find()) { // 匹配成功
                    // System.out.println(regEx);
                    continue;
                } else {
                    System.out.println(regEx);
                    strRet += spl + "\n";
                }
            }*/
            while ((regEx = br.readLine()) != null) {
                String[] split = regEx.split(" ");
                for (String spl : split) {
//                    System.out.println(spl);
                    if (spl != null && spl != "") { // 文件1 不为空时再比对
                        if (Pattern.compile(spl, Pattern.CASE_INSENSITIVE).matcher(str2).find()) { // 匹配成功
                            // System.out.println(regEx);
                            break;
                        } else {
                            System.out.println(spl); // 筛选成功
                            strRet += spl + "\n";
                            break;
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("找不到指定文件");
        } catch (IOException e) {
            System.out.println("读取文件失败");
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
                // 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return strRet;
    }

    private static String readfile2(String filepath2) {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        String strRet = "";
        try {
            fis = new FileInputStream(filepath2);// FileInputStream
            // 从文件系统中的某个文件中获取字节
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象

            String str2 = "";
            // 当读取的一行不为空时,把读到的str的值赋给str1
            while ((str2 = br.readLine()) != null) {
                strRet += str2;
            }
            /*while ((str2 = br.readLine()) != null) {
                String[] split = str2.split(" ");
                for (String sf : split) {
                    if (sf != null && sf != "") {
                        System.out.println(sf);
                        strRet += sf;
                        break;
                    } else {
                        continue;
                    }
                }
            }*/
        } catch (FileNotFoundException e) {
            System.out.println("找不到指定文件");
        } catch (IOException e) {
            System.out.println("读取文件失败");
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
                // 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return strRet;
    }


    private static String[] readfile2_(String filepath2) {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        ArrayList<String> list;
        String[] strArr = null;
        try {
            String str1 = "";
            fis = new FileInputStream(filepath2);// FileInputStream
            // 从文件系统中的某个文件中获取字节
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);// 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象

            // 当读取的一行不为空时,把读到的str的值赋给str1
            list = new ArrayList<String>();
            while ((str1 = br.readLine()) != null) {
                list.add(str1);
                strArr = new String[list.size()];
                strArr = list.toArray(strArr);
            }
        } catch (FileNotFoundException e) {
            System.out.println("找不到指定文件");
        } catch (IOException e) {
            System.out.println("读取文件失败");
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
                // 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return strArr;
    }


}