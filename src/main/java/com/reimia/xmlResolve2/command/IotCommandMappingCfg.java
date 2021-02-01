package com.reimia.xmlResolve2.command;

import java.util.List;

public class IotCommandMappingCfg {
	public static final String CLASSNAME = "className";

	private String className;

	private List<IotMapCfg> mapList;

	public IotCommandMappingCfg(String className, List<IotMapCfg> mapList) {
		this.className = className;
		this.mapList = mapList;
	}


	public List<IotMapCfg> getMapList() {
		return mapList;
	}

	public String getClassName() {
		return className;
	}
}
