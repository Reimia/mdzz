package com.reimia.xmlResolve2.command;

public class IotMapCfg {
	public static final String SCOPEFROM = "scopeFrom";
	public static final String VALUEFROM = "valueFrom";
	public static final String SCOPETO = "scopeTo";
	public static final String VALUETO = "valueTo";

	private String scopeFrom;
	private String valueFrom;
	private String scopeTo;
	private String valueTo;

	public IotMapCfg(String scopeFrom, String valueFrom, String scopeTo, String valueTo) {
		this.scopeFrom = scopeFrom;
		this.valueFrom = valueFrom;
		this.scopeTo = scopeTo;
		this.valueTo = valueTo;
	}

	public String getScopeFrom() {
		return scopeFrom;
	}

	public String getValueFrom() {
		return valueFrom;
	}

	public String getScopeTo() {
		return scopeTo;
	}

	public String getValueTo() {
		return valueTo;
	}
}
