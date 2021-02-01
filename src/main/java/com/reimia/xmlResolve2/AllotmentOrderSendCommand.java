package com.reimia.xmlResolve2;

import com.alibaba.fastjson.JSONObject;
import com.reimia.convert.IDevice;

/**
 * @author Reimia
 */
public class AllotmentOrderSendCommand extends AbsCommand{

	private JSONObject order;

	private JSONObject printInfo;

	public AllotmentOrderSendCommand(IDevice device) {
		super(device);
	}

	public JSONObject getOrder() {
		return order;
	}

	public void setOrder(JSONObject order) {
		this.order = order;
	}

	public JSONObject getPrintInfo() {
		return printInfo;
	}

	public void setPrintInfo(JSONObject printInfo) {
		this.printInfo = printInfo;
	}

}
