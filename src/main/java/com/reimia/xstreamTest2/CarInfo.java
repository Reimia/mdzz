package com.reimia.xstreamTest2;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.ArrayList;
import java.util.List;

public class CarInfo {
    @XStreamAsAttribute
    private String index;//对应carInfo的index属性

    @XStreamImplicit(itemFieldName = "attribute")
    private List<CarAttr> attrs = new ArrayList<CarAttr>();

    @XStreamImplicit(itemFieldName = "attribute")
    private List<String> attrsValue = new ArrayList<String>();

    public List<String> getAttrsValue() {
        return attrsValue;
    }

    public void setAttrsValue(List<String> attrsValue) {
        this.attrsValue = attrsValue;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public List<CarAttr> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<CarAttr> attrs) {
        this.attrs = attrs;
    }
}
