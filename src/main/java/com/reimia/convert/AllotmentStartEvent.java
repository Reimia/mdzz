package com.reimia.convert;

import com.alibaba.fastjson.JSONArray;

public class AllotmentStartEvent extends AbsEvent {

	private JSONArray order;

	public JSONArray getOrder() {
		return order;
	}

	public void setOrder(JSONArray order) {
		this.order = order;
	}
}
