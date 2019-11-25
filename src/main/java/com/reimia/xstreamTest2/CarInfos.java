package com.reimia.xstreamTest2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("carInfos")
public class CarInfos {
    @XStreamAsAttribute
    private String dwName;//对应carInfos元素的dwName属性

    @XStreamImplicit(itemFieldName = "carInfo")
    private List<CarInfo> carInfoList = new ArrayList<CarInfo>();//对应N个carInfo元素组成的集合

    public String getDwName() {
        return dwName;
    }

    public void setDwName(String dwName) {
        this.dwName = dwName;
    }

    public List<CarInfo> getCarInfoList() {
        return carInfoList;
    }

    public void setCarInfoList(List<CarInfo> carInfoList) {
        this.carInfoList = carInfoList;
    }
}
