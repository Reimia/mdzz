package com.reimia.xstreamTest2;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.File;

public class Ceshi {

    public static void main(String[] args) throws Exception {
        String a =
                "<channel id=\"ATM\" autoStart=\"false\" timeout=\"30000\" description=\"ATM 渠道，短连接接入适配器标准8583报文，BPE 接出适配器\"> \n" +
                "  <threadPool> \n" +
                "    <property name=\"capacity\">70</property>  \n" +
                "    <property name=\"minThreadCount\">50</property>  \n" +
                "    <property name=\"maxThreadCount\">200</property>  \n" +
                "    <property name=\"keepAliveTime\">1200</property>  \n" +
                "    <property name=\"blockingQueueClass\">java.util.concurrent.ArrayBlockingQueue</property>  \n" +
                "    <property name=\"blockingNumber\">100</property>  \n" +
                "    <property name=\"unLockTime\">20</property>  \n" +
                "    <property name=\"tryInterval\">100</property>  \n" +
                "    <property name=\"tryTimes\">10</property>  \n" +
                "    <property name=\"busyTime\">20</property> \n" +
                "  </threadPool>  \n" +
                "  <header id=\"8583HEADER\" caption=\"8583报文头\" class=\"com.zjft.ucp.stdlib.header.UnionPayMsgHeader\" ctrlName=\"stdlib,通讯报文头,8583报文头\"> \n" +
                "    <property name=\"config\">ATM_Header_8583_Conf.xml</property> \n" +
                "  </header>  \n" +
                "  <header id=\"222\" caption=\"8583报文头\" class=\"com.zjft.ucp.stdlib.header.UnionPayMsgHeader\" ctrlName=\"stdlib,通讯报文头,8583报文头\"> \n" +
                "    <property name=\"config\"/> \n" +
                "  </header>  \n" +
                "  <header id=\"2222\" caption=\"通用标准报文头\" class=\"com.zjft.ucp.stdlib.header.StdMsgHeader\" ctrlName=\"stdlib,通讯报文头,通用标准报文头\"> \n" +
                "    <property name=\"config\"/> \n" +
                "  </header>  \n" +
                "  <inAdaptor id=\"ATM_INADAPTOR\" caption=\"TCP短连接接入适配器\" class=\"com.zjft.ucp.stdlib.inadaptor.socket.ShortSocketInAdaptor\" ctrlName=\"stdlib,接入适配器,TCP短连接接入适配器\">\n" +
                "    <property name=\"stopAdaptorWaitTime\">60000</property>\n" +
                "    <property name=\"port\">18967</property>\n" +
                "    <property name=\"timeOut\">60000</property>\n" +
                "    <property name=\"ip\">127.0.0.1</property>\n" +
                "  </inAdaptor>\n" +
                "  <outAdaptor id=\"ATM_OUTADAPTOR\" caption=\"BPE业务处理引擎接出适配器\" class=\"com.zjft.ucp.stdlib.outadaptor.mq.StdMQOutAdaptor\" ctrlName=\"stdlib,接出适配器,BPE业务处理引擎接出适配器\">\n" +
                "    <property name=\"stopAdaptorWaitTime\">60000</property>\n" +
                "  </outAdaptor>\n" +
                "  <outAdaptor id=\"5555\" caption=\"TCP异步长连接接出适配器\" class=\"com.zjft.ucp.stdlib.outadaptor.socket.AsynLongSocketOutAdator\" ctrlName=\"stdlib,接出适配器,TCP异步长连接接出适配器\">\n" +
                "    <property name=\"tradeMatchingCfg\">10</property>\n" +
                "    <property name=\"retServerIps\">127.0.0.1|127.0.0.1</property>\n" +
                "    <property name=\"soTimeOut\">60000</property>\n" +
                "    <property name=\"queueSize\">10</property>\n" +
                "    <property name=\"reconnectTimes\">5</property>\n" +
                "    <property name=\"packageType\">ISO8583|delimiter</property>\n" +
                "    <property name=\"preUnPackClass\">10</property>\n" +
                "    <property name=\"timeOut\">60000</property>\n" +
                "    <property name=\"serverIps\">127.0.0.1|127.0.0.1</property>\n" +
                "    <property name=\"reconnectTime\">60000</property>\n" +
                "    <property name=\"corePoolSize\">3</property>\n" +
                "    <property name=\"maximumPoolSize\">3</property>\n" +
                "    <property name=\"packetCfg\"/>\n" +
                "    <property name=\"serverPorts\">10000|10001</property>\n" +
                "    <property name=\"queueTimeOut\">60000</property>\n" +
                "    <property name=\"retServerPorts\">10002|10003</property>\n" +
                "    <property name=\"headerCfg\"/>\n" +
                "  </outAdaptor>\n" +
                "</channel>\n";
        XStream xstream = new XStream(new DomDriver());//创建Xstram对象
        xstream.autodetectAnnotations(true);
        xstream.processAnnotations(ZjIotChannelInfoBean.class);

        ZjIotChannelInfoBean zjIotChannelInfoBean = (ZjIotChannelInfoBean) xstream.fromXML(a);

        //将对象转为xml，再次打印
        String resultXml = xstream.toXML(zjIotChannelInfoBean);
        System.out.printf("=======================\n" + resultXml);
    }

}
