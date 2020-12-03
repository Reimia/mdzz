package com.reimia.fanshe.privateField;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Reimia
 */
public class GetPrivateClass {
    public static void main(String[] args) {
        try {
            // 获取PrivateClass整个类
            Class<?> clazz = PrivateClass.class;
            // 创建一个实例
            PrivateClass pc = (PrivateClass) clazz.newInstance();
            // 获取PrivateClass所有属性
            Field[] fs = clazz.getDeclaredFields();
            for (Field f : fs) {
                // 将目标属性设置为可以访问
                f.setAccessible(true);
                System.out.println("赋值前：" + f.getName() + ":" + f.get(pc));

                //将属性值重新赋值
                f.set(pc, "null");
                System.out.println("赋值后：" + f.getName() + ":" + f.get(pc));
            }

            // 获取PrivateClass所有的方法
            Method[] ms = clazz.getDeclaredMethods();
            for (Method method : ms) {
                // 将目标属性设置为可以访问
                method.setAccessible(true);
                //输出所以方法的名称
                System.out.println("方法 ： " + method.getName());
            }
            Method m = clazz.getDeclaredMethod("getS1");
            m.setAccessible(true);
            //得到结果应该是重新赋值后的值null:null
            System.out.println("url方法返回值：" + m.invoke(pc));

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | SecurityException | NoSuchMethodException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
