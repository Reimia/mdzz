package com.reimia.xmlResolve2.command;


import com.reimia.xmlResolve2.XmlUtil;
import org.dom4j.Document;
import org.dom4j.Element;
import org.slf4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cwang
 */
public class IotCommandMappingRootCfg {
	private File file;

	private Logger log;

	private static final String COMMAND_FIELD_PATH = "command";
	private static final String MAP_FIELD_PATH = "map";

	private List<IotCommandMappingCfg> commandList;

	public IotCommandMappingRootCfg(File file, Logger logger) throws Exception {
		this.file = file;
		this.log = logger;
		this.init();
	}

	@SuppressWarnings("unchecked")
	protected void init() throws Exception {
		try {
			if (this.file == null || !this.file.exists()) {
				this.getLog().error("command mapping config file not exist,initialize command mapping config failed!");
				return;
			}
			this.getLog().debug("Initialize command mapping config file [" + this.file.getAbsolutePath() + "]");
			Document doc = XmlUtil.createDocumentFromFile(this.file.getAbsolutePath());
			List<Element> rootElements = doc.selectNodes("root");
			if (rootElements.size() != 1) {
				this.getLog().error("Initialize command mapping config file [" + this.file.getAbsolutePath() + "] failed,mutiple elements [root] exist,please check the configuration and restart !");
				return;
			}
			Element root = rootElements.get(0);
			this.initPacket(root);
			this.getLog().debug("Initialize command mapping config file [" + this.file.getAbsolutePath() + "] completed !");
		} catch (Exception e) {
			this.getLog().error("Exception occured when application start,please check the configuration in file [" + this.file.getAbsolutePath() + "] and restart !", e);
			throw new Exception("command mapping config file init exception", e);
		}
	}

	@SuppressWarnings("unchecked")
	public void initPacket(Element rootElement) throws Exception {
		this.commandList = new ArrayList<>();
		try {
			List<Element> commandElements = rootElement.elements(IotCommandMappingRootCfg.COMMAND_FIELD_PATH);
			IotCommandMappingCfg iotCommandMappingCfg;
			for (Element eventElement : commandElements) {
				String className = eventElement.attributeValue(IotCommandMappingCfg.CLASSNAME);

				List<IotMapCfg> mapList = new ArrayList<>();
				List<Element> mapElements = eventElement.elements(IotCommandMappingRootCfg.MAP_FIELD_PATH);
				for (Element mapElement : mapElements) {
					String scopeFrom = mapElement.attributeValue(IotMapCfg.SCOPEFROM);
					String valueFrom = mapElement.attributeValue(IotMapCfg.VALUEFROM);
					String scopeTo = mapElement.attributeValue(IotMapCfg.SCOPETO);
					String valueTo = mapElement.attributeValue(IotMapCfg.VALUETO);

					IotMapCfg iotMapCfg = new IotMapCfg(scopeFrom, valueFrom, scopeTo, valueTo);
					mapList.add(iotMapCfg);
				}
				iotCommandMappingCfg = new IotCommandMappingCfg(className, mapList);
				this.commandList.add(iotCommandMappingCfg);
			}
		} catch (Exception e) {
			this.log.error("Exceptions in initializing command mapping config :", e);
			throw new Exception("Exceptions in initializing command mapping config :", e);
		}
	}

	public Logger getLog() {
		return log;
	}

	public List<IotCommandMappingCfg> getCommandList() {
		return commandList;
	}
}
