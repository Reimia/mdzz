package com.reimia.convert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbsDeviceManager implements IDeviceManager {

	private String deviceServiceID;
	private Map<String, IDevice> devices = new ConcurrentHashMap<>();

	@Override
	public String getDeviceServiceID() {
		return deviceServiceID;
	}

	@Override
	public void setDeviceServiceID(String deviceServiceID) {
		this.deviceServiceID = deviceServiceID;
	}

	@Override
	public List<IDevice> getDeviceList() {
		List<IDevice> devices = new ArrayList<>();
		for (String s : this.devices.keySet()) {
			devices.add(this.devices.get(s));
		}
		return devices;
	}

	@Override
	public Map<String, IDevice> getDeviceMap() {
		return this.devices;
	}

	@Override
	public IDevice getDeviceByID(String id) {
		return devices.get(id);
	}

}
