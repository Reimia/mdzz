package com.reimia.xmlResolve;

import com.thoughtworks.xstream.XStream;

public class Ceshi {
    public static Object toBean(Class<?> clazz, String xml) {
        Object xmlObject = null;
        XStream xstream = new XStream();
        xstream.processAnnotations(clazz);
        xstream.autodetectAnnotations(true);
        xmlObject= xstream.fromXML(xml);
        return xmlObject;
    }

    public static void main(String[] args) {
        String a = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<c c1=\"0\">\n" +
                "    <d d1=\"101280101\" d2=\"广州\" d3=\"guangzhou\" d4=\"广东\"/>\n" +
                "    <d d1=\"101280102\" d2=\"番禺\" d3=\"panyu\" d4=\"广东\"/>\n" +
                "    <d d1=\"101280103\" d2=\"从化\" d3=\"conghua\" d4=\"广东\"/>\n" +
                "</c>";
        Object o = toBean(CityList.class, a);
        System.out.println(o);
    }
}
