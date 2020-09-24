package com.reimia.convert;

import com.alibaba.fastjson.JSONArray;

public class AllotmentStartCommand extends AbsCommand {

	private JSONArray order;

	public JSONArray getOrder() {
		return order;
	}

	public void setOrder(JSONArray order) {
		this.order = order;
	}

	public AllotmentStartCommand(IDevice device) {
		super(device);
	}
}
