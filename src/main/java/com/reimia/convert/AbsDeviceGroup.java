package com.reimia.convert;

import java.util.ArrayList;
import java.util.List;

/**
 * 设备逻辑分组，代表一组设备，给设备组发命令的时候，可以由一个设备或者一组设备处理
 *
 * @author cwang
 */
public abstract class AbsDeviceGroup extends AbsDevice {

	List<IDevice> deviceList = new ArrayList<>();

	@Override
	public String getID() {
		return this.getDeviceServiceName();
	}

	public List<IDevice> getDeviceList() {
		return deviceList;
	}
}
