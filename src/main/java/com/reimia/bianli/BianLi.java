package com.reimia.bianli;

import java.io.*;

public class BianLi {

    public static void main(String[] args) {
        String path = "D:\\bianliceshi";//要遍历的路径
        String path2 = "D:\\bianliceshi.txt";//输出文件地址(如果没有则创建)
        File file = new File(path);
        File fileOut = new File(path2);
        if (fileOut.exists()) {
            fileOut.delete();//如果输出文件存在则删除文件
        }
        func(file, fileOut);
    }

    private static void func(File file, File fileOut) {
        File[] fs = file.listFiles();

        assert fs != null;
        for (File f : fs) {
            if (f.isDirectory())    //若是目录，则递归打印该目录下的文件
            {
                System.out.println(f.getName()+"我是文件夹名字");
                func(f, fileOut);
            }
            if (f.isFile())        //若是文件，直接打印
            {
                System.out.println(f);//输出绝对路径
                try (FileReader reader = new FileReader(f);
                     BufferedReader br = new BufferedReader(reader)) {
                    String line;

                    if (!fileOut.exists()) {
                        fileOut.createNewFile(); // 如果输出文件不知道则创建新文件
                    }
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);//按行输出文本内容
                        BufferedWriter out = new BufferedWriter(new FileWriter(fileOut, true));
                        out.write(line);
                        out.flush();
                        out.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
