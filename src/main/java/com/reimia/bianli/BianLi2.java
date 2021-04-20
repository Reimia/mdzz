package com.reimia.bianli;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BianLi2 {
    public static void main(String[] args) {
        String path = "D:\\咕泡VIP课程完整";
        clearMp4(path);
    }

    private static void clearMp4(String path) {
        List<File> allFileByPath = getAllFileByPath(path);
        List<File> mp4 = allFileByPath.stream().filter(file -> file.getName().endsWith("mp4") || file.getName().endsWith("flv")).collect(Collectors.toList());
        mp4.forEach(File::deleteOnExit);
    }

    public static List<File> getAllFileByPath(String path) {
        List<File> fileList = new ArrayList<>();
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null != files) {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        fileList.addAll(getAllFileByPath(file2.getAbsolutePath()));
                    } else {
                        fileList.add(file2);
                    }
                }
            }
        } else {
            return fileList;
        }
        return fileList;
    }
}
