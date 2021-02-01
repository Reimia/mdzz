package com.reimia.xmlResolve3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Test {

    public static void main(String[] args) throws Exception {
        Logger logger = LoggerFactory.getLogger(Test.class);
        File file = new File("src/main/resources/AllotmentPassBoxMove.xml");

        RuleRootCfg ruleRootCfg = new RuleRootCfg(file,logger);
        System.out.println(1);
    }

}
