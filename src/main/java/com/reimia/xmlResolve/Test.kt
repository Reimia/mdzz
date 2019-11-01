package com.reimia.xmlResolve

object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        val xmlResolveUtil = XmlResolveUtil()
        xmlResolveUtil.resolveXml("D:\\source\\Iot_std_library\\stdlib\\app\\Cfg\\Components.xml")
    }
}
