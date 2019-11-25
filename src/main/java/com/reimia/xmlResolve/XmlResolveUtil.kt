package com.reimia.xmlResolve

import org.dom4j.Attribute
import org.dom4j.Element
import org.dom4j.io.SAXReader
import java.io.File

class XmlResolveUtil(){
    fun resolveXml(url:String){


        val saxReader = SAXReader()
        val document = saxReader.read(File(url))
        val rootElement = document.rootElement
        val elementIterator = rootElement.elementIterator()
        for ((index,i) in elementIterator.withIndex()){
            val element = i as Element
//            println(element.name)
            i.attributes()
                    .map { it as Attribute }
                    .forEach {
                        println(it.name + " : " + it.value)

                    }
            for (k in i.elementIterator()) {
                k as Element
                k.attributes()
                        .map { it as Attribute }
                        .forEach {
                            println("  " + it.name + " : " + it.value)
                        }
            }
        }
    }
}
