package com.reimia.xmlResolve2;

import com.reimia.xmlResolve2.command.IotCommandMappingCfg;
import com.reimia.xmlResolve2.command.IotCommandMappingRootCfg;
import com.reimia.xmlResolve2.command.IotMapCfg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SolveTest {

    public static void main(String[] args) throws Exception {
        Logger logger = LoggerFactory.getLogger(SolveTest.class);
        File file = new File("src/main/resources/IotCommandMappingConfig.xml");
        IotCommandMappingRootCfg iotCommandMappingRootCfg = new IotCommandMappingRootCfg(file, logger);
        //check
        for (IotCommandMappingCfg iotCommandMappingCfg : iotCommandMappingRootCfg.getCommandList()) {
            String className = iotCommandMappingCfg.getClassName();
            List<IotMapCfg> mapList = iotCommandMappingCfg.getMapList();
            Class<?> aClass = Class.forName(className);
            Class<?> superclass = aClass.getSuperclass();
            if (superclass == null || !superclass.getName().contains("AbsCommand")){
                throw new Exception("command has no AbsCommand superclass");
            }
            Field[] declaredFields = aClass.getDeclaredFields();
            List<Field> fields = Arrays.asList(declaredFields);
            List<String> collect = fields.stream().map(Field::getName).collect(Collectors.toList());


            for (IotMapCfg iotMapCfg : mapList) {
                String scopeFrom = iotMapCfg.getScopeFrom();
                String valueFrom = iotMapCfg.getValueFrom();
                String scopeTo = iotMapCfg.getScopeTo();
                String valueTo = iotMapCfg.getValueTo();

                if ("Command".equalsIgnoreCase(scopeFrom)){
                    if (!collect.contains(valueFrom)){
                        throw new Exception("valueFrom do not match command class");
                    }
                }
            }
        }
        System.out.println("success check");
        //preview

    }

}
