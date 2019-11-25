package com.reimia.kotlinXstream

object Test {
    @JvmStatic
    fun main(args: Array<String>) {
        val XstreamTest = XstreamTest()
        val a = "<root>\n" +
                "  <group name=\"通讯组件\"> \n" +
                "    <control caption=\"TCP短连接通讯组件\" type=\"通讯处理\" class=\"comsadasdadadasda\" resource-id=\"asdakdhnaskdhahuihasidhuia\">\n" +
                "      <specialAttributes> \n" +
                "        <specAttribute name=\"adaptorType\" type=\"select\" value=\"inAdaptor|outAdaptor\" description=\"inAdaptor|outAdaptor\"/>  \n" +
                "        <specAttribute name=\"adaptor\" type=\"adaptorid\" value=\"\" description=\"填写适配器ID\"/>  \n" +
                "        <specAttribute name=\"operateMethod\" type=\"select\" value=\"send|recv|transfer\" description=\"send|recv|transfer\"/>  \n" +
                "        <specAttribute name=\"header\" type=\"headerid\" value=\"\" description=\"报文头ID\"/>  \n" +
                "        <specAttribute name=\"bodyData\" type=\"string\" value=\"bodyData\" description=\"数据存放的key值\"/>  \n" +
                "        <specAttribute name=\"recvMaxSize\" type=\"int\" value=\"32000\" description=\"能接收的数据的最大字节数\"/>  \n" +
                "        <specAttribute name=\"dynamicIP\" type=\"string\" value=\"\" description=\"后端渠道动态IP地址\"/>  \n" +
                "        <specAttribute name=\"dynamicPort\" type=\"string\" value=\"\" description=\"后端渠道动态端口号\"/> \n" +
                "      </specialAttributes>  \n" +
                "      <exit result=\"ok\" description=\"执行成功\"/>  \n" +
                "      <description>TCP短连接通讯组件： ［1］根据adaptorType是inAdaptor还是outAdaptor确定是接入还是接出处理 ［2］根据adaptor确定所需要使用的适配器 ［3］根据operateMethod确定是发送、接收还是交换（先发送再接收）处理 ［4］head对应需要使用的报文头配置文件名，发送报文需要根据配置文件组织报文头，接收报文需要根据报文头获取报文内容 ［5］bodyData用来存放接收的报文体字节流信息</description> \n" +
                "    </control>  \n" +
                "  </group>\n" +
                "</root>"
        val aaa = System.currentTimeMillis()
        val toBean = XstreamTest.toBean(ZjIotAllComponentBean::class.java, a) as ZjIotAllComponentBean

        val bbb = System.currentTimeMillis()
        val ccc= bbb-aaa
        print(toBean.toString())
    }
}