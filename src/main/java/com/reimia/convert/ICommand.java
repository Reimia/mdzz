package com.reimia.convert;

/**
 * @author cwang
 */
public interface ICommand {

	/**
	 * 获取上下文 ID，这个 ID 一般用来在异步交互中进行数据匹配
	 *
	 * @return
	 */
	String getContextID();

	/**
	 * 设置上下文 ID，这个 ID 一般用来在异步交互中进行数据匹配
	 */
	void setContextID(String contextID);

	/**
	 * 获取命令所属设备
	 *
	 * @return
	 */
	IDevice getDevice();

	/**
	 * 设置命令是否已被处理标识
	 *
	 * @param b
	 */
	void setIsProcessed(boolean b);

	/**
	 * 获取命令是否已被处理标识
	 *
	 * @return
	 */
	boolean getIsProcessed();

	/**
	 * 设置命令处理结果代码
	 *
	 * @param code
	 */
	void setProcessCode(String code);

	/**
	 * 获取命令处理结果代码
	 *
	 * @return
	 */
	String getProcessCode();

}
