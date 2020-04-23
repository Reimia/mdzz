package com.reimia.fanshe;

import javax.servlet.ServletContext;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FullPathUtil {

    public static String getClassName(Object o){
        return o.getClass().getName();
    }

    public static String getClassName(Class<? extends AbsReflectProcessor> o){
        URL resource = o.getResource("com.reimia.fanshe");
        System.out.println(resource);
        return o.getName();
    }


    public static void main(String[] args) {
//        this.getClass().getResource("com.reimia.fanshe");
//        File file =new File("com.reimia.fanshe");
//        String[] list = file.list();
//        System.out.println(list);
//        ReflectShiXian reflectShiXian = new ReflectShiXian();
//        System.out.println(getClassName(reflectShiXian));
//        System.out.println(getClassName(ReflectShiXian.class));

        Set<String> classSet = ClassUtil.getClassSet("com.reimia.futureTask");
        String property = System.getProperty("file.encoding");
        System.out.println(1);
    }
}
