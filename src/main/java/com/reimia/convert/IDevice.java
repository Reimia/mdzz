package com.reimia.convert;

import java.util.Map;

/**
 * @author cwang
 */
public interface IDevice {

	String getDeviceServiceName();

	IDeviceManager getDeviceManager();

	/**
	 * @return 设备返回设备 ID，设备组返回设备服务 ID
	 */
	String getID();

	void preEventHandle(IEvent event);

	Map getDeviceInfos();

	Object getDeviceInfo(String name);
}
