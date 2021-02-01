package com.reimia.xmlResolve3;

/**
 * @author Reimia
 */
public class RuleCfg {

	public static final String ID = "id";
	public static final String DEVICE = "device";
	public static final String EVENT = "event";

	private String id;

	private String device;

	private String event;

	private String groovyScript;

	public RuleCfg(String id, String device, String event) {
		this.id = id;
		this.device = device;
		this.event = event;
	}

	public RuleCfg(String id, String device, String event, String groovyScript) {
		this.id = id;
		this.device = device;
		this.event = event;
		this.groovyScript = groovyScript;
	}

	public String getId() {
		return id;
	}

	public String getDevice() {
		return device;
	}

	public String getEvent() {
		return event;
	}

	public String getGroovyScript() {
		return groovyScript;
	}
}
