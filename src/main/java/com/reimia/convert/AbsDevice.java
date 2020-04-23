package com.reimia.convert;

import java.io.Serializable;

public abstract class AbsDevice implements IDevice, Serializable {

	private String deviceServiceName;
	private String id;
	private IDeviceManager deviceManager;

	@Override
	public IDeviceManager getDeviceManager() {
		return deviceManager;
	}

	@Override
	public String getID() {
		return this.id;
	}

	public void setDeviceManager(IDeviceManager deviceManager) {
		this.deviceManager = deviceManager;
	}

	public void setID(String id) {
		this.id = id;
	}

	@Override
	public String getDeviceServiceName() {
		return deviceServiceName;
	}

	public void setDeviceServiceName(String deviceServiceName) {
		this.deviceServiceName = deviceServiceName;
	}
}
