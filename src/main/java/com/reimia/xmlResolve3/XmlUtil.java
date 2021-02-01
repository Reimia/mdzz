/**
 * XmlUtil.java
 * <p>
 * 功  能：XML工具类
 * 类  名：XmlUtil
 * <p>
 * version     date     author     content
 * ───────────────────────────────────────
 * V1.0.0  2016年1月11日    hqhan    creation
 * <p>
 * Copyright (c) 2016 ZJFT corporation All Rights Reserved.
 */
package com.reimia.xmlResolve3;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * XML工具类
 *
 * @author hqhan
 * @time 2016年1月11日下午1:42:34
 */
public class XmlUtil {

    /**
     * xml文件编码
     **/
    public static final String ENCODING = "UTF-8";

    /**
     * 创建xml内存树
     *
     * @return xml内存树
     * @author hqhan
     * @time 2016年1月11日下午1:46:16
     */
    public static Document createEmptyDocument() {
        return DocumentHelper.createDocument();
    }

    /**
     * xml文件 → xml内存树
     *
     * @param filePath
     * @return xml内存树
     * @throws Exception
     * @author hqhan
     * @time 2016年1月11日下午1:46:49
     */
    public static Document createDocumentFromFile(String filePath) throws Exception {
        if (filePath == null) {
            throw new Exception("parameter of filePath is null");
        }
        SAXReader saxReader = new SAXReader();
        return saxReader.read(new File(filePath));
    }

    /**
     * xml文本  → xml内存树
     *
     * @param xmlText
     * @return xml内存树
     * @throws Exception
     * @author hqhan
     * @time 2016年1月11日下午1:47:16
     */
    public static Document createDocumentFromText(String xmlText) throws Exception {
        if (xmlText == null) {
            throw new Exception("parameter of xmlText is null");
        }
        return DocumentHelper.parseText(xmlText);
    }

    /**
     * xml内存树 → xml文件
     *
     * @param document xml内存树
     * @param filePath 文件路径
     * @throws Exception
     */
    public static void saveDocumentToFile(Document document, String filePath) throws Exception {
        // create file if no such one
        File file = new File(filePath);
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        }
        // save document
        XMLWriter xmlWriter = null;
        try {
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding(XmlUtil.ENCODING);
            xmlWriter = new XMLWriter(new FileOutputStream(filePath), format);
            document.normalize();
            xmlWriter.write(document);
        } finally {
            try {
                if (xmlWriter != null) {
                    xmlWriter.close();
                    xmlWriter = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 删除指定元素所有的子元素
     *
     * @param element 指定元素
     */
    @SuppressWarnings("unchecked")
    public static void removeChildElements(Element element) {
        List<Element> childElements = element.elements();
        int childElementsSize = childElements.size();
        for (int i = 0; i < childElementsSize; i++) {
            element.remove(childElements.get(i));
        }
    }

    /**
     * 删除指定元素所有指定名称的子元素
     *
     * @param element          指定元素
     * @param childElementName 指定需要删除的子元素的名称
     */
    @SuppressWarnings("unchecked")
    public static void removeChildElements(Element element, String childElementName) {
        List<Element> childElements = element.elements(childElementName);
        int childElementsSize = childElements.size();
        for (int i = 0; i < childElementsSize; i++) {
            element.remove(childElements.get(i));
        }
    }

    /**
     * 给指定元素设置属性(属性名和属性值均非null)
     *
     * @param element        指定元素
     * @param attributeName  属性名
     * @param attributeValue 属性值
     */
    @SuppressWarnings("unchecked")
    public static void setAttribute(Element element, String attributeName, String attributeValue) {
        // do nothing if name or value of element is null
        if (attributeName == null || attributeValue == null) {
            return;
        }
        // if element already has attribute with name <code>attributeName</code>, 
        //  set its value with <code>attributeValue</code>
        List<Attribute> attributes = element.attributes();
        for (Attribute attribute : attributes) {
            if (attribute.getName().equals(attributeName)) {
                attribute.setValue(attributeValue);
                return;
            }
        }
        // element doesn't have any attribute with name <code>attributeName</code>, so add one
        element.addAttribute(attributeName, attributeValue);
    }

    /**
     * 根据xPath获取元素列表
     *
     * @param document
     * @param xPath
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<Element> selectElements(Document document, String xPath) {
        return document.selectNodes(xPath);
    }

    /**
     * 根据xPath获取单一元素
     *
     * @param document
     * @param xPath
     * @return
     */
    public static Element selectSingleElement(Document document, String xPath) {
        return (Element) document.selectSingleNode(xPath);
    }

    /**
     * 获取给定元素的所有子元素
     *
     * @param element 给定元素
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<Element> selectChildElements(Element element) {
        return element.elements();
    }

    /**
     * 获取给定元素的所有指定名称的子元素
     *
     * @param element          给定元素
     * @param childElementName 指定的子元素名称
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<Element> selectChildElements(Element element, String childElementName) {
        return element.elements(childElementName);
    }

    /**
     * 获取元素所有的属性值列表
     *
     * @param element
     * @return
     * @author hqhan
     * @time 2016年1月11日下午1:48:00
     */
    @SuppressWarnings("unchecked")
    public static List<Attribute> getAttributesOfElement(Element element) {
        return element.attributes();
    }

    /**
     * 根据属性名获取给定元素的属性值
     *
     * @param element       给定元素
     * @param attributeName 属性名
     * @return 属性不存在或属性值为空:空字符串; 否则:属性值
     */
    public static String getAttrValOfElement(Element element, String attributeName) {
        String attributeValue = element.attributeValue(attributeName);
        return attributeValue == null ? "" : attributeValue;
    }
}
