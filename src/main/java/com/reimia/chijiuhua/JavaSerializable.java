package com.reimia.chijiuhua;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class JavaSerializable {
    /**
     * 持久化为XML对象
     *
     * @param obj
     * @param out
     */
    public void storeXML(Object obj, OutputStream out) {
        XMLEncoder encoder = new XMLEncoder(out);
        encoder.writeObject(obj);
        encoder.flush();
        encoder.close();
    }

    /**
     * 从XML中加载对象
     *
     * @param in
     * @return
     */
    public Object loadXML(InputStream in) {
        XMLDecoder decoder = new XMLDecoder(in);
        Object obj = decoder.readObject();
        decoder.close();
        return obj;
    }


    public static void main(String[] args) throws Exception {
        AllotmentBoxQueue.addLeftBox("123");
        AllotmentBoxQueue.addLeftBox("456");
        File xmlFile = new File("config/xmlFileTest.dat");
        JavaSerializable serializable = new JavaSerializable();
        serializable.storeXML(AllotmentBoxQueue.getLeftBoxQueue(), new FileOutputStream(xmlFile));
        System.out.println(serializable.loadXML(new FileInputStream(xmlFile)));
    }
}
