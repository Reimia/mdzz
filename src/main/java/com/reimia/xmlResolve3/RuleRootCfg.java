package com.reimia.xmlResolve3;

import org.dom4j.Document;
import org.dom4j.Element;
import org.slf4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Reimia
 */
public class RuleRootCfg {

	private File file;

	private Logger log;

	private static final String RULE_FIELD_PATH = "rule";

	private List<RuleCfg> ruleList;

	public RuleRootCfg(File file, Logger log) throws Exception {
		this.file = file;
		this.log = log;
		this.init();
	}

	protected void init() throws Exception {
		try {
			if (this.file == null || !this.file.exists()) {
				this.getLog().error("rule config file not exist,initialize rule config failed!");
				return;
			}
			this.getLog().debug("Initialize rule config file [" + this.file.getAbsolutePath() + "]");
			Document doc = XmlUtil.createDocumentFromFile(this.file.getAbsolutePath());
			Element root = doc.getRootElement();
			this.initPacket(root);
			this.getLog().debug("Initialize rule config file [" + this.file.getAbsolutePath() + "] completed !");
		} catch (Exception e) {
			this.getLog().error("Exception occured when application start,please check the configuration in file [" + this.file.getAbsolutePath() + "] and restart !", e);
			throw new Exception("rule config file init exception", e);
		}
	}

	@SuppressWarnings("unchecked")
	private void initPacket(Element root) throws Exception {
		this.ruleList = new ArrayList<>();
		try {
			List<Element> elements = root.elements(RuleRootCfg.RULE_FIELD_PATH);
			RuleCfg ruleCfg;
			for (Element element : elements) {
				String id = element.attributeValue(RuleCfg.ID);
				String device = element.attributeValue(RuleCfg.DEVICE);
				String event = element.attributeValue(RuleCfg.EVENT);
				String groovyScript = element.getTextTrim();
				ruleCfg = new RuleCfg(id, device, event, groovyScript);
				ruleList.add(ruleCfg);
			}
		} catch (Exception e) {
			this.log.error("Exceptions in initializing rule config :", e);
			throw new Exception("Exceptions in initializing rule config :", e);
		}
	}

	public Logger getLog() {
		return log;
	}

	public List<RuleCfg> getRuleList() {
		return ruleList;
	}
}
