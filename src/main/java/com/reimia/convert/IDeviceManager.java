package com.reimia.convert;

import java.util.List;
import java.util.Map;

public interface IDeviceManager {

	/**
	 * 平台创建 IDeviceManager 时，会调用这个方法进行设备信息的初始化
	 *
	 * @return true 初始化成功，false 初始化失败
	 */
	boolean init() throws Exception;

	String getDeviceServiceID();

	void setDeviceServiceID(String id);

	AbsDeviceGroup getDeviceGroup();

	Map<String, IDevice> getDeviceMap();

	List<IDevice> getDeviceList();

	IDevice getDeviceByID(String id);


}
