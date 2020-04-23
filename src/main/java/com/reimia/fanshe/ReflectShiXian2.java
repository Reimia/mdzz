package com.reimia.fanshe;

import java.util.ArrayList;
import java.util.List;

public class ReflectShiXian2 extends AbsReflectProcessor{
    @Override
    public List<String> test(String s) {
        List<String> stringList = new ArrayList<>();
        stringList.add(s);
        return stringList;
    }
}
