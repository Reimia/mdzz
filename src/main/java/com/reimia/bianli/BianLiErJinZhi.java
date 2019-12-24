package com.reimia.bianli;

import java.io.*;
import java.util.Arrays;

public class BianLiErJinZhi {
    public static void main(String[] args) {
        String path = "D:\\bianliceshi";//要遍历的路径
        String path2 = "D:\\bianliceshi.txt";//输出文件地址(如果没有则创建)
        File file = new File(path);
        File fileOut = new File(path2);
        if (fileOut.exists()) {
            if (fileOut.delete()){
                System.out.println("文件已存在，将删除后重新创建");
                //如果输出文件存在则删除文件
            }
        }
        func(file, fileOut);
    }

    private static void func(File file, File fileOut) {
        File[] fs = file.listFiles();

        assert fs != null;
        for (File f : fs) {
            if (f.isDirectory())    //若是目录，则递归打印该目录下的文件
            {
                func(f, fileOut);
            }
            if (f.isFile())        //若是文件，直接打印
            {
                System.out.println(f);//输出绝对路径
                try {
                    int length = (int) f.length();
                    FileInputStream fis = new FileInputStream(f);
                    FileOutputStream fos = new FileOutputStream(fileOut, true);

                    BufferedInputStream in = new BufferedInputStream(fis);
                    ByteArrayOutputStream out = new ByteArrayOutputStream(length);
                    byte[] temp = new byte[length];
                    while (in.read(temp) != -1) {
                        out.write(temp);
                    }
                    byte[] content = out.toByteArray();
                    System.out.println(Arrays.toString(content));//打印写入内容
                    fos.write(content);//写入
                    in.close();
                    out.close();
                    fos.close();
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
