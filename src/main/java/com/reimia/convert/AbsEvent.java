package com.reimia.convert;

import java.io.Serializable;

public abstract class AbsEvent implements IEvent, Serializable {
	private IDevice device;
	private String contextID;
	private boolean isProcessed = false;
	private String processCode;

	@Override
	public IDevice getDevice() {
		return device;
	}

	@Override
	public void setDevice(IDevice device) {
		this.device = device;
	}

	@Override
	public String getContextID() {
		return contextID;
	}

	@Override
	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	@Override
	public void setIsProcessed(boolean b) {
		this.isProcessed = b;
	}

	@Override
	public boolean getIsProcessed() {
		return this.isProcessed;
	}

	@Override
	public void setProcessCode(String code) {
		this.processCode = code;
	}

	@Override
	public String getProcessCode() {
		return this.processCode;
	}
}
