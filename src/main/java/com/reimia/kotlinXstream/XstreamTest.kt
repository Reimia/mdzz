package com.reimia.kotlinXstream

import com.thoughtworks.xstream.XStream

class XstreamTest {

    fun toBean(clazz: Class<*>, xml: String): Any? {
        var xmlObject: Any? = null
        val xstream = XStream()
        xstream.processAnnotations(clazz)
        xstream.autodetectAnnotations(true)
        xstream.aliasSystemAttribute(null, "class")
        xmlObject = xstream.fromXML(xml)
        return xmlObject
    }
}